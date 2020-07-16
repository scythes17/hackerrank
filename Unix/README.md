As unix is a bit unconventional, I'll be adding all UNIX programs on hackerrank as I solve them.
- Average
- comparingNumbers
- conditionals
- echo
- loops
- loopWithNumbers
- numberWorld
- personalizedEcho



#!/bin/bash for bash #!/bin/sh for sh
chmod +777 <filename> (with type).
first 7 = user permission for rwx
second 7 = group permission
third 7 = everyone else's

execute = ./<filename>.sh

It's a good habit to keep variables in "" and use $var like: printf "$var"

Bash doesn't allow spacing when working with variables, we have to write: c=4 and not c = 4

When comparing using [[]], give space eg: [[ "$c" == "Y" ]]
When comparing using (()), no need eg: (("$z"!="0")) or (i<10)

';' = shell command separator: Permits putting two or more commands on the same line.
eg: if(("$x"<"$y")); then
instead of: if(("$x"<"$y"))
            then

array declaration (size isn't needed) use '-a' before array_name

bash doesn't support float so we have to depend on mathlib (-l) and bc command

Use ctrl+D to tell terminal that you're done passing command line args