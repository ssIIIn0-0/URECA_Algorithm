package 이것이코딩테스트다.DFSBFS_ch05;

import java.util.LinkedList;
import java.util.Queue;

public class 큐1 {

	public static void main(String[] args) {
		// offer() : 큐 끝에 요소 추가 poll() : 큐 앞에 요소 제거 peek() : 큐 앞에 있는 요소 반환
		 Queue<Integer> q = new LinkedList<>();
		
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
