package DFSBFS_ch05;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
// Node cnt

public class 미로탈출2 {
	static class Node {
		int y;
		int x;
		int cnt;

		Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static int n, m, ans;
	public static int[][] graph;
	public static boolean[][] visit;
	// 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
	public static int dy[] = { -1, 1, 0, 0 };
	public static int dx[] = { 0, 0, -1, 1 };

	public static void bfs() {
		// 큐(Queue) 구현을 위해 queue 라이브러리 사용
		Queue<Node> q = new ArrayDeque<>();
		visit[0][0] = true;
		q.offer(new Node(0, 0, 1));

		// 큐가 빌 때까지 반복하기
		while (!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;
			int cnt = node.cnt;

			// 현재 위치에서 4가지 방향으로의 위치 확인
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				// 미로 찾기 공간을 벗어난 경우 무시 // 벽인 경우 무시
				if (ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx] || graph[ny][nx] == 0)
					continue;

				// 도착지점 확인
				if (ny == n - 1 && nx == m - 1) {
					ans = cnt + 1;
					return;
				}

				visit[ny][nx] = true;
				q.offer(new Node(ny, nx, cnt + 1));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N, M을 공백을 기준으로 구분하여 입력 받기
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine(); // 버퍼 지우기
		// 2차원 리스트의 맵 정보 입력 받기
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		// BFS를 수행한 결과 출력
		bfs();
		System.out.println(ans);
	}
}
/*
 * 5 6 101010 111111 000001 111111 111111 10
 */
