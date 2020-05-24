package array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int n = 3;
        int[] nums2 = new int[]{2,5,6};
        int[] r = mergeSortedArray(nums1,m,nums2,n);
        System.out.println(Arrays.toString(r));
    }

    private static int[] mergeSortedArray(int[] nums1, int m,int[] nums2,int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n -1;
        while ((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = (nums1[p1] < nums2[p2] ) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
        return nums1;
    }
}
