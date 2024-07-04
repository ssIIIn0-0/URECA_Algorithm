package 이것이코딩테스트다.DFSBFS_ch05;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfsdfs_matrix {

	// 정점 1, 2, 3, 4
	// 연결 정보
	// 1- > 2, 4
	// 2 -> 3, 4
	// 3 -> 2
	// 4 -> 3

	static boolean[][] matrix;
	static boolean[] visit; // 중복 방문 방지

	public static void main(String[] args) {
		// 자료구조
		matrix = new boolean[5][5]; // 0 dummy
		matrix[1][2] = true;
		matrix[1][4] = true;
		matrix[2][3] = true;
		matrix[2][4] = true;
		matrix[3][2] = true;
		matrix[4][3] = true;

		visit = new boolean[5];

//		bfs(1);
		System.out.println();
		dfs(1);
	}

	static void bfs(int n) { // n : 시작정점
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		visit[n] = true;

		while (!queue.isEmpty()) {
			// 정점을 꺼낸다.
			int v = queue.poll();

			// 필요한 처리 수행
			System.out.print(v + " -> ");

			// 계속 방문을 이어간다.
			for (int i = 1; i <= 4; i++) {
				if (!matrix[v][i] || visit[i])
					continue;
				// 해당 정점에 방문할 수 있으면,
				queue.offer(i);
				visit[i] = true;
			}
		}

	}

	static void dfs(int n) { // n : 시작정점
		visit[n] = true;

		// 필요한 처리 수행
		System.out.print(n + " -> ");

		// 계속 방문을 이어 간다.
		for (int i = 1; i <= 4; i++) {
			if (!matrix[n][i] || visit[i])
				continue;
			dfs(i);
		}
	}

}
