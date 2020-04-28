package com.leecode.study;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/8 19:23
 * @Poject: AlgorithmStudy
 * description:二维数组中可以遍历最多的点，深度优先搜索||广度优先搜索
 */
public class Solution3 {

    private int res;
    private boolean[][] marked;
    private int m,n,k;
    public int movingCount(int m, int n, int k) {
        marked=new boolean[m][n];  //记录哪些已经到达
        this.m=m;
        this.n=n;
        this.k=k;
        res=0;
        dfs(0,0);
        return res;
    }

    private void dfs(int i, int j) {
        if(!isArea(i,j)) return; //判断横纵坐标是否在合适的区间类
        if(marked[i][j]) return;  //判断是否已经到达过，达到过返回
        if(isOk(i,j)){   //判断是否满足
            res++;
            dfs(i+1,j);   //继续查找
            dfs(i,j+1);
        }
        marked[i][j]=true;  //表示已经到达过了
    }

    private boolean isArea(int newX, int newY) {
        if(newX<0||newX>=m||newY<0||newY>=n) return false;
        return true;
    }

    private boolean isOk(int newX, int newY){
        return newX%10+newX/10+newY%10+newY/10<=k;
    }
}

