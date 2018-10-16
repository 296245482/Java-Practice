package swordtooffer;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class TreePrintZHI {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        boolean leftToRight = true;
        while (queue.size() != 0) {
            ArrayList<Integer> list = new ArrayList<>();
            Iterator<TreeNode> iter = null;
            // 确定之字形的顺序
            if (leftToRight) {
                //从前往后遍历
                iter = queue.iterator();
            } else {
                //从后往前遍历
                iter = queue.descendingIterator();
            }
            // queue里保持顺序，每次记录都是顺序记录，便于下一次的保存
            Iterator<TreeNode> leftToRightIter = queue.iterator();
            queue = new LinkedList<>();
            while (iter.hasNext()) {
                TreeNode temp = iter.next();
                list.add(temp.val);
            }
            while (leftToRightIter.hasNext()) {
                TreeNode temp = leftToRightIter.next();
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        new TreePrintZHI().Print(a);

    }
}
