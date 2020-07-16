#!/bin/bash

read x
read y

#Arithmetic in shell is done with $ and double parentheses (( )) "$((expression))"
# (()) = arithmetic
# [[]] = pattern/string

# The -e flag enables interpretation of the  backslash-escaped characters in each STRING if we use echo
# instead we can just use printf

printf "$(($x+$y))\n$(($x-$y))\n$(($x*$y))\n$(($x/$y))" 

#echo "$(($x+$y))"
#echo "$(($x-$y))"
#echo "$(($x*$y))"
#echo "$(($x/$y))"