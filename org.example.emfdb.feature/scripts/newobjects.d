#!/usr/sbin/dtrace -qs

#pragma D option aggsize=8m
#pragma D option bufsize=8m
#pragma D option quiet
#pragma D option switchrate=10
#pragma D option jstackstrsize=16m

self int trace[int];

hotspot$target:::method-entry
/arg2 == 82 && copyinstr(arg1,82) == "org/eclipse/core/internal/databinding/property/value/MapSimpleValueObservableMap$1" &&
 arg4 == 17 && copyinstr(arg3,17) == "updateKnownValues" /
{
    self->trace[0]++;
}

hotspot$target:::object-alloc 
/ arg2 >= 1 && self->trace[0] > 0 /
/* arg2 > 11 && copyinstr(arg1,11) == "org/eclipse" && self->trace[0] */
{ 
    @totalobjects[copyinstr(arg1,arg2)] = count();
    @objectbytes[copyinstr(arg1,arg2)] = sum(arg3);
}

hotspot$target:::method-return
/arg2 == 82 && copyinstr(arg1,82) == "org/eclipse/core/internal/databinding/property/value/MapSimpleValueObservableMap$1" &&
 arg4 == 17 && copyinstr(arg3,17) == "updateKnownValues" &&
 self->trace[0] > 0 /
{
    self->trace[0]--;
}

profile:::tick-5sec
{
     printf("%-30s  %-15s  %-10s\n", "Class", 
                                     "Objects created", 
                                     "Bytes Allocated");

     printa("%-30s  %-15@d  %-10@d\n", @totalobjects, 
                                       @objectbytes);
     printf("\n");

     trunc(@totalobjects);
     trunc(@objectbytes);
}
