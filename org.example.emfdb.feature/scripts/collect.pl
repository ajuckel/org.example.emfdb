#!/usr/bin/perl -w

use strict;
my @records = ();
while(<>) {
    my @fields = split /\s+/;
    if( scalar @fields == 3 ) {
        my ($name, $count, $bytes) = split /\s+/;
        push @records, { 'name' => $name, 'count' => $count, 'bytes' => $bytes };
    }
}

foreach my $sortkey ('bytes', 'count') {
    my $i = 0;
    print "=====RECORDS BY " . uc($sortkey) . "=====\n";
    foreach my $record (sort { $b->{$sortkey} <=> $a->{$sortkey} } @records) {
        print $record->{'name'} . "\t" . $record->{'count'} . "\t" . $record->{'bytes'} . "\n";
        last if $i++ > 10;
    }
}

my $total_bytes = 0;
# Really side-effecty, but I can't recall another way to do
# map-reduce in perl5...
map { $total_bytes += $_->{'bytes'} } @records;
print "Total bytes allocated during updateKnownValues(): " . $total_bytes . "\n"; 
