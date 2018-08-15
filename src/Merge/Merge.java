package Merge;
import print.print;

public class Merge {
	/*
	 * 采用分治法，归并是指将两个或两个以上的有序表组合成一个新的有序表
	 * 二路归并排序：分为分解和合并
	 * 分解：将n个元素的待排序表分成各有n/2个元素的子表
	 * 合并：将相邻的子表两两归并，得到2倍长度的有序表，再两两归并，如此重复直到合并成一个长度为n的有序表为止
	 * 空间：占用n个单元，空间复杂度O（n）
	 * 时间：每一趟归并的复杂度O（n），共需要log2 n趟归并，算法复杂度O（nlog2 n）
	 * 稳定
	 */
	public static void main(String[] args) {
		int[] a = { 13, 2, 33, 43, 1, 34, 25, 20 };
		Merge test = new Merge();
		test.mergeSort(a);
	}
	//将有序的arr[low..mid]和arr[mid+1..high]归并为有序的res[low..high]
	public void merge(int[] arr,int low,int mid,int high) {
		int i = low, j = mid+1, q = 0;
		int[] res = new int[high-low+1];//归并后的数组长度由low和high决定
		while(i<=mid && j<=high) {//这里的限制条件导致arr中会有最后一个元素未被存储到res里，且这个值肯定是最大值
			if(arr[i]<=arr[j])//选出两个子序列中的较小值
				res[q++] = arr[i++];
			else
				res[q++] = arr[j++];
		}
		//下面的两个循环只会有一个执行，因为上面的代码导致在存储倒数第二个元素时，i或者j会超出数组范围，所以要把最后一个元素存进来
		while(i<=mid) res[q++] = arr[i++];
		while(j<=high) res[q++] = arr[j++];
		//归并完成，将res中的元素复制回arr中
		for(q=0, i=low; i<=high; q++,i++) {
			arr[i] = res[q];
		}
	}
	//一趟归并排序，将长度为len的序列两两归并，形成长度为n的序列
	public void mergePass(int[] arr,int len,int n) {
		int i;
		for(i=0; i+2*len-1<n; i = i+2*len) 
			merge(arr,i,i+len-1,i+2*len-1);
		if(i+len-1<n)//对余下的两个子序列归并
			merge(arr,i,i+len-1,n-1);
		print.printArray(arr, len, "len");
	}
	//二路归并排序
	public void mergeSort(int[] arr) {
		for(int i =1; i<arr.length; i*=2) {//分割
			mergePass(arr,i,arr.length);
			//1，2，4，8，...，lenth-1
		}
	}
}
