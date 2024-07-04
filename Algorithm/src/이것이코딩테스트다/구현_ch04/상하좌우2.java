package 구현_ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BufferedReader, static
// String[] plans -> char[]
// x <-> y (y를 기준으로)
public class 상하좌우2 {
	static int n;
	static char[] plans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// while, for st.countTokens()
		int count = st.countTokens();
		plans = new char[count];

		for (int i = 0; i < count; i++) {
			plans[i] = st.nextToken().charAt(0);
		}

		// 풀이
		int y = 1, x = 1;
		// L, R, U, D에 따른 이동 방향
		// 이동 계획을 하나씩 확인
		for (int i = 0; i < count; i++) {

			int ny = y;
			int nx = x;

			switch (plans[i]) {
			case 'L': nx = nx - 1; break;
			case 'R': nx = nx + 1; break;
			case 'U': ny = ny - 1; break;
			case 'D': ny = ny + 1; break;
			}

			// 공간을 벗어나는 경우 무시
			if (ny < 1 || nx < 1 || ny > n || nx > n)
				continue;
			// 이동 수행
			y = ny;
			x = nx;
		}
		System.out.println(y + " " + x);
	}
}

/*
 5 
 R R R U D D
 
 3 4
 
5
D D L L R R U D

3 3

7
D D D D D R R R R R U U U U U L L L L L

1 1
 */





















