import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        ArrayList<int[]> arrayList = new ArrayList<>(M);

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            arrayList.add(new int[]{A, B, C});
        }

        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        Collections.sort(arrayList, (w1, w2) -> Integer.compare(w1[2], w2[2]));

        int result = 0;
        int maxWeight = 0;

        for (int i = 0; i < M; i++) {
            int[] node = arrayList.get(i);

            int a = node[0];
            int b = node[1];
            int c = node[2];

            if (find(a) != find(b)) {
                union(a, b);

                result += c;
                maxWeight = c;
            }
        }

        System.out.println(result - maxWeight);

        scanner.close();
    }

    static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[y] = x;
    }
}
