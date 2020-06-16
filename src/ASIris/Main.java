package ASIris;

public class Main {

    public static void main(String[] args) {
	int[] numbers = new int[] {0,1,2,3,4,5};
	try {
        calc(numbers);
    } catch (ArithmeticException e) {
        System.out.println("Division by zero");
    }

        System.out.println("Program is normal end");
    }

    private static float calc(int[] numbers) {
        float result = 1;
        for (int i = numbers.length-1; i >= 0 ; i--) {
            result *= numbers[i];
            System.out.println(result);
        }
        return result;
    }
}


class ArrayWithZeroException extends Exception {

    public ArrayWithZeroException(String message) {
        super(message);
    }
}
