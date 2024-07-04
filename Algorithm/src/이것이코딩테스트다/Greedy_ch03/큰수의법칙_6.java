package Greedy_ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BufferedReader + static(optional)
//static 변수는 재귀호출에서 공유
//local 변수 대비 반복 테케가 있는 경우(SWEA) 각 테게별로 초기화 해줘야 한다.
public class 큰수의법칙_6 {
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

		// O(N)
		int first = first(); // 가장 큰 수
		int second = second(); // 두 번째로 큰 수

		int cnt = (m / (k + 1)) * k;
		cnt += m % (k + 1);
		result += cnt * first; // 가장 큰 수 더하기
		result += (m - cnt) * second; // 두 번째로 큰 수 더하기
		System.out.println(result);
	}

	static int first() {
		int first = 0; // max
		int firstIndex = 0;
		for (int i = 0; i < n; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록.
			if (arr[i] > first) {
				first = arr[i];
				firstIndex = i;
			}
		}
		arr[firstIndex] = 0; // 가장 큰 수의 index 를 이용해서 0 으로 변경
		return first;
	}

	static int second() {
		int second = 0;
		for (int i = 0; i < n; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록.
			if( arr[i] > second ) {
            second = arr[i];
			}
		}
		return second;
	}
}

/*
 * 5 8 3 2 4 5 4 6 46
 */
