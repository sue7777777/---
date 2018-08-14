package Swap;
import print.print;

public class Quick {
	/*
	 * 快速排序是对冒泡的一种改进
	 * 在数组中取出一个与元素p作为基准，将数组划分为两部分
	 * 数组被划分为两部分，这两部分中一部分是大于等于p的，另一部分是小于p的
	 * 这就是一趟快排，每次快排都会使一个元素（也就是基准元素p）放在它的最终位置上
	 * 然后分别对两个字表递归，直到每部分内只有一个元素或者空为止
	 * 在快排中最关键的地方就是如何划分，快排的性能也主要取决于划分操作的好坏
	 * 这里的划分操作是以当前表中第一个元素作为p
	 * 快排的效率基于划分子表的对称性，最坏情况下两个子表分别包含n-1和0个元素，此时时间复杂度O(n^2)
	 * 理想情况下两个子表的大小不超过n/2，此时时间复杂度O(nlog2 n)，不稳定
	 */
	public static void main(String[] args) {
		int[] a = { 13, 2, 33, 43, 1, 34, 25, 20 };
		Quick sort = new Quick();
		sort.quick(a, 0, a.length-1);
	}
	private void quick(int[] a, int left, int right) {
		if(left>right)
			return;
		int pPosition = part(a,left,right);	//划分
		quick(a,left,pPosition-1);			//对左边的子表递归
		quick(a,pPosition+1,right);			//对右边的子表递归
		print.printArray(a, a[pPosition], "p");
	}
	private int part(int[] a, int left, int right) {
		int p = a[left];	//将表中第一个元素作为基准元素，对表进行划分
		while(left<right) {	//两个子表循环完毕
			while(left<right && a[right]>=p)//在右边的子表中寻找比p小的元素
				right--;
			a[left] = a[right];//如果找到了跳出循环，此时将比p小的元素移动到左端
			while(left<right && a[left]<=p)//在左边的子表中寻找比p大的元素
				left++;
			a[right] = a[left];//找到了跳出循环，此时将比p大的元素移动到右边
		}//其实是某种意义上的交换
		a[left] = p;//此时基准元素p放到最终位置
		return left;//返回p的最终位置
	}

}
