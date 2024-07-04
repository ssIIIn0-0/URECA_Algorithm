package 이것이코딩테스트다.구현_ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1158 {
	static int n, k, turn;
	static int[] num; // n명의 사람 순서

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		num = new int[n+1];	// i == 살아있는 사람, 0 == 제거된 사람
		turn = 1;

		System.out.print("<");

		for (int i = 0; i < n+1; i++) {
			num[i] = i;
		}
		
		for (int i = 0; i < n; i++) { // 0 1 2 3 4 5 6 7
			int count = 0;
			
			// 인덱스 찾기
			while (true) {
				//System.out.println(turn + "while");
				if (num[turn] != 0)
					count++; // 해당 인덱스의 사람이 살아있다면
				if (count == k)
					break;
				turn = (turn + 1) % (n+1);
			}
			
			//System.out.println(turn + "밖");
			if (i == n-1)
				System.out.print((turn));
			else
				System.out.print((turn) + ", ");
			num[turn] = 0; // 해당 번호의 사람 제거
		}

		System.out.print(">");
	}

}


//1 2 3 4 5 6 7
//1 2 x 4 5 6 7
//1 2 x 4 5 x 7
//1 x x 4 5 x 7
