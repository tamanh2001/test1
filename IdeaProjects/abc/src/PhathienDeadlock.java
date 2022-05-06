import java.util.*;

class PhathienDeadlock {

    // Number of processes
    static int P = 5;

    // Number of resources
    static int R = 3;

    // Function to find the system is in safe state or not
    static boolean isSafe(int processes[], int avail[],  int allot[][], int req[][]) {
        // Mark all processes as infinish
        boolean[] finish = new boolean[P];

        // To store safe sequence
        int[] safeSeq = new int[P];

        // Make a copy of available resources
        int[] work = new int[R];
        for (int i = 0; i < R; i++) {
            work[i] = avail[i];
        }

        int count = 0;
        while (count < P) {

            boolean found = false;
            for (int p = 0; p < P; p++) {
                int dem=0;
                for (int j=0; j<R; j++) {
                    if (allot[p][j] == 0) {
                        dem++;
                        if (dem == R) {
                            finish[p] = true;
                            count++;
                        }
                    }
                }

                if (finish[p] == false) {

                    int j;
                    for (j = 0; j < R; j++) {
                        if (req[p][j] > work[j]) {
                            break;
                        }
                    }

                    if (j == R) {

                        for (int k = 0; k < R; k++) {
                            work[k] += allot[p][k];
                        }

                        // Add this process to safe sequence.
                        safeSeq[count++] = p;

                        // Mark this p as finished
                        finish[p] = true;

                        found = true;
                    }
                }
            }
            // If we could not find a next process in safe
            // sequence.
            if (found == false) {
                System.out.print("System is deadlocked");
                return false;
            }
        }

        // If system is in safe state then
        // safe sequence will be as below
        System.out.print("System is in safe state.\nSafe"
                + " sequence is: ");
        for (int i = 0; i < P; i++) {
            System.out.print(safeSeq[i] + " ");
        }

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        int processes[] = {0, 1, 2, 3, 4};

        // Available instances of resources
        int avail[] = {0, 0, 0};

        // Maximum R that can be allocated
        // to processes

        // Resources allocated to processes
        int allot[][] = {{0, 1, 0},
                {2, 0, 0},
                {3, 0, 3},
                {2, 1, 1},
                {0, 0, 2}};
        int req[][] = {{0, 0, 0},
                {2, 0, 2},
                {0, 0, 0},
                {1, 0, 0},
                {0, 0, 2}};
        // Check system is in safe state or not
        isSafe(processes, avail,  allot, req);
    }
}
