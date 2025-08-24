import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String name = scanner.next();
                String category = scanner.next();

                if (map.containsKey(category)) {
                    int value = map.get(category);
                    value += 1;
                    map.put(category, value);
                } else {
                    map.put(category, 1);
                }
            }

            int result = 1;

            for (int k : map.values()) {
                result *= (k + 1);
            }

            System.out.println(result - 1);
        }

        scanner.close();
    }
}
