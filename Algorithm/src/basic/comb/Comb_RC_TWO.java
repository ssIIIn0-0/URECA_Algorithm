package basic.comb;

public class Comb_RC_TWO {

	static int totalCount = 0;
	static int tgtCount = 3;
	static int[] srcArray = {1, 2, 3, 4, 5};
	static int[] tgtArray = new int[tgtCount];
	
	public static void main(String[] args) {
		comb(0, 0);
		System.out.println(totalCount);

	}
	
	public static void comb (int srcIndex, int tgtIndex) {
		if (tgtIndex == tgtArray.length) {
			printArray(tgtArray);
			totalCount++;
			return;
		}
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

}
