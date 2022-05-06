package xulipro;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class DiningPhilosophers {
    static int philosophersNumber = 5;
    static Philosopher philosophers[] = new Philosopher[philosophersNumber];
    static Fork forks[] = new Fork[philosophersNumber];

    static class Fork {
        public Semaphore mutex = new Semaphore(1);
        void grab() {
            try {
                mutex.acquire();//
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        void release() {
            mutex.release();
        }
        boolean isFree() {
            return mutex.availablePermits() > 0;
        }
    }

    static class Philosopher extends Thread {
        public int number;
        public Fork leftFork;
        public Fork rightFork;

        Philosopher(int num, Fork left, Fork right) {
            number = num;
            leftFork = left;
            rightFork = right;
        }
        public void run() {

            System.out.println("Hi! I'm philosopher #" + (number+1));
            while (true) {
                leftFork.grab();
                System.out.println("Philosopher #" + (number+1) + " grabs left fork.");

                rightFork.grab();
                System.out.println("Philosopher #" + (number+1) + " grabs right fork.");
                eat();
                rightFork.release();
                System.out.println("Philosopher #" + (number+1) + " releases right fork.");

                leftFork.release();
                System.out.println("Philosopher #" + (number+1) + " releases left fork.");

            }
        }

        void eat() {
            try {
                int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
                System.out.println("Philosopher #"+ (number+1) + " eats for " + sleepTime);
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

    }

    public static void main(String argv[]) throws  Exception {
        System.out.println("Dining philosophers problem.");

        for (int i = 0; i < philosophersNumber; i++) {
            forks[i] = new Fork();
        }
        for (int i = 0; i < philosophersNumber; i++) {
            if (i == philosophersNumber - 1) {
                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(i, forks[(i + 1) % philosophersNumber], forks[i]);
            } else {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % philosophersNumber]);
            }
            philosophers[i].start();
        }
        while (true) {
            try {
                // sleep 1 sec
                Thread.sleep(1000);

                // check for deadlock
                boolean deadlock = true;
                for (Fork f : forks) {
                    if (f.isFree()) {
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock) {
                    Thread.sleep(10);
                    System.out.println("Hurray! There is a deadlock!");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        System.out.println("Bye!");
        System.exit(0);
    }
}