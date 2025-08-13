import java.util.Scanner;

public class Main {

    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        arr = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }
        
        for (int i = 1; i < N; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int min = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));

        System.out.println(min);

        scanner.close();
    }
}
