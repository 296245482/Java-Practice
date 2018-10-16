package swordtooffer;

public class TreeIsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return symmetricalCore(pRoot.left, pRoot.right);
    }
    private boolean symmetricalCore(TreeNode left, TreeNode right){
        if(left == null){
            return right == null;
        }
        if(right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return symmetricalCore(left.left, right.right) && symmetricalCore(left.right, right.left);
    }
}
