package Insert;
import print.print;

public class InsertSort {

	public static void main(String[] args) {
		// 直接插入排序，升序
		// 时间复杂度O(n^2)，稳定，适用于顺序存储和链式存储
		int[] keys = { 13, 2, 33, 43, 1, 34, 25, 20 };
		int tmp, i, j;
		for (i = 1; i < keys.length; i++) {// 数组的第一个数字默认是有序列，从第二个数字开始进行排序
			tmp = keys[i];
			for (j = i - 1; j >= 0 && tmp < keys[j]; j--) {// tmp与有序列逆序比较，确定插入位置
				/*
				 * 与有序列比较的时候，首先比较的是有序列中最后一个数，这个数是有序列中最大的
				 * tmp和它比较只有两种情况：tmp需要插入和tmp不需要插入，直接计入有序列
				 * 1、tmp不需要插入时(tmp>=keys[j])
				 * tmp比有序列中最大的数大或者相等，则说明keys[j+1]已经是个有序列
				 * 那么keys[j+1]=tmp 
				 * 2、tmp需要插入时(tmp<keys[j]) 
				 * tmp比有序列中最大的数小，说明需要把tmp插入到合适的位置
				 * 接下来就是寻找合适的位置：这个位置可能是0-j中任意一个数 
				 * 根据这个限制j的范围：j>=0，两个条件有一不满足则跳出，此时跳出循环的j是已经--过的数据
				 * 所以在循环外keys[j+1]=tmp
				 */
				keys[j + 1] = keys[j];
			}
			keys[j + 1] = tmp;
			print.printArray(keys, tmp, "tmp");
		}
	}
}
