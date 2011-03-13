#!/usr/sbin/dtrace -qs

#pragma D option bufsize=16m
#pragma D option quiet
#pragma D option switchrate=10
#pragma D option jstackstrsize=2048

BEGIN
{
      self->trace = 0;
}

hotspot$target:::method-entry
/ arg2 == 82 && copyinstr(arg1,82) == "org/eclipse/core/internal/databinding/property/value/MapSimpleValueObservableMap$1" &&
 arg4 == 17 && copyinstr(arg3,17) == "updateKnownValues" /
{
    self->trace++;
}

hotspot$target:::object-alloc 
/ self->trace > 0 /
{
    @totalobjects[copyinstr(arg1,arg2)] = count();
    @objectbytes[copyinstr(arg1,arg2)] = sum(arg3);
    @stacks[jstack(20)] = count();
}

hotspot$target:::method-return
/* arg2 == 82 && copyinstr(arg1,82) == "org/eclipse/core/internal/databinding/property/value/MapSimpleValueObservableMap$1" &&
 arg4 == 17 && copyinstr(arg3,17) == "updateKnownValues" */
/ arg2 == 82 && arg4 == 17 /
{
    self->trace--;
}

END
{
    printf("Stacks\n");
    printa(@stacks);
    printf("%-30s  %-15s  %-10s\n", "Class", "Objects created", "Bytes Allocated");
    printa("%-30s  %-15@d  %-10@d\n", @totalobjects, @objectbytes);
    printf("\n");
}
