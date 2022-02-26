package com.leetcode;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {

    private int[] mearge(int[] aa, int[] bb) {
        int[] cc = new int[aa.length + bb.length];
        int a = 0, b = 0, c = 0;
        while (a < aa.length && b < bb.length) {
            int j = 3;
            while (j > 0) {
                cc[c++] = aa[a++];
                j--;
            }
            cc[c++] = bb[b++];
        }
        while (a < aa.length) {
            cc[c++] = aa[a++];
        }
        while (b < bb.length) {
            cc[c++] = bb[b++];
        }
        return cc;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        int[] cc = solveNQueens.mearge(new int[]{1, 2, 3, 5, 6, 7, 9}, new int[]{4, 8});
        System.out.println("");
    }
}
