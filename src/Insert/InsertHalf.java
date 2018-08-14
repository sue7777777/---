package Insert;
import print.print;

public class InsertHalf {
	/*
	 * 直接插入是边比较边移动，而折半将比较与移动操作分离出来，先查找出元素的待插入位置，然后再统一地移动待插入位置之后的所有元素
	 * 折半插入是对直接插入的改进，但是仅限于对顺序存储的线性表排序时
	 * 这种改进仅仅是减少了比较元素的次数，比较次数取决于表中的元素个数
	 * 元素的移动次数没有变（该有多少个移动的还是该移动）
	 * 时间复杂度为O(n^2)，稳定
	 */
	public static void main(String[] args) {
		int[] a = { 13, 2, 33, 43, 1, 34, 25, 20 };
		int high, low, mid = 0, tmp;
		// 有序列是前半列，无序列是后半列，每一趟比较时就是比较后半列里第一个数字与有序列，这里与直接插入是相似的
		// 不同之处在于：直接插入是直接与有序列逆序比较（不论这个是否已经是有序列）
		// 折半插入是先使用折半查找到需要插入的位置再插入（如果已经是有序列则不再插入）
		for (int i = 1; i < a.length; i++) {
			low = 0;
			high = i - 1;
			tmp = a[i];
			while (low <= high) {// 折半查找的范围
				mid = (low + high) / 2;
				if (tmp > a[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
			for (int j = i; j > low; j--) {// 统一后移元素，空出插入位置
				a[j] = a[j - 1];// 这里j>low的条件是为了 如果0-i已经是有序列就不用再折半查找了
			}
			a[low] = tmp;// 需要插入的时候可以认为是实现交换，不需要插入的时候其实a[low]==tmp
			print.printArray(a, mid, "mid");
		}
	}

}
