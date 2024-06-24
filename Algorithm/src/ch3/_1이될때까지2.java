package ch3;

import java.util.Scanner;
// 단순 반복
// 연산 1. 1빼기
// 연산 2. k로 나누기(우선순위)
public class _1이될때까지2 {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // N, K를 공백을 기준으로 구분하여 입력 받기
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int result = 0;

	        while (true) {
	            // 우선순위대로 n -> 1로 변경
	        	// 1 이 되면 종료
	        	if(n == 1) break;

	        	// k 로 나눌 수 있으면 나눈다. (우선순위)
	        	if (n % k == 0) {
	        		n = n / k;
	        		result++;
	        	}else {
	        		// 여러개 연산 갯수 처리
	        		int target = (n / k) * k;
	        		result += (n - target);
	        		n--;
	        	}
	        }

	        System.out.println(result);
	    }
}

// 그리디
// 모든 경우의 수를 다 따지는 완탐(브루트포스) 대비
// 꼭 필요한 (최선의) 선택을 통해서 답을 구하는 방식

// 그리디의 전제조건 : 지극히 당연한 논리, 수학적으로 증명된... 막연한 추측은 절대 금물()

// 문제가 그리디로 보이더라도 의심 또 의심
// 완탐으로 풀 경우 시간초과 (테케 건수가 매우 많다 등) 예상, 분명해 보이면 고려
//타고난 수학적 직관력 또는 오랜 경험을 통한 판단
// 그리디 문제는 특정 중요한 코테에 잘 나오지 않는다.
// 그래프 알고리즘 <= 그리디 (수학적으로 증명)


/*
17 4
3

25 5
2
 */







