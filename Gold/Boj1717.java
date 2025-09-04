import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int calculate = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (calculate == 0) {
                union(a, b);
            } else if (calculate == 1) {
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

        scanner.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[y] = x;
    }
}
