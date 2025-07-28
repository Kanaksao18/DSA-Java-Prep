/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        } 

        return left != null? left : right;
    }
}
// Operation	Complexity
// Time	O(N) — visits each node once
// Space	O(H) — recursion stack (H = height of tree)

//   ✅ When to Return:
// Return Value	Meaning
// null	Neither p nor q found in this subtree
// p or q	One node found
// LCA node	Both nodes found (in left and right subtree)
