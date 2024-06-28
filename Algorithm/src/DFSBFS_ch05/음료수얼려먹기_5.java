package DFSBFS_ch05;

// BFS 사용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음료수얼려먹기_5 {
	static int n, m, result;
	static char[][] graph;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static Queue<Node> queue = new ArrayDeque<>();

	static void bfs(int y, int x) {

		// 해당 노드 방문 처리
		graph[y][x] = '1';
		queue.offer(new Node(y, x));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m || graph[ny][nx] != '0')
					continue;
				graph[ny][nx] = '1';
				queue.offer(new Node(ny, nx));
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N, M을 공백을 기준으로 구분하여 입력 받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new char[n][];

		// 2차원 리스트의 맵 정보 입력 받기
		for (int i = 0; i < n; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		// 모든 노드(위치)에 대하여 음료수 채우기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 현재 위치에서 DFS 수행
				if (graph[i][j] == '0') {
					bfs(i, j);
					result += 1;
				}
			}
		}
		System.out.println(result); // 정답 출력
	}
}
/*
 * 4 5 00110 00011 11111 00000 3
 */