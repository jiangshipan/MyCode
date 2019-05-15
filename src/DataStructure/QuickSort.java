package DataStructure;import java.util.Arrays;import java.util.HashMap;import java.util.Map;import java.util.Stack;public class QuickSort {    /**     * 递归快排     * @param arr     * @param startIndex     * @param endIndex     */    public static void quickSort(int[] arr, int startIndex, int endIndex) {        //递归结束条件: startIndex >= endIndex        if (startIndex >= endIndex) {            return;        }        //得到基准元素位置        int pivotIndex = partition(arr, startIndex, endIndex);        //根据基准元素位置，分成两部分进行递归排序        quickSort(arr, startIndex, pivotIndex - 1);        quickSort(arr, pivotIndex + 1, endIndex);    }    /**     * 非递归快排     * @param arr     * @param startIndex     * @param endIndex     */    public static void quickSort1(int[] arr, int startIndex, int endIndex) {        //用一个栈来代替递归的函数栈        Stack<Map<String,Integer>> quickSortStack = new Stack<>();        //整个数列的起止下表，以哈希形式入栈        Map rootParam = new HashMap();        rootParam.put("startIndex", startIndex);        rootParam.put("endIndex", endIndex);        quickSortStack.push(rootParam);        //循环结束条件        while (!quickSortStack.isEmpty()) {            //栈顶元素出栈，得到起止下标            Map<String, Integer> param = quickSortStack.pop();            //得到基准元素位置            int pivotIndex = partition1(arr, param.get("startIndex"), param.get("endIndex"));            //根据基准元素分成两部分，把每一部分的起止下标入栈            if (param.get("startIndex") < pivotIndex - 1) {                Map<String, Integer> leftParam = new HashMap<>();                leftParam.put("startIndex", param.get("startIndex"));                leftParam.put("endIndex", pivotIndex - 1);                quickSortStack.push(leftParam);            }            if (pivotIndex + 1 < param.get("endIndex")) {                Map<String, Integer> rightParam = new HashMap<>();                rightParam.put("startIndex", pivotIndex + 1);                rightParam.put("endIndex", param.get("endIndex"));                quickSortStack.push(rightParam);            }        }    }    /**     * 分治 双边循环法     * @param arr     * @param startIndex     * @param endIndex     * @return     */    public static int partition(int[] arr,int startIndex, int endIndex) {        //取第一个位置的元素作为基准元素        int pivot = arr[startIndex];        int left = startIndex;        int right = endIndex;        while (left != right) {            //控制right指针比较并左移            while (left < right && arr[right] > pivot) {                right--;            }            //控制left指针比较并右移动            while (left < right && arr[left] <= pivot) {                left++;            }            //交换left和right指针所指向的元素            if (left < right) {                int temp = arr[left];                arr[left] = arr[right];                arr[right] = temp;            }        }        //pivot和指针重合点交换        arr[startIndex] = arr[left];        arr[left] = pivot;        return left;    }    /**     * 分治：单边循环法     * @param arr     * @param startIndex     * @param endIndex     * @return     */    public static int  partition1(int[] arr, int startIndex, int endIndex) {        int pivot = arr[startIndex];        int mark = startIndex;        for (int i = startIndex; i <= endIndex; i++) {            if (arr[i] < pivot) {                mark++;                int temp = arr[mark];                arr[mark] = arr[i];                arr[i] = temp;            }        }        arr[startIndex] = arr[mark];        arr[mark] = pivot;        return mark;    }    public static void main(String[] args) {        int[] arr = {3,6,7,8,5};        //quickSort(arr, 0, arr.length - 1);        quickSort1(arr, 0, arr.length - 1);        System.out.println(Arrays.toString(arr));    }}