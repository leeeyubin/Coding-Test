import java.util.Scanner;

public class Main {

    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(findMax(0, 0));

        scanner.close();
    }

    static int findMax(int depth, int pos) {
        if (N - 1 == depth) return dp[depth][pos];

        if (dp[depth][pos] == 0) {
            dp[depth][pos] = Math.max(findMax(depth + 1, pos), findMax(depth + 1, pos + 1)) + arr[depth][pos];
        }
        
        return dp[depth][pos];
    }
}
