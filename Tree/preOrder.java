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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }
    public static void preOrder(TreeNode root, List<Integer> list){
        if(root!=null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
}
