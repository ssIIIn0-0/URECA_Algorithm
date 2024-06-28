package DP_ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_9095 {

	static int test_case;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test_case = Integer.parseInt(br.readLine());
		dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for(int i = 0; i < test_case; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num]);
		}
	}
}

// 점화식 : i가 4보다 클때,
// dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
// 현재 인덱스 기준 이전, 이전이전, 이전이전이전 3번째 뒤꺼까지 모두 더하면 됨.