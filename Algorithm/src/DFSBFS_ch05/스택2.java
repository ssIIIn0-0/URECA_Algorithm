package DFSBFS_ch05;

import java.util.ArrayDeque;
import java.util.Deque;

// Stack -> ArrayDeque
public class 스택2 {

	public static void main(String[] args) {
        Deque<Integer> s = new ArrayDeque<>(); // stack도 되고, queue도 됨
        
        // push() pop() peek()
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop(); // 7 제거
        s.push(1);
        s.push(4);
        s.pop();
        
        // 5 - 2 - 3 - 7(x) - 1 - 4(x)
        while( ! s.isEmpty() ) {
//          System.out.println(s.peek()); // 꺼내진 않는다.
            System.out.println(s.pop());
        }
    }

}

// 어레이리스트는 쓰레드 세이프 안함
// 벡터는 쓰레드 세이프함
// stack이 필요할 때는, stack 대신 deque, arraydeque를 사용해라