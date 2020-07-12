package bit;

public class HammingWeight {
    public int hammingWeight(int n){
        int ones = 0;
        while (n!=0){
            ones = ones + (n&1);
            n = n>>>1;
        }
        return ones;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        HammingWeight hammingWeight = new HammingWeight();
        int r = hammingWeight.hammingWeight(n);
        System.out.println(r);
    }
}
