package 이것이코딩테스트다.DFSBFS_ch05;

import java.util.Arrays;
import java.util.PriorityQueue;

// PriorityQueue (우선 순위 - 정렬된 결과를 추출, 내부는 heap 구조) 연습
public class 큐4 {

	public static void main(String[] args) {
//		{
//			// Integer
//			PriorityQueue<Integer> pqueue = new PriorityQueue<>();
//			pqueue.offer(3);
//			pqueue.offer(2);
//			pqueue.offer(7);
//			pqueue.offer(5);
//			pqueue.offer(9);
//			
//			while ( ! pqueue.isEmpty()) {
//				System.out.println(pqueue.poll());
//			}
//			
//			for (Integer i : pqueue) {
//				System.out.println(i);	// 2 3 7 5 9 정렬 안됨, 입력순도 아님
//			}
//		}

//		{
//			// String
//			PriorityQueue<String> pqueue = new PriorityQueue<>();
//			pqueue.offer("b3");
//			pqueue.offer("a2");
//			pqueue.offer("x7");
//			pqueue.offer("d5");
//			pqueue.offer("s9");
//			
//			while ( ! pqueue.isEmpty()) {
//				System.out.println(pqueue.poll());
//			}
//		}
		
//		{
//			// user defined class
//			// 정렬 조건 추가 3: class에 comparable, anonymous 객체, lambda
//			PriorityQueue<Node> pqueue = new PriorityQueue<>();
//			pqueue.offer(new Node(3, 5, 2));
//			pqueue.offer(new Node(7, 1, 4));
//			pqueue.offer(new Node(5, 2, 9));
//			pqueue.offer(new Node(1, 1, 5));
//			
//			while ( ! pqueue.isEmpty()) {
//				System.out.println(pqueue.poll());
//			}
//		}
		
//		{
//			// user defined class + lambda
//			// 이럴 경우, class에 Implements 안붙여도됌.
//			PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.y - n2.y);
//			pqueue.offer(new Node(3, 5, 2));
//			pqueue.offer(new Node(7, 1, 4));
//			pqueue.offer(new Node(5, 2, 9));
//			pqueue.offer(new Node(1, 1, 5));
//			
//			while ( ! pqueue.isEmpty()) {
//				System.out.println(pqueue.poll());
//			}
//		}
		
		{
            // user defined class + lambda
            // 정렬 조건 추가 3: class 에 Comparable, anonymous 객체, lambda
            PriorityQueue<int[]> pqueue = new PriorityQueue<>( (a1, a2) -> a1[2] - a2[2] );
            pqueue.offer(new int[] {3, 5, 2});
            pqueue.offer(new int[] {7, 1, 4});
            pqueue.offer(new int[] {5, 2, 9});
            pqueue.offer(new int[] {3, 1, 5});
            
            while( ! pqueue.isEmpty() ) {
                System.out.println(Arrays.toString(pqueue.poll()));
            }
        }       

	}

	static class Node implements Comparable<Node>{
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
		@Override
		public int compareTo(Node o) {
//			return this.y - o.y;	// y 기준 오름차순 
//			return o.y - this.y;	// y 기준 내림차순
//			return this.c - o.c;	// c 기준 오름차순
			return this.y == o.y ? this.x - o.x : this.y - o.y;	// y가 같을 경우 x값에 따라 오름차순
		}
	}

		
}
