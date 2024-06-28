package DP_ch08;

public class 피보나치_수열 {

	static long[] memoi = new long[100];	// 이미 계산된 것을 저장 재활용
	public static void main(String[] args) {
		memoi[1] = 1;
		memoi[2] = 1;
		
		int n = 50;
		
		for (int i = 3; i <= n; i++) {
			memoi[i] = memoi[i - 1] + memoi[i - 2];
		}
		
		System.out.println(memoi[n]);
	}
	
}
