package basic.tree;

import java.util.ArrayDeque;
import java.util.Queue;

// 1차원 배열로 2진 트리 표현
/*
               1
         2             3
     4      5       6      7
  8   9  10   11  12 13  14 15           
*/
// 1 차원 배열로 이루어진 이진트리를 bfs(), dfs() 로 탐색해 본다.
// 이진트리 구조에서 부모 -> 자식을 찾아갈 때 왼쪽 자식은 부모*2, 오른쪽 자식은 부모*2 + 1 <= index 기준
// 자식 -> 부모를 찾아갈 때 자식(왼,오 포함) / 2 (몫)

public class BinaryTreeSearch {

	static int[] tree = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		bfs(1);
		System.out.println(sb);

		sb.setLength(0);

		dfs(1);
		System.out.println(sb);
	}

	static void bfs(int idx) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(idx);

		while (!queue.isEmpty()) {
			int curIdx = queue.poll();

			// 탐색 순서 출력
			sb.append(tree[curIdx]).append(" ");

			int lcIdx = curIdx * 2;
			int rcIdx = curIdx * 2 + 1;

			if (lcIdx < tree.length)
				queue.offer(lcIdx);
			if (rcIdx < tree.length)
				queue.offer(rcIdx);

		}
	}

	static void dfs(int idx) {

	}

}
