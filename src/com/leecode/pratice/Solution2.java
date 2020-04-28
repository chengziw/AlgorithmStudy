package com.leecode.pratice;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/7 20:14
 * @Poject: AlgorithmStudy
 * @description反转矩阵
 */
public class Solution2 {

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int x=0;x<n;x++){
            for(int y=0;y<matrix[x].length;y++){
                int temp=matrix[x][y];
                matrix[x][y]=matrix[y][x];
                matrix[y][x]=temp;
            }
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[x][j];
                matrix[x][j] = matrix[x][n - j - 1];
                matrix[x][n - j - 1] = tmp;
            }
        }
    }
}
