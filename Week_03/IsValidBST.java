package recur;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4,new TreeNode(3),new TreeNode(6));
        TreeNode root = new TreeNode(5,left,right);
        System.out.println(root.toString());
        boolean r = isValidBST(root,null,null);
        System.out.println(r);
    }

    private static boolean isValidBST(TreeNode root,Integer lower,Integer upper) {
        if(null == root){
            return true;
        }
        int value = root.val;
        if (lower != null && value <= lower){
            return false;
        }
        if(upper != null && value >= upper){
            return false;
        }
        if(! isValidBST(root.right,value,upper)){
            return false;
        }
        if (! isValidBST(root.left,lower,value)){
            return false;
        }
        return true;
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
}
