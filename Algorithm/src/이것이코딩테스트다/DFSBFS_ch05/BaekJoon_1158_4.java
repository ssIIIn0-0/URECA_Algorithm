package 이것이코딩테스트다.DFSBFS_ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


//자료구조 1. 배열
//자료구조 2. ArrayList, Queue
//Queue : 살아 있는 사람만 관리, Queue 에서 꺼내서 K 번째이면 죽이고, 그렇지 않으면 다시 넣는다.

public class BaekJoon_1158_4 {
	static int N, K;
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 번호를 채우고
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        // 풀이
        int aliveCnt = 1; // 살아 있는 번호에서만 증가 <= K 번째를 판단
        
        sb.append("<");
        while( ! queue.isEmpty() ) {
            int num = queue.poll();
            
            if( ( aliveCnt % K ) == 0 ) {
                sb.append(num).append(", ");
            }else {
                queue.offer(num);
            }
            aliveCnt++;
        }
        
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }
}

