package recur;

public class Pow {
    public double pow(double x,long b){
        if (b==0){
            return 1;
        }
        if (b < 0 ){
            b = -b;
            x = 1/x;
        }
        return (b%2 == 0) ? pow(x*x,b/2) : x*pow(x*x,b/2);
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        double r = pow.pow(2,5);
        System.out.println(r);
    }
}
