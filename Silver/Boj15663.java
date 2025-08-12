import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] arr, result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            if (0 < i && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

            result[depth] = arr[i];
            visited[i] = true;

            dfs(depth + 1);

            visited[i] = false;
        }
    }
}
