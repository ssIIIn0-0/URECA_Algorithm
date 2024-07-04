package 이것이코딩테스트다.그래프_ch10;

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
// 그래프 : 인접행렬
// PriorityQueue
// visit
public class 프림 {
    static int V, result;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>( (v1, v2) -> v1.c - v2.c );
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        matrix = new int[V][V];
        visit = new boolean[V];
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 프림
        pqueue.offer(new Vertex(0, 0));
        int cnt = 0;
        
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
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
==> 10
*/
