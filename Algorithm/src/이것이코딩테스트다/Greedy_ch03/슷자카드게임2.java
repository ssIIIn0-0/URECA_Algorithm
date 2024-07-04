package 이것이코딩테스트다.Greedy_ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
// 리팩토링 + 2차원 배열 사용
public class 슷자카드게임2 {
	static int n, m, result;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		// 한 줄씩 입력받아 확인하기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());	// n만큼 한줄씩 일겅서 token 처리
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			// 각 행별로 가장 작은 수 선택
			int min_value = 10001;
			for (int j = 0; j < m; j++) {
				min_value = Math.min(min_value, map[i][j]);
			}
			result = Math.max(result,  min_value);
		}
		
		System.out.println(result);
	}
}
