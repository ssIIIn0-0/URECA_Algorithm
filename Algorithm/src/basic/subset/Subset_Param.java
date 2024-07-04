package basic.subset;

//부분집합은 조합의 합
//select 배열을 parameter 화
public class Subset_Param {

	static int[] src = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {
		boolean[] select = new boolean[src.length];
		subset(0, select);
	}

	static void subset(int srcIdx, boolean[] select) {
		// 기저조건
		if (srcIdx == src.length) {
			printSubset(select);
			return;
		}

		// 현재 srcIdx 에 대해서 선택, 비선택 이어간다.
		select[srcIdx] = true;
		subset(srcIdx + 1, select);

		select[srcIdx] = false;
		subset(srcIdx + 1, select);
	}

	static void printSubset(boolean[] select) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < select.length; i++) {
			if (select[i])
				sb.append(src[i]).append(" ");
		}

		System.out.println(sb);
	}
}