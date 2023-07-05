import java.io.*;
import java.util.*;
public class Boj2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int min = 0, max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max)
                max = arr[i];
        }

        while(min < max){
            int mid = (min + max) / 2;
            long sum = 0;
            for(int H : arr) {
                if (H - mid > 0) {
                    sum += (H - mid);
                }
            }
                if (sum < M)
                    max = mid;
                else min = mid + 1;
            }
            System.out.println(min - 1);

    }
}