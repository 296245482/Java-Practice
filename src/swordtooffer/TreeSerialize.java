package swordtooffer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树，都是前序序列
 */
public class TreeSerialize {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    private int i = -1;
    TreeNode Deserialize(String str) {
        i++;
        int len = str.length();
        if(i >= len){
            return null;
        }
        String[] strs = str.split(",");
        TreeNode node = null;
        if(!"#".equals(strs[i])){
            node = new TreeNode(Integer.valueOf(strs[i]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
