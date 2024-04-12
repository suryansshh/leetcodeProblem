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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        q.offer(root);
        while(!q.isEmpty()){
            int n  = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i =0 ;i<n;i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                } 

            }
            if(flag){
                Collections.reverse(list);
            }
        ans.add(list);
        flag =!flag;
        }
        return ans;
    }
}