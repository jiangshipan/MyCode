package offer2;public class TestEight {    public void Mirror(TreeNode root) {        if (root == null) {            return;        }        TreeNode temp = null;        if (root != null) {            temp = root.left;            root.left = root.right;            root.right = temp;        }        if (root.left != null) {            Mirror(root.left);        }        if (root.right != null) {            Mirror(root.right);        }    }}