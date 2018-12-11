#! /bin/bash
	i=0
	while read line
	do
    		array[ $i ]="$line"        
    		(( i++ ))
	done < <(ls -ls)
	printf '%s\n' "${array[@]}"
