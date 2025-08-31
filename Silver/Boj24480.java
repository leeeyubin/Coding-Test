import java.util.*;

public class Main {

    static int N, M, R;
    static ArrayList<Integer>[] arrayList;
    static int[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        R = scanner.nextInt();

        arrayList = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arrayList[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }

        scanner.close();
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack();
        stack.add(start);

        int count = 0;

        while (!stack.isEmpty()) {
            int top = stack.pop();

            if (visited[top] != 0) continue;

            visited[top] = ++count;

            for (int k : arrayList[top]) {
                if (visited[k] == 0) {
                    stack.push(k);
                }
            }
        }
    }
}
