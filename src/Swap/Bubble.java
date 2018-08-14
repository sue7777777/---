package Swap;
import print.print;

public class Bubble {
	/*
	 * 从前往后两两比较元素的值，若为逆序则交换，直到序列比较完
	 * 这是一趟冒泡，每趟冒泡的结果都会把一个元素放到最终位置
	 * 下一趟冒泡时，前一趟确定的有序元素不再参与比较 这样最多做n-1趟冒泡就可以完成排序
	 * 最坏情况下（数组逆序），比较次数n(n-1)/2，移动次数3n(n-1)/2，每次比较都要移动元素3次来交换元素位置
	 * 时间复杂度O(n^2)，稳定
	 */
	public static void main(String[] args) {
		int[] a = { 13, 2, 33, 43, 1, 34, 25, 20 };
		boolean flag;//这趟冒泡是否发生交换的标志
		int tmp;
		for (int i = 0; i < a.length-1; i++) {
			flag = false;
			for (int j = a.length - 1; j > i; j--) {//一趟冒泡
				if (a[j - 1] > a[j]) {//大小关系不对则发生交换
					flag = true;
					tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
			print.printArray(a,-1,null);
			if (!flag)
				return;//本趟遍历后没有发生交换，说明表已经有序
		}
	}
}
