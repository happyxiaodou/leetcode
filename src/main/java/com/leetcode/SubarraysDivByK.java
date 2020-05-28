package com.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraysDivByK {

    public static int subarraysDivByK(int[] A, int K) {
        int length = A.length;
        int r = 0;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                if (j < i) {
                    int newArray[] = Arrays.copyOfRange(A, j, i);
                    if (newArray.length > 0) {
                        int sum = 0;
                        for (int item : newArray) {
                            sum = sum + item;
                        }
                        if (sum % K == 0) {
                            r++;
                        }
                    }
                }
            }
        }
        return r;
    }


    public static int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans = ans + same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 0, -2, -3, 1};
        System.err.println(subarraysDivByK2(a, 5));
    }
}
