package bit;

import java.util.Arrays;

public class CountBits {
    public int[] countBits(int num) {
        int[] f = new int[num +1];
        for (int i = 1; i <= num; i++) {
            f[i] = f[i>>1] + (i & 1);
        }
        return f;
    }

    public static void main(String[] args) {
        int m = 2;
        CountBits countBits = new CountBits();
        int[] r = countBits.countBits(m);
        System.out.println(Arrays.toString(r));
    }
}
