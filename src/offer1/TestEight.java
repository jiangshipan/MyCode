package offer1;/** * 青蛙跳台阶 */public class TestEight {    public static void main(String[] args) {        System.out.println(JumpFloor(5));    }    /**     * 得出规律 f(n) = f(n - 1) + f(n - 2)     * @param target     * @return     */    public static int JumpFloor(int target) {        int pre = 2;        int prepre = 1;        int result = 0;        if (target <= 0){            return 0;        }        if (target == 1) {            return prepre;        }        if (target == 2) {            return pre;        }        for (int i = 3; i <= target; i++) {            result = pre + prepre;            prepre = pre;            pre = result;        }        return result;    }}