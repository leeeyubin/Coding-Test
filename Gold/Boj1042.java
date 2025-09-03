import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int N, M, truePerson;
    static int[] trueNumber, parent, rank;
    static ArrayList<Integer>[] parties;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        truePerson = scanner.nextInt();

        trueNumber = new int[truePerson];
        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i < N + 1; i++) parent[i] = i;

        for (int i = 0; i < truePerson; i++) trueNumber[i] = scanner.nextInt();

        parties = new ArrayList[M];

        for (int i = 0; i < M; i++) parties[i] = new ArrayList<>();

        if (truePerson == 0) {
            for (int i = 0; i < M; i++) {
                int partyPersonTotal = scanner.nextInt();
                for (int j = 0; j < partyPersonTotal; j++) {
                    scanner.nextInt();
                }
            }
            System.out.println(M);
            return;
        }

        for (int i = 0; i < M; i++) {
            int partyPersonTotal = scanner.nextInt();
            int firstPerson = scanner.nextInt();
            parties[i].add(firstPerson);

            for (int j = 1; j < partyPersonTotal; j++) {
                int personNumber = scanner.nextInt();
                union(firstPerson, personNumber);
                parties[i].add(personNumber);
            }
        }

        Set<Integer> truthSet = new HashSet<>();
        for (int K : trueNumber) truthSet.add(find(K));

        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean exaggerate = true;
            for (int person : parties[i]) {
                if (truthSet.contains(find(person))) {
                    exaggerate = false;
                    break;
                }
            }
            if (exaggerate) result++;
        }

        System.out.println(result);

        scanner.close();
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }

    static void union(int x, int y) {
        int rankX = find(x);
        int rankY = find(y);

        if(rank[rankX] > rank[rankY]) {
            parent[rankY] = rankX;
        } else if(rank[rankX] < rank[rankY]) {
            parent[rankX] = rankY;
        } else {
            parent[rankY] = rankX;
            rank[rankX] = rank[rankX] + 1;
        }
    }
}
