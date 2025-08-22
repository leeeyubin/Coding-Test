import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static ArrayList<Integer>[] arr;
    static int[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        arr = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(visited[i]);
        }

        scanner.close();
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.add(start);

        while (!stack.empty()) {
            int top = stack.pop();

            for (int k : arr[top]) {
                if (visited[k] == 0) {
                    visited[k] = top;
                    stack.push(k);
                }
            }
        }
    }
}
