import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int answer = 0;

        while(B > A)  {
            if(B % 10 == 1) B = (B -1) / 10;
            else if (B % 2 == 0) B /= 2;
            else break;
            answer ++;
        }

        if(A == B) System.out.println(answer + 1);
        else System.out.println(-1);
    }

}
