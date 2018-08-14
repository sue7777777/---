package print;

public class print {

	public static void printArray(int[] a,int otherArg,String argName) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		if(otherArg != -1) {
			System.out.print(argName+"="+otherArg);
		}
		System.out.println();
	}
	
}
