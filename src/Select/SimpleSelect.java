package Select;
import print.print;

public class SimpleSelect {
	/*
	 * 简单选择排序，每一趟从无序列中选择最小的元素与无序列第一个元素交换
	 * 每一趟排序可以确定一个元素的最终位置，这样最多经过n-1趟就可以使整个表有序
	 * 空间：使用常数个辅助但愿，O（1）
	 * 时间：简单选择排序中元素移动次数不超过3（n-1）次，最好的情况是移动0次（表已经有序）
	 * 		元素比较次数依然不变，是n(n-1)/2，时间复杂度O（n^2）
	 * 不稳定                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 */
	public static void main(String[] args) {
		int[] a = { 13, 2, 33, 43, 1, 34, 25, 20 };
		int min,tmp;
		for(int i = 0; i<a.length-1; i++) {//一共进行n-1趟，到最后一趟时无序列只剩下一个元素，肯定有序
			min = i;	//记录最小元素的位置
			for(int j = i+1; j<a.length; j++) {//无序列是从有序列后面第一个元素算起
				if(a[j] < a[min])//在无序列中选择最小的元素
					min = j;//存在则记录该元素的位置
			}
			if(min != i) {//如果经过比较需要进行交换（即无序列中存在比当前元素更小的元素），则交换
				tmp = a[min];
				a[min] = a[i];
				a[i] = tmp;
			}
			print.printArray(a, min, "min");
		}
	}
}
