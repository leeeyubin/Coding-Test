import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] arr, result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, 0);

        scanner.close();
    }

    static void dfs(int pos, int dept) {
        if (dept == M) {
            for (int k : result) {
                System.out.print(k + " ");
            }
            System.out.println();
            return;
        }

        int temp = 0;

        for (int i = pos; i < N; i++) {
            if (temp == arr[i]) continue;

            result[dept] = arr[i];
            temp = arr[i];

            dfs(i, dept + 1);
        }
    }
}
