package org.lemon.leetcode.week2;

import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * <p>
 * 顺时针打印矩阵
 */
public class Solution0029 {

    /**
     * 右下左上的顺序遍历 right、bottom、left、top
     * +++++++top
     * left       right
     * ++++++bottom
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, index = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {

            //left -> right
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }

            //top -> bottom
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }

            // right -> left
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] temp = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Solution0029 solution0029 = new Solution0029();
        int[] res = solution0029.spiralOrder(temp);
        for(int i : res){
            System.out.println(i);
        }
    }
}
