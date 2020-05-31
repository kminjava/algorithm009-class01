package map;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2,right,null);
        TreeNode root = new TreeNode(1,null,left);
        System.out.println(root.toString());
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        System.out.println(ans.toString());
    }

    private static List<Integer> traversal(TreeNode root, List<Integer> ans) {
        if (root != null){
            if (root.left != null){
                traversal(root.left,ans);
            }
            ans.add(root.val);
            if (root.right != null){
                traversal(root.right,ans);
            }
        }
        return ans;
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
