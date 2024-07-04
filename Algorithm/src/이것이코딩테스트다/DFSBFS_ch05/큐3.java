package 이것이코딩테스트다.DFSBFS_ch05;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// Queue 연습
public class 큐3 {

	public static void main(String[] args) {
		{
			// 사용자 정의 user defined class
			Queue<Node> queue = new ArrayDeque<>();
			queue.offer(new Node(3, 0, 1));
			queue.offer(new Node(1, 2, 3));
			queue.offer(new Node(7, 4, -3));
			queue.offer(new Node(6, 5, 7));
			
			while ( ! queue.isEmpty()) {
				System.out.println(queue.poll());
			}
		}
		
		{
			// 배열
			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {3, 0, 1});
			queue.offer(new int[] {1, 2, 3});
			queue.offer(new int[] {7, 4, -3});
			queue.offer(new int[] {6, 5, 7});
			
			while ( ! queue.isEmpty()) {
				System.out.println(Arrays.toString(queue.poll()));
			}
		}
		
	}

	static class Node{
		int y, x, c;
		Node(int y, int x, int c){
			this.y = y;
			this.x = x;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "[y=" + y + ", x=" + x + ", c=" + c + "]";
		}
		
		
		
	}
}
