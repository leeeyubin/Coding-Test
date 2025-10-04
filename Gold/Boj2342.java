import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static ArrayList<Integer> arrayList;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        arrayList = new ArrayList<>();

        while (true) {
            int input = scanner.nextInt();
            if (input == 0) break;

            arrayList.add(input);
        }

        dp = new int[arrayList.size()][5][5];

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int result = search(0, 0, 0);

        System.out.println(result);
        scanner.close();
    }

    static int search(int index, int left, int right) {
        if (index == arrayList.size()) return 0;
        if (dp[index][left][right] != -1) return dp[index][left][right];

        int next = arrayList.get(index);

        dp[index][left][right] = Math.min(
                search(index + 1, next, right) + move(left, next),
                search(index + 1, left, next) + move(right, next)
        );

        return dp[index][left][right];
    }

    static int move(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}
