package offer1;import java.util.ArrayList;import java.util.Stack;/** * 输入一个链表，按链表值从尾到头顺序返回一个ArrayList */public class TestThree {    public static void main(String[] args) {        ListNode node = new ListNode(1);        node.next = new ListNode(2);        node.next.next = new ListNode(3);        ArrayList<Integer> list = printListFromTailToHead2(node);        System.out.println(list);    }    /**     * 使用栈     * @param listNode     * @return     */    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {        ArrayList<Integer> list = new ArrayList<>();        Stack<Integer> stack = new Stack<>();        ListNode temp = listNode;        while (temp != null) {            stack.push(temp.val);            temp = temp.next;        }        while (!stack.isEmpty()) {            list.add(stack.pop());        }        return list;    }    /**     * 递归     * @param listNode     * @return     */    static ArrayList<Integer> list = new ArrayList<>();    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {        ListNode temp = listNode;        if (temp != null) {            printListFromTailToHead2(temp.next);            list.add(temp.val);        }        return list;    }}class ListNode {    int val;    ListNode next = null;    ListNode(int val) {        this.val = val;    }}