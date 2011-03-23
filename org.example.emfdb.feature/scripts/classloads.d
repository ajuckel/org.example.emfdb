#!/usr/sbin/dtrace -qs

#pragma D option aggsize=8m
#pragma D option bufsize=8m
#pragma D option quiet
#pragma D option switchrate=10
#pragma D option jstackstrsize=16m

self int trace[int];

hotspot$target:::class-loaded
{
    printf("Loading class: %s\n", copyinstr(arg0,arg1));
}
