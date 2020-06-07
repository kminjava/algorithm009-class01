package recur;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        TreeNode right = new TreeNode(7,new TreeNode(6),new TreeNode(9));
        TreeNode root = new TreeNode(4,left,right);
        System.out.println(root.toString());
        TreeNode result = invertTree(root);
        System.out.println(result.toString());
    }

    private static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
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
