#!/bin/bash

# regular operators (<, >, ==) for bash

# (-lt, -gt, -eq, i.e. less than, greater than, equal to) for POSIX shells.
# POSIX does not support (()) used for arithmetic operations

read x
read y

if(("$x"<"$y")); then #';' Permits putting two or more commands on the same line.
    printf "X is less than Y"
elif(("$x">"$y")); then
    printf "X is greater than Y"
else
    printf "X is equal to Y"
fi