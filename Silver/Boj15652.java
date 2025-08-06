import java.util.Scanner;

public class Main {
    public static int N;
    public static int M;

    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[M];

        dfs(1, 0);
    }

    public static void dfs(int position, int dept) {
        if (dept == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = position; i <= N; i++) {
            arr[dept] = i;
            dfs(i, dept + 1);
        }
    }
}
