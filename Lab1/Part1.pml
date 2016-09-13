#define NUM_PHIL 2

byte forks[NUM_PHIL];

proctype phil(int id) {
    int leftHand = id;
    int rightHand = (id == 0 -> NUM_PHIL - 1 : id - 1);
    do
        ::  printf("Philisopher %d is thinking\n", id);
            /*assert(forks[leftHand] == 0);*/
            atomic {
                (forks[leftHand] == 0);
                forks[leftHand]++;
            }
            
            atomic {
                (forks[rightHand] == 0);
                forks[rightHand]++;
            }

            assert(forks[leftHand] == 1 && forks[rightHand] == 1);
            printf("Philosopher %d is eating with fork %d and %d\n", id, leftHand, rightHand);
           
            forks[leftHand]--;
            forks[rightHand]--;
            
    od
}

init {
    int i = 0;

    do
        :: i >= NUM_PHIL -> break;
        :: else -> run phil(i); i++;
    od
}
