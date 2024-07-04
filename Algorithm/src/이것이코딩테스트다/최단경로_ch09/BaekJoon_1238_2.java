package 이것이코딩테스트다.최단경로_ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 다익스트라
// 그래프 자료구조 : 인접 리스트
public class BaekJoon_1238_2{
    static int N, M, X, max;
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> goList = new ArrayList<>(); // X 로 가는 
    static List<List<Node>> backList = new ArrayList<>(); // X  에서 집으로 되돌아 오는
    static PriorityQueue<Node> pqueue = new PriorityQueue<>( (n1, n2) -> n1.t - n2.t );
    static int[] goCost;
    static int[] backCost;
    static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            goList.add(new ArrayList<>());
            backList.add(new ArrayList<>());
        }
        
        goCost = new int[N + 1];
        backCost = new int[N + 1];
        visit = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) { // 간선
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            goList.get(a).add(new Node(b, t));
            // a -> b 길 중에 분명히 집 -> X 로 가는 최단 경로가 존재할 것이고 역으로 뒤집으면 그 길이 X -> 집 다익스트라로 처리
            backList.get(b).add(new Node(a, t));
        }
        
        // 풀이
        max = Integer.MIN_VALUE;
        
        dijkstra(goList, goCost);
        dijkstra(backList, backCost);
        
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, goCost[i] + backCost[i]);
        }
        
        System.out.println(max);
    }
    
    static void dijkstra(List<List<Node>> list, int[] cost) {
    	// cost, visit 초기화
        Arrays.fill(cost, INF);
        Arrays.fill(visit, false);
        
        // 시작점 X
        cost[X] = 0;
        pqueue.offer(new Node(X, 0));
        
        while(! pqueue.isEmpty() ) {
            Node node = pqueue.poll();
            if( visit[node.v] ) continue;
            visit[node.v] = true;
            
            for (Node n : list.get(node.v)) {
                if( visit[n.v] ) continue;
                if( cost[n.v] > cost[node.v] + n.t ) {
                    cost[n.v] = cost[node.v] + n.t;
                    pqueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }
    }
    static class Node{
        int v; // 정점 마을(집)
        int t; // 시간
        
        Node(int v, int t){
            this.v = v;
            this.t = t;
        }
    }
}

/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

10
*/