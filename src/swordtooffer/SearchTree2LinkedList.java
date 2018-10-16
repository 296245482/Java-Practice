package swordtooffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class SearchTree2LinkedList {
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree){
        convertSub(pRootOfTree);
        return realHead;
    }
    private void convertSub(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return;
        }
        convertSub(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
            realHead = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        convertSub(pRootOfTree.right);
    }
}
