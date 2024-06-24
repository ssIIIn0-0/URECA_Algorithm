package ch3;

import java.util.Arrays;
import java.util.Scanner;

// 주어지는 배열의 수 전체를 다 고려하지 않고, 가장 큰 수, 두 번째 큰수만 고려
// 가장 큰 수, 두 번째 큰수를 정렬을 통해서 구함
// 이 후 코딩
//	1. 반복 <- 하나씩 하나씩...
//	2. 반복 미리 계산 <- 한꺼번에 계산

public class 큰수의법칙_반복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N, M, K를 공백을 기준으로 구분하여 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		// N개의 수를 공백을 기준으로 구분하여 입력 받기
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr); // 입력 받은 수들 정렬하기
		int first = arr[n - 1]; // 가장 큰 수
		int second = arr[n - 2]; // 두 번째로 큰 수

		// 교재코드
//		{// m개가 될 때까지 가장 큰 수를 우선적으로 k번 사용 + 두번째 수 1번 사용... m번 더할 때까지
//			int result = 0;
//			int totalCnt = 0;
//			int kCnt = 0;
//
//			while (true) {
//				if (totalCnt == m)
//					break; // 모든 숫자를 m번 사용
//				if (kCnt == k) { // 현재 first 를 k번 연속 사용한 상태 second 사용
//					result += second;
//					kCnt = 0;
//				} else {
//					result += first;
//					kCnt++;
//				}
//				totalCnt++;
//			}
//			
//			System.out.println(result);
//		}

		{ // 강사님 코드, 수학적인 사고
			// 가장 큰 수가 더해지는 횟수 계산
			// 큰 수 F 두 번째 수 S
			// m : 8, k : 3
			// FFFS + FFFS <= (k + 1) (k + 1)
			int cnt = (m / (k + 1)) * k;	// 6
			// 전체 더해야하는 개수(m)에서 (k+1)이게 몇개 들어가야하는지 나눗셈으로 구하고, 거기에 k를 곱해서 가장 큰 수가 총 몇개인지 구함
			cnt += m % (k + 1);				// 6
			// (k+1)로 m을 덩어리로 나눈 후 나머지가 있을 경우, 가장 큰 수를 더해줘야하는거라 그걸 추가

			int result = 0;
			result += cnt * first; // 가장 큰 수 더하기
			result += (m - cnt) * second; // 두 번째로 큰 수 더하기
			
			System.out.println(result);
		}
	}
}
/*
 * 5 8 3 2 4 5 4 6
 * 
 * 46
 */
