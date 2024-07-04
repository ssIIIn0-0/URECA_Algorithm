package 이것이코딩테스트다.Greedy_ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BufferedReader + static(optional)
//static 변수는 재귀호출에서 공유
//local 변수 대비 반복 테케가 있는 경우(SWEA) 각 테게별로 초기화 해줘야 한다.
public class 큰수의법칙_4 {
	static int n, m, k, result;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, M, K를 공백을 기준으로 구분하여 입력 받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// N개의 수를 공백을 기준으로 구분하여 입력 받기
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 입력 받은 수들 정렬하기	O(NlogN)
		int first = arr[n - 1]; // 가장 큰 수
		int second = arr[n - 2]; // 두 번째로 큰 수
		
		// 가장 큰 수가 더해지는 횟수 계산
		// 큰 수 F 두 번째 수 S
		// m : 8, k : 3
		// FFFS + FFFS <= (k + 1) (k + 1)
		// m : 10, k : 3
		// FFFS + FFFS + FF <= (k + 1) (k + 1) 2
		int cnt = (m / (k + 1)) * k;
		cnt += m % (k + 1);
		result += cnt * first; // 가장 큰 수 더하기
		result += (m - cnt) * second; // 두 번째로 큰 수 더하기
		System.out.println(result);
	}
}
/*
5 8 3
2 4 5 4 6
46
 */