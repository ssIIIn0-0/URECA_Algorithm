package basic.perm;

import java.util.Arrays;

// 5개 수 중에서 3개의 수로 만들 수 있는 순열의 종류 및 구성
public class Perm_Basic {

	static int[] src = {1, 2, 3, 4, 5};
	static int[] tgt = new int[3];	// _ _ _ <- tgtIdx
	static boolean[] select = new boolean[src.length];	// src 1,2,3,4,5 각각에 대한 이전 사용 여부
	
	public static void main(String[] args) {
		perm(0);
	}
	static void perm(int tgtIdx) {
		// 기저조건
		if (tgtIdx == tgt.length) {
			// 순열 한 가지가 완성
			System.out.println(Arrays.toString(tgt));
			return;
		}
		// tgtIdx 자리에 채울 수 를 고려
		for (int i = 0; i < src.length; i++) {
			// tgtIdx 앞자리에 이미 사용된 수만 제외, 사용된 수는 select[] 에 기록
			if (select[i]) continue;
			
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;	// for문의 i가 이전 재귀호출에서 선택되서 고려되었으므로 다음 i 를 고려하기 위해 i 선택 해제
		}
	}

}
