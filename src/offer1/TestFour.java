package offer1;import java.util.ArrayList;import java.util.List;/** * 重建二叉树 */public class TestFour {    public static void main(String[] args) {        int[] pre = {1,2,4,7,3,5,6,8};        int[] in = {4,7,2,1,5,3,8,6};        reConstructBinaryTree(pre, in);    }    //todo 在理解理解    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {       if (pre.length == 0) {            return null;       }       TreeNode head = new TreeNode(pre[0]);       List<Integer> left_pre = new ArrayList<>();       List<Integer> right_pre = new ArrayList<>();       List<Integer> left_in = new ArrayList<>();       List<Integer> right_in = new ArrayList<>();       int root = 0;       for(int i = 0; i < in.length; i++) {           if (in[i] == pre[0]) {                root = i;                break;           }       }       for (int j = 0; j < root; j++) {           left_pre.add(pre[j+1]);           left_in.add(in[j]);       }       for (int j = root + 1; j < in.length; j++) {           right_pre.add(pre[j]);           right_in.add(in[j]);       }       int[] left_pre1 = new int[left_pre.size()];       int[] left_in1 = new int[left_in.size()];       int[] right_pre1 = new int[right_pre.size()];       int[] right_in1 = new int[right_in.size()];        for (int i = 0; i < left_pre1.length; i++) {            left_pre1[i] = left_pre.get(i);        }        for (int i = 0; i < left_in1.length; i++) {            left_in1[i] = left_in.get(i);        }        for (int i = 0; i < right_pre1.length; i++) {            right_pre1[i] = right_pre.get(i);        }        for (int i = 0; i < right_in1.length; i++) {            right_in1[i] = right_in.get(i);        }       head.left = reConstructBinaryTree(left_pre1, left_in1);       head.right = reConstructBinaryTree(right_pre1, right_in1);       return head;    }}class TreeNode {    int val;    TreeNode left;    TreeNode right;    TreeNode(int x) { val = x; }}