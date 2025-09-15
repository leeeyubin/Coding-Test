import java.util.Scanner;

public class Main {

    static int MAX_VALUE = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] rgb = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = rgb[0][i];
        }

        int min = MAX_VALUE;

        for (int first = 0; first < 3; first++) {

            for (int k = 0; k < 3; k++) {
                dp[0][k] = (k == first) ? rgb[0][k] : MAX_VALUE;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

            for (int last = 0; last < 3; last++) {
                if (last == first) continue;
                min = Math.min(min, dp[N - 1][last]);
            }
        }

        System.out.println(min);

        scanner.close();
    }
}
