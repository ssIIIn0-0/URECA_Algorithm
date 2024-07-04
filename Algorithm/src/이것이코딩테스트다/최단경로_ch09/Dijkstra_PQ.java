package 최단경로_ch09;

// 그래프 자료구조 (인접행렬)
// 비용관리 배열(시작점으로부터 각 정점까지의 최소비용(최단거리))
// 고려하는(Queue에 담긴) 정점 중 시작점에서부터 최소비용의 정점 찾는 priority Queue
// 최소비용으로 고려했던(방문했던) 정점관리 visit
// priority queue 에 담을 vertex(Node) 클래스(정점번호, 시작점으로부터의 비용)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_PQ {
    static class Node{
        int v; // 정점 번호
        int c; // 시작 정점에서부터의 거리
        
        Node(int v, int c){
            this.v = v; this.c = c;
        }
    }
    
    static int V, start, end;
    static int[][] matrix; // 한 정점에서 다른 정점으로 가는 비용, 0 은 연결 X
    static int[] cost; // 시작점으로부터 각 정점까지의 최소비용
    static boolean[] visit;
    static final int INF = Integer.MAX_VALUE; // cost 배열 초기화
    static PriorityQueue<Node> pqueue = new PriorityQueue<>( (n1, n2) -> n1.c - n2.c );
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        start = 0;
        end = V - 1;
        
        matrix = new int[V][V];
        cost = new int[V];
        visit = new boolean[V];
        
        // 입력 -> matrix 구성
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()); // 비용 i -> j
            }
        }
        // 비용 테이블 충분히 큰 값으로 초기화
        Arrays.fill(cost, INF);
        
        // 다익스트라
        cost[start] = 0;
        pqueue.offer(new Node(start, 0)); // 시작 정점을 pqueue 에 넣고 다익스트라 진행
        
        while(! pqueue.isEmpty() ) { // 전체를 모두 끝내면 모든 정점에 대한 최단경로(최소비용)이 완성
            Node node = pqueue.poll();
            if( visit[node.v] ) continue; // 이미 방문한 정점 skip
            visit[node.v] = true;
            
            // 모든 정점이 아니라 목표하는 정점만 따질 경우 
            if(node.v == end) break;
            
            for (int i = 0; i < V; i++) { // 꺼낸 node.v 정점 ~~> i 고려
                if( matrix[node.v][i] == 0 ) continue;
                // 아직 방문하지 않은(최소비용노드로 확정되지 않은..)
                // i 번 정점 고려중
                //   현재 cost[i] 는 시작점 ~~~> i 정점까지의 최소비용이 기록
                //   만약 node.v 정점을 거쳐서 i 로 가면 cost[i] 가 줄어 줄 수 있나??
                if( cost[i] > node.c + matrix[node.v][i] ) {
                    cost[i] = node.c + matrix[node.v][i]; // 최소 비용 갱신 (i의)
                    pqueue.offer(new Node(i, cost[i]));
                }
            }
            
        }
        
        System.out.println(cost[end]);
    }
}


/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

==> 8

4 
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

==> 14
 */