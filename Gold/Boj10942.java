import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int dp[][] = new int[N + 1][N + 1];
        int arr[] = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            int input = scanner.nextInt();
            arr[i] = input;

            for (int j = 1; j < i + 1; j++) {
                if (j == i) dp[j][i] = 1;
                else if (i - j == 1) dp[j][i] = (arr[i] == arr[j]) ? 1 : 0;
                else dp[j][i] = (arr[i] == arr[j] && dp[j + 1][i - 1] == 1) ? 1 : 0;
            }
        }

        StringBuilder result = new StringBuilder();

        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            result.append(dp[x][y]).append("\n");
        }

        System.out.println(result);
        scanner.close();
    }
}
