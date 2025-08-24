import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = scanner.nextInt();
        }

        dp[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = arr[i] + dp[i - 1];
        }

        for (int k = 0; k < M; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            System.out.println(dp[j] - dp[i - 1]);
        }

        scanner.close();
    }
}
