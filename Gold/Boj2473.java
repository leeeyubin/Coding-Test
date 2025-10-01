import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            arrayList.add(input);
        }

        Collections.sort(arrayList);

        long bestAbs = Long.MAX_VALUE;
        long x = 0, y = 0, z = 0;

        for (int mid = 0; mid < N; mid++) {
            int start = mid + 1;
            int end = N - 1;

            while (start < end) {
                long sum = (long)arrayList.get(start) + arrayList.get(mid) + arrayList.get(end);
                long abs = Math.abs(sum);

                if (abs < bestAbs) {
                    bestAbs = abs;
                    x = arrayList.get(start);
                    y = arrayList.get(mid);
                    z = arrayList.get(end);
                    if (abs == 0) break;
                }

                if (sum < 0) start++;
                else end--;
            }
        }

        ArrayList<Long> result = new ArrayList<>();

        result.add(x);
        result.add(y);
        result.add(z);

        Collections.sort(result);

        for(int i = 0; i < 3; i++) {
            System.out.print(result.get(i));
            System.out.print(" ");
        }

        scanner.close();
    }
}
