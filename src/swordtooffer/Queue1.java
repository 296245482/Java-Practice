package swordtooffer;

import java.util.ArrayList;


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Queue1 {
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println(PrintFromTopToBottom(a));
    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> printList = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0){
            printList.add(queue.get(0).val);
            TreeNode temp = queue.remove(0);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return printList;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
