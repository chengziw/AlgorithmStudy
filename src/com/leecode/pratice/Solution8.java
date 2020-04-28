package com.leecode.pratice;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/20 18:47
 * @Poject: AlgorithmStudy
 */
public class Solution8 {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length<1){
            return 0;
        }
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return  count;
    }
    public void dfs(char[][] grid,int r,int c){

        int l=grid.length;
        int l1=grid[0].length;
        if(r<0||c<0||r>=l||l1>=c||grid[r][c]==0){
            return;
        }
        grid[r][c]=0;
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}
