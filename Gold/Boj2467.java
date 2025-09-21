import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int start = 0;
        int end = N - 1;
        int bestAbs = Integer.MAX_VALUE;
        int x = 0, y = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];
            int abs = Math.abs(sum);

            if (abs < bestAbs) {
                bestAbs = abs;
                x = arr[start];
                y = arr[end];
                if (bestAbs == 0) break;
            }

            if (sum < 0) start++;
            else end--;
        }

        System.out.println(x + " " + y);

        scanner.close();
    }
}
