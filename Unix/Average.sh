#!/bin/bash

read n

declare -a arr #array declaration (size isn't needed) use '-a' before array_name
sum=0

for((i=0;i<n;i++))
do
    read temp
    arr[i]="$temp"
    sum=$(("$sum"+"$temp"))
done
re=$(echo "$sum"/"$n" | bc -l)
printf "%.3f" "$re"
# bash doesn't support float so we have to depend on mathlib (-l) and bc command