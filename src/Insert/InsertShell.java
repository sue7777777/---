package Insert;
import print.print;

public class InsertShell {
	/*
	 * 希尔排序（缩小增量排序），基于某个增量分组，分组进行插入排序 这样使整个数组呈现一种“基本有序”的状态，小的数基本在前，大的基本在后（对于升序）
	 * 随着这个增量逐渐减小至1，整个数组是一个分组，这时候只需要微调
	 * 这样使得希尔排序的时间复杂度比直接插入的小，约为O(n^1.3)，在最坏情况下，时间复杂度O(n^2)
	 * 希尔排序不稳定，相同关键字的记录被划分到不同子表时，可能会改变他们的相对次序
	 */
	public static void main(String[] args) {
		int[] a = { 13, 2, 33, 43, 1, 34, 25, 20 };
		for (int gap = a.length / 2; gap > 0; gap /= 2) {// gap是增量，每次都取半，直至1
			for (int i = gap; i < a.length; i++) {
				int j = i;
				int tmp = a[j];
				// 对于增量分组：a[0],a[gap],a[2gap]...为一组
				// a[1],a[gap+1],a[2gap+1]...为一组，以此类推
				if (a[j] < a[j - gap]) {// 对分组内的数据进行插入排序
					while (j >= gap && tmp < a[j - gap]) {
						// 移动元素
						a[j] = a[j - gap];
						j -= gap;
					}
					a[j] = tmp;// 让出来的空位就是需要插入元素的地方，tmp保存的是需要插入的元素的值
				}
			}
			print.printArray(a, gap, "gap");
		}
	}
}
