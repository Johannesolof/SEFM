clean:
	rm _spin_nvr.tmp
	rm $(file).trail

liveness:
	spin -a $(file)
	gcc -o pan pan.c -DNOREDUCE
	./pan -a -f -N $(ltl)

saftey:
	spin -a $(file)
	gcc -DSAFETY -o pan pan.c
	./pan -N $(ltl)

trail:
	spin -t -p -l -g -r -s $(file)	
