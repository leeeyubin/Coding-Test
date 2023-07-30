import java.io.*;
import java.util.*;
class Node {
    String action;
    int integer;

    Node(String action, int integer) {
        this.action = action;
        this.integer = integer;
    }
}
public class Boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        int[] answer = new int[n];

        for (int j = 0; j < n; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            int integer = 0;
            if (action.equals("push") && st.hasMoreTokens()) {
                integer = Integer.parseInt(st.nextToken());
            }
            queue.offer(new Node(action, integer));
        }

        int i = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.action.equals("push")) {
                stack.push(node.integer);
            } else if (node.action.equals("pop")) {
                if (!stack.isEmpty()) {
                    answer[i] = stack.pop();
                    i++;
                } else {
                    answer[i] = -1;
                    i++;
                }
            } else if (node.action.equals("size")) {
                answer[i] = stack.size();
                i++;
            } else if (node.action.equals("empty")) {
                answer[i] = stack.isEmpty() ? 1 : 0;
                i++;
            } else if (node.action.equals("top")) {
                if (!stack.isEmpty()) {
                    answer[i] = stack.peek();
                    i++;
                } else {
                    answer[i] = -1;
                    i++;
                }
            }
        }

        for (int k = 0; k < i; k++)
            System.out.println(answer[k]);
        br.close();
    }
}
