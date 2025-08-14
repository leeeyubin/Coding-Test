import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] sum, dp;
    static int x1, y1, x2, y2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = scanner.nextInt();
        M = scanner.nextInt();

        sum = new int[M][4];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + scanner.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                sum[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int result = 0;

            x1 = sum[i][0];
            y1 = sum[i][1];
            x2 = sum[i][2];
            y2 = sum[i][3];

            for (int j = x1; j <= x2; j++) {
                result += (dp[j][y2] - dp[j][y1 - 1]);
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);

        scanner.close();
    }
}
