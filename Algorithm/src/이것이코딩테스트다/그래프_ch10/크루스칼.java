package 이것이코딩테스트다.그래프_ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST
// 간선 중심 - 간선 리스트
public class 크루스칼 {
    static int V, E, result; // MST 총 비용
    static int[] parent;
    static Edge[] edges; // 간선 리스트 
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V];
        edges = new Edge[E];
        
        // 입력 처리
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            edges[i] = new Edge(v1, v2, c);
        }
        
        // 쿠르스칼 알고리즘
        // 간선 정렬
        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
        
        // 집합 배열 처리
        makeSet();
        
        int cnt = 0; // V - 1 개 만들면 된다. (cycle 이 없는)
        for (Edge edge : edges) {
            // cycle 체크
            if( union(edge.v1, edge.v2) ) {
                result += edge.c;
                cnt++;
                if( cnt == V - 1 ) break;
            }           
        }
        System.out.println(result);
    }
    static void makeSet() {
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }
    
    static int findSet(int x) { // 정점의 부모를 찾는 기능 
        if( parent[x] == x ) return x;
        return parent[x] = findSet(parent[x]);
    }
    
//  static void union(int x, int y) { // 두 부모의 수 중 작은 수를 부모로
//      int px = findSet(x);
//      int py = findSet(y);
//      if( px < py ) parent[py] = px;
//      else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
//  }
    
    static boolean union(int x, int y) { // 쿠르스칼 사용 버전
        int px = findSet(x);
        int py = findSet(y);
        
        if( py == px ) return false; // 두 부모가 같다. cycle 발생
        
        if( px < py ) parent[py] = px;
        else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
        
        return true;
    }
    
    static class Edge{
        int v1, v2, c;
        
        Edge(int v1, int v2, int c){
            this.v1 = v1;
            this.v2 = v2;
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
