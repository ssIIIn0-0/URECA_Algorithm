package DFSBFS_ch05;

import java.util.Stack;

public class 스택1 {

	public static void main(String[] args) {
		// 정수를 stack에 넣고 빼고 들여다 보고..
        Stack<Integer> s = new Stack<>();

        // push() pop(), peek()
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();	// 7 제거
        s.push(1);
        s.push(4);
        s.pop();
        
        // 스택의 최상단 원소부터 출력
        // 5 - 2 - 3 - 7(x) - 1 - 4(x)
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
// 어레이리스트는 쓰레드 세이프 안함
// 벡터는 쓰레드 세이프함
// stack 대신 arraydeque를 사용해라