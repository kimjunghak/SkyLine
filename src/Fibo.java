import java.math.BigInteger;


/**
 * Created by kjh on 16. 10. 17.
 */
public class Fibo {

    double[] time;

    public BigInteger fibo_recursion(int number){
        if(number < 2) return new BigInteger(String.valueOf(number));
        return fibo_recursion(number - 1).add(fibo_recursion(number - 2));
    }

    public void fibo_Array(int number){
        BigInteger[] big_array = new BigInteger[number + 1];
        time = new double[number+1];

        big_array[0] = new BigInteger("0");
        big_array[1] = new BigInteger("1");

        for(int i=0 ; i <= number ; i++) {
            long start = System.nanoTime();
            if(i == 0 | i == 1)
                input_array(big_array, i);
            else{
                big_array[i] = big_array[i-1].add(big_array[i-2]);
                System.out.println("fibo("+i+") = "+big_array[i]);
            }
            long end = System.nanoTime();
            time[i] = (end - start) / Math.pow(10,9);
            System.out.printf("%.10f s\n", time[i]);
        }
        timePrint();
    }

    public BigInteger fibo_squaring(int number){
        if(number < 2) return new BigInteger(String.valueOf(number));
        BigInteger[] matrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
        return matrixPow(matrix, number)[1];
    }

    private BigInteger[] matrixPow(BigInteger[] matrix, int number) {
        if(number == 1) return matrix;

        if (number % 2 == 0)
            return matrixMultiply(matrixPow(matrix, number / 2), matrixPow(matrix, number / 2));

        else
            return matrixMultiply(matrixMultiply(matrixPow(matrix, (number - 1) / 2), matrixPow(matrix, (number - 1) / 2)), matrixPow(matrix, 1));


    }

    private BigInteger[] matrixMultiply(BigInteger[] matrix, BigInteger[] matrix2) {
        BigInteger[] result = {BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO};
        result[0] = matrix[0].multiply(matrix2[0]).add(matrix[1].multiply(matrix2[2]));
        result[1] = matrix[0].multiply(matrix2[1]).add(matrix[1].multiply(matrix2[3]));
        result[2] = matrix[2].multiply(matrix2[0]).add(matrix[3].multiply(matrix2[2]));
        result[3] = matrix[2].multiply(matrix2[1]).add(matrix[3].multiply(matrix2[3]));
        return result;
    }

    private void input_array(BigInteger[] big_array, int i) {
        big_array[i] = new BigInteger(String.valueOf(i));
        System.out.println("fibo("+i+") = "+big_array[i]);
    }

    public void timePrint(){
        for(int i=0 ; i<time.length ; i++)
            System.out.printf("%.10f\n", time[i]);
    }
}
