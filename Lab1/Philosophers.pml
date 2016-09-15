#define NUM_PHIL 2

byte forks[NUM_PHIL];

proctype phil(int id) {
    /*int leftHand = id;
    int rightHand = (id == 0 -> NUM_PHIL - 1 : id - 1);
    */
    int first = (id == 0 -> 0 : id - 1);
    int second = (id == 0 -> NUM_PHIL - 1 : id);

    do
        ::  printf("Philisopher %d is thinking\n", id);

            atomic {
                (forks[first] == 0);
                forks[first]++;
            }
            
            atomic {
                (forks[second] == 0);
                forks[second]++;
            }

            assert(forks[first] == 1 && forks[second] == 1);
            printf("Philosopher %d is eating with fork %d and %d\n", id, first, second);
           
            forks[first]--;
            forks[second]--;
            
    od
}

init {
    int i = 0;

    do
        :: i >= NUM_PHIL -> break;
        :: else -> run phil(i); i++;
    od
}
