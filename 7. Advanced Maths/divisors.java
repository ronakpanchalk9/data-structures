// Given an integer N, print all the divisors of N in the ascending order.

public class divisors {
    static void print_divisors(int n) {
        int div = 1;
        int last = 0;
        while (div <= (n / div)) {
            if (n % div == 0) {
                System.out.print(div + " ");
                last = div;
            }
            div++;
        }

        div--;

        while (div > 0) {
            if (n % div == 0 && ((n / div) != last)) {
                System.out.print(n / div + " ");
            }
            div--;
        }
    }

    public static void main(String[] args) {
        print_divisors(20);
    }
}
