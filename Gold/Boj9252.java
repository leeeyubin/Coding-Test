import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] str1, str2;
        int[][] dp;

        str1 = scanner.nextLine().toCharArray();
        str2 = scanner.nextLine().toCharArray();

        dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i < str1.length + 1; i++) {
            for (int j = 1; j < str2.length + 1; j++) {
                if (str1[i - 1] == str2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder common = new StringBuilder();

        int a = str1.length;
        int b = str2.length;

        while (a > 0 && b > 0) {
            if (str1[a - 1] == str2[b - 1]) {
                common.append(str1[a - 1]);
                a--;
                b--;
            } else if (dp[a - 1][b] >= dp[a][b - 1]) {
                a--;
            } else {
                b--;
            }
        }

        System.out.println(dp[str1.length][str2.length]);
        if (common.length() > 0) System.out.println(common.reverse());

        scanner.close();
    }
}
