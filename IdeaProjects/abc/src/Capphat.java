public class Capphat {
    static int P = 5;

    static int R = 3;

    static void calculateNeed(int need[][], int maxm[][], int allot[][]) {
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < R; j++) {
                need[i][j] = maxm[i][j] - allot[i][j];
            }
        }
    }

    static boolean isSafe(int processes[], int avail[], int maxm[][], int allot[][], int req[][]) {
        int[][] need = new int[P][R];

        calculateNeed(need, maxm, allot);

        boolean[] finish = new boolean[P];

        int[] safeSeq = new int[P];

        int[] work = new int[R];
        for (int i = 0; i < R; i++) {
            work[i] = avail[i];
        }

        for (int p = 0; p < P; p++) {
            for (int j = 0; j < R; j++) {
                if (req[p][j] > need[p][j]) {
                    System.out.println("vượt yêu cầu tối đa");
                    return false;
                }
            }
            for (int j = 0; j < R; j++) {
                if (req[p][j] > work[j]) {
                    System.out.println("Không đủ tài nguyên");
                    return false;
                }
            }
        }

        int count = 0;
        while (count < P) {
            boolean found = false;
            for (int p = 0; p < P; p++) {
                for (int i = 0; i < R; i++) {
                    work[i] = work[i] - req[p][i];
                    allot[p][i] = allot[p][i] + req[p][i];
                    need[p][i] = need[p][i] - req[p][i];
                }
                if (finish[p] == false) {
                    int j;
                    for (j = 0; j < R; j++) {
                        if (need[p][j] > work[j]) {
                            break;
                        }
                    }

                    if (j == R) {

                        for (int k = 0; k < R; k++) {
                            work[k] += allot[p][k];
                        }

                        safeSeq[count++] = p;

                        finish[p] = true;

                        found = true;
                    }
                }
            }

            if (found == false) {
                for (int p = 0; p < P; p++) {
                    for (int i = 0; i < R; i++) {
                        work[i] = work[i] + req[p][i];
                        allot[p][i] = allot[p][i] - req[p][i];
                        need[p][i] = need[p][i] + req[p][i];
                    }
                }
                System.out.print("System is not in safe state");
                return false;
            }
        }

        System.out.print("System is in safe state.\nSafe"
                + " sequence is: ");
        for (int i = 0; i < P; i++) {
            System.out.print(safeSeq[i] + " ");
        }
        return true;
    }

    public static void main(String[] argv) {
        int processes[] = {0, 1, 2, 3, 4};

        // Available instances of resources
        int avail[] = {3, 3, 2};

        // Maximum R that can be allocated
        // to processes
        int maxm[][] = {{7, 5, 3},
                {3, 2, 2},
                {9, 0, 2},
                {2, 2, 2},
                {4, 3, 3}};

        // Resources allocated to processes
        int allot[][] = {{0, 1, 0},
                {2, 0, 0},
                {3, 0, 2},
                {2, 1, 1},
                {0, 0, 2}};

        int req[][] = {{0, 0, 0},
                {1, 0, 2},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        // Check system is in safe state or not
        isSafe(processes, avail, maxm, allot, req);
    }
}