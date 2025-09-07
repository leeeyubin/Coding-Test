import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int C = scanner.nextInt();
        int N = scanner.nextInt();

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            V[i] = scanner.nextInt();
            W[i] = scanner.nextInt();
        }

        int MAX_CUSTOMER = 100;
        int MAX_C = C + MAX_CUSTOMER;
        int INT_MAX = 1_000_000_000;

        int[][] dp = new int[N + 1][MAX_C + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], INT_MAX);
            dp[i][0] = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < MAX_C + 1; j++) {
                dp[i][j] = dp[i - 1][j];

                if (W[i] <= j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - W[i]] + V[i]);
                }
            }
        }

        int result = INT_MAX;

        for (int i = C; i < MAX_C + 1; i++) {
            result = Math.min(result, dp[N][i]);
        }

        System.out.println(result);

        scanner.close();
    }
}
