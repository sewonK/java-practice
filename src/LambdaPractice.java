@FunctionalInterface
interface MyFunction {
    int max(int a, int b);
}
public class LambdaPractice {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("더 큰 값은 = " + max(a, b));
        MyFunction function = (x, y)-> x > y ? x : y;
        System.out.println("더 큰 값은 = " + function.max(a, b));
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
