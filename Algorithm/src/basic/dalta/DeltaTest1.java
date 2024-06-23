package basic.dalta;

import java.util.Arrays;

// 2차원 배열 (문자)
// if-else 구조의 4방탐색은 개발자의 실수를 많이 유발
// 싱하좌우 이동에 대한 변화향을 미리 배열로 계산 / 상(-1, 0) 하(+1, 0) 좌(0, -1) 우(0. +1)
// 한 칸 이동이 아닌 갈 수 있을 때까지 계속 이동
public class DeltaTest1 {

	static char[][] map = new char[5][5];

	public static void main(String[] args) {
		char ch = 'A';

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = ch++;
			}
		}

		// 출력
		for (int i = 0; i < 5; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
//		System.out.println(Arrays.deepToString(map).replace("]", "]\n"));
		/*
		 * 이렇게 나옴 [[A, B, C, D, E] , [F, G, H, I, J] , [K, L, M, N, O] , [P, Q, R, S, T]
		 * ,[U, V, W, X, Y] ]
		 */

		// y = 3, x = 3 자리의 상하좌우 출력
//		print4_no_delta(3, 3);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				print4_long(i, j);
			}
		}

	}

	static void print4_no_delta(int y, int x) {
		// 상
		if (y - 1 >= 0) {
			System.out.println(map[y - 1][x]);
		}
		// 하
		if (y + 1 < 5) {
			System.out.println(map[y + 1][x]);
		}
		// 좌
		if (x - 1 >= 0) {
			System.out.println(map[y][x - 1]);
		}
		// 우
		if (x + 1 < 5) {
			System.out.println(map[y][x + 1]);
		}
		System.out.println();
	}

	// delta
	// 상, 하, 좌, 우
	static int dy4[] = { -1, 1, 0, 0 };
	static int dx4[] = { 0, 0, -1, 1 };

	static void print4(int y, int x) {
		System.out.println("delta를 이용한 상, 하, 좌, 우");

		for (int d = 0; d < 4; d++) {
			int ny = y + dy4[d];
			int nx = x + dx4[d];

			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
				continue;
			System.out.println(map[ny][nx]);
		}
		
		System.out.println();
	}
	
	// 끝까지 가는 코드
	static void print4_long(int y, int x) {
		System.out.print(map[y][x] + " : ");
		
		for (int d = 0; d < 4; d++) {
			// 반복문으로 구성, ny = y.. => ny = ny ...
			int ny = y;
			int nx = x;
			
			while(true) {				
				ny = ny + dy4[d];
				nx = nx + dx4[d];
				
				if( ny < 0 || nx < 0 || ny >= 5 || nx >= 5 ) break;
				System.out.print(map[ny][nx]);
			}

		}
		System.out.println();
	}

	// delta 대각선
	// 좌상, 우상, 좌하, 우하
	static int dy4x[] = { -1, -1, 1, 1 };
	static int dx4x[] = { -1, 1, -1, 1 };

	static void print4x(int y, int x) {
		System.out.println(map[y][x] + " : ");

		for (int d = 0; d < 4; d++) {
			int ny = y + dy4x[d];
			int nx = x + dx4x[d];

			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
				continue;
			System.out.println(map[ny][nx]);
		}
		System.out.println();
	}
	
	// 끝까지 가는 코드
	static void print4x_long(int y, int x) {
		System.out.print(map[y][x] + " : ");
		
		for (int d = 0; d < 4; d++) {
			
			int ny = y;
			int nx = x;
			
			while(true) {
				ny = ny + dy4x[d];
				nx = nx + dx4x[d];
				
				if( ny < 0 || nx < 0 || ny >= 5 || nx >= 5 ) break;	
				System.out.print(map[ny][nx]);
			}
		}
		System.out.println();
	}

	// delta 대각선
	// 좌상, 우상, 좌하, 우하
	static int dy8[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dx8[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static void print8(int y, int x) {
		System.out.println(map[y][x] + " : ");

		for (int d = 0; d < 8; d++) {
			int ny = y + dy8[d];
			int nx = x + dx8[d];

			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
				continue;
			System.out.println(map[ny][nx]);
		}
		System.out.println();
	}
	
	// 끝까지 가는 코드
	static void print8_long(int y, int x) {
		System.out.print(map[y][x] + " : ");
		
		for (int d = 0; d < 8; d++) {
			int ny = y;
			int nx = x;
			
			while(true) {
				ny = ny + dy8[d];
				nx = nx + dx8[d];
				
				if( ny < 0 || nx < 0 || ny >= 5 || nx >= 5 ) break;
				System.out.print(map[ny][nx]);	
			}

		}
		System.out.println();
	}

}
