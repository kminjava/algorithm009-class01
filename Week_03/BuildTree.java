package recur;

public class BuildTree {
    public static void main(String[] args) {
        int[] preorder= {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode r = buildTree(preorder,inorder);
        System.out.println(r.toString());
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length - 1,preorder,inorder);
    }

    private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length -1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (inorder[i] == root.val){
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1,inStart,inIndex-1,preorder,inorder);
        root.right = helper(preStart + inIndex - inStart + 1,inIndex + 1,inEnd,preorder,inorder);
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
