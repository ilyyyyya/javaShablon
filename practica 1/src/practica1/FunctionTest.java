package practica1;

public class FunctionTest {
    public static void main(String[] args) {
        Function res;
        res = (n1,n2) -> {
            int gcd = 1;
            for (int i = 1; i <= n1 && i <= n2; i++) {
                if (n1 % i == 0 && n2 % i == 0) {
                    gcd = i;
                }
            }
            System.out.println(gcd);
        };
        int a = 10;
        int b = 30;
        res.gcd(a,b);
    }
}
