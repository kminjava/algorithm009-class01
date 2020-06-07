package recur;

public class MajorityElement {
    public int majorityElement(int[] num){
        int major = num[0],count = 1;
        for(int i =1;i<num.length;i++){
            if (count == 0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count --;
        }
        return major;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1,1,2,2};
        int r = majorityElement.majorityElement(nums);
        System.out.println(r);
    }

}
