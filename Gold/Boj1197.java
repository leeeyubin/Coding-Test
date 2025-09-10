import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int V, E;
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        V = scanner.nextInt();
        E = scanner.nextInt();

        ArrayList<int[]> arrayList = new ArrayList<>(E);
        parent = new int[V + 1];

        for (int i = 0; i < E; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            arrayList.add(new int[]{A, B, C});
        }

        Collections.sort(arrayList, (w1, w2) -> Integer.compare(w1[2], w2[2]));

        for (int i = 0; i < V + 1; i++) parent[i] = i;

        int result = 0;

        for (int i = 0; i < E; i++) {
            int[] node = arrayList.get(i);

            int start = node[0];
            int end = node[1];
            int weight = node[2];

            if (find(start) != find(end)) {
                union(start, end);
                result += weight;
            }
        }

        System.out.println(result);

        scanner.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[y] = x;
    }
}
