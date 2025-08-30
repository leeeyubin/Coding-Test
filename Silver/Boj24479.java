import java.util.*;

public class Main {

    static int N, M, R;
    static ArrayList<Integer>[] arrayLists;
    static int[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        R = scanner.nextInt();

        arrayLists = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arrayLists[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
        
        scanner.close();
    }

    static void dfs(int R) {
        Stack<Integer> stack = new Stack<>();
        stack.add(R);
        int count = 0;

        while (!stack.isEmpty()) {
            int top = stack.pop();

            if (visited[top] != 0) continue;

            visited[top] = ++count;

            List<Integer> list = arrayLists[top];
            for (int i = list.size() - 1; i >= 0; i--) {
                int node = list.get(i);
                if (visited[node] == 0) stack.push(node);
            }

        }
    }
}
