// You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].
public class find_xor {
    static int find(int x) {
        if (x % 4 == 0) {
            return x;
        }
        if (x % 4 == 1) {
            return 1;
        }
        if (x % 4 == 2) {
            return x + 1;
        }
        return 0;
    }

    static int findXOR(int l, int r) {
        return find(l - 1) ^ find(r);
    }

    public static void main(String[] args) {
        System.out.println(findXOR(3, 22));
    }
}
