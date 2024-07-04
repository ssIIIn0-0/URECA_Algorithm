package DFSBFS_ch05;

import java.util.ArrayDeque;
import java.util.Queue;

// LinkedList -> ArrayDeque
public class 큐2 {

	public static void main(String[] args) {
		// offer() : 큐 끝에 요소 추가 poll() : 큐 앞에 요소 제거 peek() : 큐 앞에 있는 요소 반환
		 Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();
        
        // 먼저 들어온 원소부터 추출
        // 5(x) - 2(x) - 3 - 7 - 1 - 4
        while (!q.isEmpty()) {
//            System.out.println(q.poll());
            System.out.println(q.poll());
        }
		
	}

}
