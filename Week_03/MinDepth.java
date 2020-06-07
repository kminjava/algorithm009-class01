package recur;

public class MinDepth {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4,new TreeNode(3),new TreeNode(6));
        TreeNode root = new TreeNode(5,left,right);
        System.out.println(root.toString());
        int r = minDepth(root);
        System.out.println(r);
    }

    private static int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 :Math.min(left,right) + 1;
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
