import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int total = 0;

        for (int end = 0; end < N; end++) {
            total += arr[end];

            while (total >= S) {
                min = Math.min(min, end - start + 1);
                total -= arr[start++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

        scanner.close();
    }

}
