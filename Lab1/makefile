
liveness:
	spin -a $(file)
	gcc -o pan pan.c -DNOREDUCE
	./pan -a -f
	spin -t -p -l -g -r -s $(file)

saftey:
	spin -a $(file)
	gcc -DSAFETY -o pan pan.c
	./pan
	spin -t -p -l -g -r -s $(file)	
