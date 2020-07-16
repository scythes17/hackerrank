#!/bin/bash

read c

if [[ "$c" == "Y" || "$c" == "y" ]]
#if [[ "$c" == [Yy] ]]
then
    printf "YES"
else 
    printf "NO"
fi