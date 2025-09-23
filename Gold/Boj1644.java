import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N + 1];

        // 에라토스테네스
        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) continue;

            for (int j = i * 2; j <= N; j += i) {
                arr[j] = 0;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (arr[i] != 0) primes.add(i);
        }

        int left = 0, right = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) count++;
                sum -= primes.get(left++);
            } else {
                if (right == primes.size()) break;
                sum += primes.get(right++);
            }
        }

        System.out.println(count);

        scanner.close();
    }
}
