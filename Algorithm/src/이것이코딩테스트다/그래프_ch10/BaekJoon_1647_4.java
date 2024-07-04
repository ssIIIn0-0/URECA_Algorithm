package 이것이코딩테스트다.그래프_ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 프림 + 인접 행렬
// 메모리 초과 <= 2차원 배열이 너무 커진다. 10만 x 10만
public class BaekJoon_1647_4 {
	static int N, M, result;
	static int[][] matrix;
	static boolean[] visit;
	static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		// 간선 => 인접행렬
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			matrix[v1][v2] = c;
			matrix[v2][v1] = c;
		}
		visit[1] = true;
		for (int i = 1; i <= N; i++) {
			if (matrix[1][i] != 0)
				pqueue.offer(new Vertex(i, matrix[1][i]));
		}

		int maxCost = 0;
		int cnt = 1; // 선택된 정점의 수
		while (!pqueue.isEmpty()) {
			Vertex vertex = pqueue.poll();
			if (visit[vertex.v])
				continue;
			visit[vertex.v] = true;

			result += vertex.c;
//          maxCost = vertex.c; // 오류 ( pqueue 안에서 가장 작은 것이지 전체에서 가장 작은 것은 아니다.)
			maxCost = Math.max(maxCost, vertex.c);
			cnt++;
			if (cnt == N)
				break;

			for (int i = 1; i <= N; i++) {
				if (matrix[vertex.v][i] == 0 || visit[i])
					continue;
				pqueue.offer(new Vertex(i, matrix[vertex.v][i]));
			}
		}

		System.out.println(result - maxCost);
	}

	static class Vertex {
		int v, c;

		Vertex(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}