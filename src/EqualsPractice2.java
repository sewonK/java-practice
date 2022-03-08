public class EqualsPractice2 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println(a.equals(b));

        String c = new String("abc");
        System.out.println(a.equals(c));
    }
}
