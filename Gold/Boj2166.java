import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long[][] arr = new long[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        double sumA = 0;
        double sumB = 0;

        for (int i = 0; i < N; i++) {
            sumA += (arr[i][0] * arr[(i + 1) % N][1]);
            sumB += (arr[i][1] * arr[(i + 1) % N][0]);
        }

        System.out.printf("%.1f", Math.abs((sumA - sumB) / 2));

        scanner.close();
    }
}
