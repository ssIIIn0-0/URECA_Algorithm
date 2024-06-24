package ch3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
// 리팩토링, 자료구조(map) 사용안함
public class 슷자카드게임3 {
	static int n, m, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			// 각 행별로 가장 작은 수 선택
			int min_value = 10001;
			st = new StringTokenizer(br.readLine());	// 한 줄을 읽어서 token 처리
			for (int j = 0; j < m; j++) {
				int input = Integer.parseInt(st.nextToken());
				min_value = Math.min(min_value, input);
			}
			result = Math.max(result,  min_value);
		}
		
		System.out.println(result);
	}
}
