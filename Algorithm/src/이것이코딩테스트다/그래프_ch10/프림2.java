package 그래프_ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// MST
// 정점 중심 - 인접 리스트, 인접 행렬
// 시작점을 PQ 에 넣고 시작
// PQ 에 담긴(고려하는 ) 정점 중 가장 비용이 적은 정점을 꺼내서
// 갈 수 있는 새로운 정점을 다시 PQ 에 넣고 이 과정을 반복한다.
// 비용이 가장 작은 정점 선택이 V 개 선택
// 그래프 : 인접행렬 + 입력 테케 : 간선 정보
// PriorityQueue
// visit

public class 프림2 {
    static int V, E, result;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>( (v1, v2) -> v1.c - v2.c );
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        matrix = new int[V][V];
        visit = new boolean[V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            matrix[v1][v2] = c;
            matrix[v2][v1] = c;
        }
        
        // 프림
        // #1
//      pqueue.offer(new Vertex(0, 0));
//      int cnt = 0;
        
        // #2
        visit[0] = true;
        for (int i = 0; i < V; i++) {
            if( matrix[0][i] == 0  ) continue;
            pqueue.offer(new Vertex(i, matrix[0][i])); // 정점번호 i, 비용 vertex.v -> i
        }           
        int cnt = 1;
        
        while(! pqueue.isEmpty() ) {
            Vertex vertex = pqueue.poll();
            if( visit[vertex.v] ) continue;
            // MST 를 구성하는 정점이 선택됨
            visit[vertex.v] = true;
            result += vertex.c;
            cnt++;
            if( cnt == V ) break;
            
            // 꺼낸 정점으로부터 갈 수 있고 아직 방문하지 않은 정점이 있으면 pqueue 에 추가
            for (int i = 0; i < V; i++) {
                if( matrix[vertex.v][i] == 0 || visit[i] ) continue;
                pqueue.offer(new Vertex(i, matrix[vertex.v][i])); // 정점번호 i, 비용 vertex.v -> i
            }           
        }
        System.out.println(result);
    }
    
    static class Vertex{
        int v, c;
        Vertex(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
}

/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
==> 10
----------------------------------
7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14
==>31
 */

