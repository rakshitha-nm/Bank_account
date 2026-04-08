public class Calculator1 {

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        return a / b;
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Addition: " + calc.add(10,5));
        System.out.println("Subtraction: " + calc.subtract(10,5));
        System.out.println("Multiplication: " + calc.multiply(10,5));
        System.out.println("Division: " + calc.divide(10,5));
    }
}
