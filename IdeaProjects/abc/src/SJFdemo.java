
import java.util.*;

public class SJFdemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of process:");
        int n = sc.nextInt();
        int processId[] = new int[n];
        int arrivalTime[] = new int[n];
        int burstTime[] = new int[n];
        int endTime[] = new int[n];
        int arroundTime[] = new int[n];
        int waitingTime[] = new int[n];
        int check[] = new int[n]; //check neu da chay xong
        int systemTime = 0;
        int total = 0; //so process da chay
        float avgwaitingTime = 0, avgTurnArround = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("enter process " + (i + 1) + " arrival time:");
            arroundTime[i] = sc.nextInt();
            System.out.println("enter process " + (i + 1) + " brust time:");
            burstTime[i] = sc.nextInt();
            processId[i] = i + 1;
            check[i] = 0; //not complete
        }

        boolean test = true;
        while (true) {
            int c = n, min = 999;
            if (total == n) //so process da chay = so process nhap vao
                break;

            for (int i = 0; i < n; i++) {
				/*
				 thơi gian den cua process thu i < thoi gian hien tai cua he thong, check thi thay chua chay
				 burst time < min -> dem ra chay
				 */
                if ((arrivalTime[i] <= systemTime) && (check[i] == 0) && (burstTime[i] < min)) {
                    min = burstTime[i];
                    c = i;
                }
            }

            /* c = n tuc la k con process nao trong thoi gian hien tai cua he thong -> tang tgian he thong len 1 */
            if (c == n)
                systemTime += 1;
            else {
                endTime[c] = systemTime + burstTime[c];
                systemTime += burstTime[c];
                arroundTime[c] = endTime[c] - arrivalTime[c];
                waitingTime[c] = arroundTime[c] - burstTime[c];
                check[c] = 1;
                total++;
            }
        }
        System.out.println("\n\nTable:\n");
        System.out.println("ID arr bur end turn wait");
        for (int i = 0; i < n; i++) {
            avgwaitingTime += waitingTime[i];
            avgTurnArround += arroundTime[i];
            System.out.println(processId[i] + "\t" + arrivalTime[i] + "\t" + burstTime[i] + "\t" + endTime[i] + "\t" + arroundTime[i] + "\t" + waitingTime[i]);
        }
        System.out.println("\naverage turn arround time is " + (float) (avgTurnArround / n));
        System.out.println("average waiting time is " + (float) (avgwaitingTime / n));
        sc.close();
    }
}
