
liveness:
	rm $(file).trail
	spin -a $(file)
	gcc -o pan pan.c -DNOREDUCE
	./pan -a -f -N $(ltl)
	spin -t -p -l -g -r -s $(file)

saftey:
	rm $(file).trail
	spin -a $(file)
	gcc -DSAFETY -o pan pan.c
	./pan -N $(ltl)
	spin -t -p -l -g -r -s $(file)	
