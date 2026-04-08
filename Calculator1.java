public class Calculator1 {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        int result = c.add(2,3);
        System.out.println("Result: " + result);
    }
}
