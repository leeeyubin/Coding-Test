import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            W[i] = scanner.nextInt();
            V[i] = scanner.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);

        scanner.close();
    }
}
