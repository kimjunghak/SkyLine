import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kjh on 16. 10. 17.
 */
public class Fibo_Test {
    public static void main(String[] args){
        Fibo fibo = new Fibo();
        Scanner scan = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int number = scan.nextInt();

        System.out.println("1. Recursion");
        System.out.println("2. Array");
        System.out.println("3. Recursive squaring");

        int select = scan.nextInt();
        switch (select) {
            case 1:
                for (int i = 0; i <= number; i++) {
                    long start = System.nanoTime();
                    System.out.println("fibo(" + i + ") = " + fibo.fibo_recursion(i));
                    long end = System.nanoTime();
                    System.out.printf("%.10f s\n", (end - start) / Math.pow(10, 9));
                }
                break;

            case 2:
                fibo.fibo_Array(number);
                break;

            case 3:
                for(int j = 0 ; j <= number ; j++) {
                    long start = System.nanoTime();
                    System.out.println("fibo(" + j + ") = " + fibo.fibo_squaring(j));
                    long end = System.nanoTime();
                    System.out.printf("%.10f s\n", (end - start) / Math.pow(10, 9));
                }
                break;

            default:
                System.out.println("잘못된 값을 입력 하셨습니다.");
                break;
        }
    }
}
