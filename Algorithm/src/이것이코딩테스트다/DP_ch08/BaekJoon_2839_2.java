package 이것이코딩테스트다.DP_ch08;

import java.util.Scanner;

//완전탐색 - dfs
// 시간초과
public class BaekJoon_2839_2 {

	static int N, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		min = 5000;

		dfs(0, 0);	// 5kg 0개, 3kg 0개
		
		min = min == 5000 ? -1 : min;
		System.out.println(min);
	}

	static void dfs(int five, int three) {	// 5kg 몇개, 3kg 몇개
		// 기저조건
		int sum = five * 5 + three * 3;
		
		if(sum == N) {	// 성공한 경우
			min = Math.min(min,  five + three);	// 최소값 갱신
			return;
		}
		else if(sum > N) return;	// 실패한 경우
		
		dfs(five + 1, three);
		dfs(five, three + 1);
		
	}
	
}
/*
3 - 1
4 - x
5 - 1
6 - 2
7 - x
8 - 2
9 - 3
10 - 2
11 - 3 
12 - 4
13 - 3
 */
