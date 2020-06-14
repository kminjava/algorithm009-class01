package serach;

import java.util.ArrayList;
import java.util.List;

public class LargestValues {
    public List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res,0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null){
            return;
        }
        //expand list size
        if(d == res.size()){
            res.add(root.val);
        }else{
            //or set value
            res.set(d,Math.max(res.get(d),root.val));
        }
        helper(root.left,res,d+1);
        helper(root.right,res,d+1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode root = new TreeNode(3,left,right);
        System.out.println(root.toString());
        LargestValues largestValues = new LargestValues();
        List<Integer> r = largestValues.largestValues(root);
        System.out.println(r.toString());
    }
}
