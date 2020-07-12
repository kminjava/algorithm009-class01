package bit;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n){
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x-1)) == 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        boolean r = isPowerOfTwo.isPowerOfTwo(32);
        System.out.println(r);
    }
}
