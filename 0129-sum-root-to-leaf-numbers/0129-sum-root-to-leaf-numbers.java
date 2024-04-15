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
    public int sumNumbers(TreeNode root) {
        return helper(root , 0);
    }
    int helper(TreeNode root , int pathsum){
        if(root==null) return 0;
        pathsum=pathsum*10+root.val;
        if(root.left==null && root.right==null) return pathsum;
        int left = helper(root.left , pathsum);
        int right = helper(root.right , pathsum);
        return left+right;        

    }
}