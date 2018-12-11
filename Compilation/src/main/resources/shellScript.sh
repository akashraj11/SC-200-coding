    #! /bin/bash
	javac $1/$2.java |& tee output.txt
	java -cp "$1:." $2 |& tee output1.txt	
	echo (cat output.txt)
	echo (cat output1.txt)
	
