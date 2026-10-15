/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        int i = start;
        while (inorder[i] != root.val) {
            i++;
        }
        root.left = build(preorder, inorder, start, i - 1);
        root.right = build(preorder, inorder, i + 1, end);
        return root;
    }
}