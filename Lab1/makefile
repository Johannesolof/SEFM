
liveness:
	spin -a $(file)
	gcc -o pan pan.c -DNOREDUCE
	./pan -a -f
	spin -t -p -l -g -r -s $(file)

saftey:
	
