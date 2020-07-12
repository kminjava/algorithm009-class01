package bit;

public class ReverseBits {
    public int reverseBits(int n){
        if (n == 0) return 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 00000010100101000;
        ReverseBits reverseBits = new ReverseBits();
        int r = reverseBits.reverseBits(n);
        System.out.println(r);
    }
}
