#!/bin/bash

for ((c=1;c<100;c++))
do  
    z=$(($c%2)) # while assigning don't use space
    if (("$z"!="0")) #while comparing use space
    then
        printf "$c\n"
    fi
done
