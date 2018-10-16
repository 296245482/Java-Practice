package swordtooffer;

import java.util.ArrayList;
import java.util.Iterator;

public class TreePrint {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);
        while (queue.size()!=0){
            Iterator<TreeNode> iter = queue.iterator();
            queue = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            while(iter.hasNext()){
                TreeNode item = iter.next();
                list.add(item.val);
                if(item.left != null){
                    queue.add(item.left);
                }
                if(item.right != null){
                    queue.add(item.right);
                }
            }
            res.add(list);
            list = new ArrayList<>();
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
        new TreePrint().Print(a);

    }
}
