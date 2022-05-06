import java.text.ParseException;

public class RR {
    // Function to find the waiting time for all  processes
    static void findWaitingTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        // calculating waiting time
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
        }
    }

    // Function to calculate turn around time
    static void findTurnAroundTime(int processes[], int n, int ct[], int tat[]) {
        // calculating turnaround time by adding  bt[i] + wt[i]
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - 0;
        }
    }

    //Function to calculate average time
    static void findavgTime(int processes[], int n, int bt[], int ct[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        //Function to find turn around time for all processes
        findTurnAroundTime(processes, n, ct, tat);

        //Function to find waiting time of all processes
        findWaitingTime(processes, n, bt, wt, tat);

        //Display processes along with all details
        System.out.printf("(Processes) (Burst time) (Waiting time) (Turn around time)\n");

        // Calculate total waiting time and total turn  around time
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("          %d ", bt[i]);
            System.out.printf("             %d", wt[i]);
            System.out.printf("              %d\n", tat[i]);
        }
        float s = (float)total_wt /(float) n;
        int t = total_tat / n;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }

    public static void main(String[] args) throws ParseException {
        //process id's
        int processes[] = {1, 2, 3, 4, 5};
        int n = processes.length;
        int quantum_time = 20;
        //Burst time of each process
        int burst_time[] = {11, 7, 19, 4, 9};
        int burst_remain_time[] = {11, 7, 19, 4, 9};
        int completed_time[] = new int[n];
        int completed = 0;
        int now = 0;
        while (completed != n) {
            for (int i = 0; i < n; i++) {
                if (burst_remain_time[i] > 0) {
                    if (burst_remain_time[i] > quantum_time) {
                        now = now + quantum_time;
                        burst_remain_time[i] = burst_remain_time[i] - quantum_time;
                    }
                    else if (burst_remain_time[i] <= quantum_time) {
                        now = now + burst_remain_time[i];
                        burst_remain_time[i] = 0;
                        completed_time[i] = now;
                        completed++;
                    }
                }
            }
        }
        findavgTime(processes, n, burst_time, completed_time);
    }
}

