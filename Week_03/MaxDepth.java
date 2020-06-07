package recur;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4,new TreeNode(3),new TreeNode(6));
        TreeNode root = new TreeNode(5,left,right);
        System.out.println(root.toString());
        int r = maxDepth(root);
        System.out.println(r);
    }

    private static int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
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
