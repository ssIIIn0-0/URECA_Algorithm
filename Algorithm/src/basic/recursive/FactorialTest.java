package basic.recursive;

public class FactorialTest {

	public static void main(String[] args) {

		factorial(5);	// 5x4x3x2x1
		int result = 5;
		System.out.println(factorial2(result));

	}
	
	// 계산 결과를 static 변수를 이용
	static int result = 1;
	static void factorial (int n) {
		// 기저조건
		//	1. 재귀호출을 끝내야 한다.
		//	2. 문제에서 원하는 상태가 완료되었다.
		
		if (n == 1) {
			// 계산 결과 출력
			System.out.println(result);
			return;
		}
		// 계산
		result = result * n;
		
		// 재귀 호출
		factorial(n - 1);
	}
	
	// 5 <- 4 <- 3 <- 2 <- 1 
	static int factorial2(int n) {
		// 기저조건
		if (n == 1)
			// 계산 결과 출력 대신 제귀 호출 종료 처리
			return 1;
		
		// 계산 + 재귀호출
		return n * factorial2(n - 1);
	}
	
	
	static void factorial3(int n, int result) {	// result : 이전 단계에서 계산되어 전달된 값
		// 기저조건
		if (n == 1) {
			System.out.println(result);
			return;
		}
		
		// 계산
//		int temp = result * n;
		
		// 재귀 호출 + 계산
		factorial3 (n - 1, result * n);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
