import java.util.Scanner;

public class Main {

    static int MAX = 1_000_001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] arr = new int[N + 1];
        int[] index = new int[MAX];
        int[] result = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = scanner.nextInt();
            index[arr[i]] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = arr[i] * 2; j < MAX; j += arr[i]) {
                if (index[j] >= 1) {
                    result[i]++;
                    result[index[j]]--;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print(result[i] + " ");
        }

        scanner.close();
    }
}
