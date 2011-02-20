#!/usr/sbin/dtrace -qs

#pragma D option bufsize=16m
#pragma D option quiet
#pragma D option switchrate=10

hotspot$target:::object-alloc
/ arg2 == 58 && copyinstr(arg1,arg2) == "org/eclipse/core/internal/databinding/identity/IdentitySet" /
{
    print "starting stack";
       jstack();
    print "ending stack";
}