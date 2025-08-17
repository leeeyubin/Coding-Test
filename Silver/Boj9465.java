import java.util.Scanner;

public class Main {

    static int T, N;
    static int[][] arr, dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        T = scanner.nextInt();

        for (int repeat = 0; repeat < T; repeat++) {
            N = scanner.nextInt();

            arr = new int[2][N];
            dp = new int[2][N];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if (N > 1) {
                dp[0][1] = arr[0][1] + dp[1][0];
                dp[1][1] = arr[1][1] + dp[0][0];
            }

            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }

            sb.append(Math.max(dp[0][N -1], dp[1][N -1])).append("\n");
        }

        System.out.println(sb);
        scanner.close();
    }
}
