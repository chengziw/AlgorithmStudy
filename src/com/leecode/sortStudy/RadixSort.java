package com.leecode.sortStudy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort{

	private int a[];

	public RadixSort(int a[]) {
		this.a = a;
	}

	public void radixSort() {

		int n = a.length - 1;

		//找到最大值
		int max = a[0];
		for(int i = 1 ; i < n ; i ++)
			if(a[i] > max)
				max =a[i];

		//求出最大值有多少位
		int keysNum = 0;
		while( max > 0 ) {
			max /= 10;
			keysNum ++;
		}

		List<LinkedList<Integer>> buckets = new ArrayList<>();
		for(int i = 0 ; i < 10 ; i ++)
			buckets.add(new LinkedList<>());

		for(int i = 0 ; i < keysNum ; i ++) {
			countSort(buckets , i);
		}

	}

	private void countSort(List<LinkedList<Integer>> buckets, int i) {
		for(int j = 0 ; j < a.length  ; j ++) {
			int key = (int) (a[j] % Math.pow(10, i + 1) / Math.pow(10, i));
			buckets.get(key).add(a[j]);
		}

		int count = 0 ;
		for(int k = 0 ; k < 10 ; k ++) {
			LinkedList<Integer> bucket = buckets.get(k);
			while(bucket.size() > 0) {
				a[count ++] = bucket.remove(0);
			}
		}

		System.out.print("the " + ( i + 1 ) +" time sort: ");
		display();

	}

	private void display() {
		for(int i = 0 ; i < a.length ; i ++ )
			System.out.print(a[i] + "   ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = {53, 3, 542, 748, 14, 214, 154, 63, 616, 55 , 58};
		RadixSort rs = new RadixSort(a);
		System.out.print("before     sort: ");
		rs.display();
		rs.radixSort();
	}
}
