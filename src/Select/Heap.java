package Select;

import print.print;

public class Heap {
	/*
	 * 堆排序是一种基于完全二叉树的树形选择排序方法
	 * 堆是指n个关键字序列，可分为小顶堆（父节点比子节点的值小，根节点是整个值的最小值）降序
	 * 和大顶堆（父节点比子节点的大，根节点是最大值）升序
	 * 1、堆排序的关键在于构建初始堆，第n个节点的父节点是第n/2个节点（例如第4，5个节点的父节点是第2个节点）
	 * 从最底层的简单子树调整起，直到根节点
	 * 2、堆构建好之后，将堆顶元素（当前列的最大值或者最小值）与末尾元素交换，将最值固定到数组末端
	 * 3、重新调整结构，使其满足堆定义，然后继续交换堆顶与当前末尾元素，反复执行直到序列有序
	 * 空间：常数个辅助但愿，空间复杂度为O（1）
	 * 时间：最坏、最好、平均时间复杂度都是O(nlogn)
	 * 不稳定
	 */
	public static void main(String[] args) {
		int[] a = { 13, 2, 33, 43, 1, 34, 25, 20 };
		Heap test = new Heap();
		test.buildMaxHeap(a);
		System.out.print("初始最大堆");
		print.printArray(a, -1, null);
		for(int i = a.length-1; i>0 ; i--) {//调整堆结构、交换堆顶元素与末尾元素
			test.swap(a,0,i);//交换堆顶与末尾元素
			test.adjustDown(a,0,i);//重新调整堆
			print.printArray(a, -1, null);//每趟都会从数组末尾开始确定一个元素
		}

	}

	public void buildMaxHeap(int[] array) {//构建大顶堆
		//大顶堆的定义公式：arr[i]>=arr[2i+1] && arr[i]>=arr[2i+2]
		for(int i = array.length/2 - 1; i>=0; i--) {
			adjustDown(array,i,array.length);//从一个非叶子节点从下至上，从右至左调整结构
		}
	}
	
	public void adjustDown(int[] array,int k,int length) {//向下调整堆
		int tmp = array[k];//先记录当前节点
		for(int i = 2*k+1 ; i<length; i=i*2+1) {//从k节点的左子节点开始
			if(i+1<length && array[i]<array[i+1])//如果左子节点小于右子节点，k指向右子节点
				i++;//右子节点
			if(array[i] > tmp) {//子节点大于父节点，将子节点值赋给父节点
				array[k] = array[i];//将子节点调整到父节点上
				k = i;//修改k值，
			}else
				break;
		}
		array[k] = tmp;
	}
	
	public void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
