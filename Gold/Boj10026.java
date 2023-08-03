import java.util.*;

public class Boj10026 {

    static int[] xPos = {1, -1, 0, 0};
    static int[] yPos = {0, 0, 1, -1};
    static int N;

    static boolean[][] visited;
    static String[][] arr;
    public static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        static boolean isValid(int x, int y) {
            return 0 <= x && x < N && 0 <= y && y < N;
        }
    }

    public static void visitSingleColor(int x, int y, String color) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Position front = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = front.x + xPos[i];
                int ny = front.y + yPos[i];

                if (Position.isValid(nx, ny)) {
                    if (!visited[ny][nx] && arr[ny][nx].equals(color)) {
                        visited[ny][nx] = true;
                        queue.add(new Position(nx, ny));
                    }
                }
            }
        }
    }
    private static void visitMultiColor(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Position front = queue.remove();

            for (int i = 0; i < 4; i++) {
                int xx = front.x + xPos[i];
                int yy = front.y + yPos[i];

                if (Position.isValid(xx, yy)) {
                    if (!visited[yy][xx] && (arr[yy][xx].equals("R") || arr[yy][xx].equals("G"))) {
                        visited[yy][xx] = true;
                        queue.add(new Position(xx, yy));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = scanner.next().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp[j];
            }
        }

        int case1 = 0;
        int case2 = 0;

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j].equals("R")) {
                        visitSingleColor(j, i, "R");
                        case1++;
                    } else if (arr[i][j].equals("G")) {
                        visitSingleColor(j, i, "G");
                        case1++;
                    } else if (arr[i][j].equals("B")) {
                        visitSingleColor(j, i, "B");
                        case1++;
                    }
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j].equals("R") || arr[i][j].equals("G")) {
                        visitMultiColor(j, i);
                        case2++;
                    } else if (arr[i][j].equals("B")) {
                        visitSingleColor(j, i, "B");
                        case2++;
                    }
                }
            }
        }

        System.out.println(case1 + " " + case2);

        scanner.close();
    }
}
