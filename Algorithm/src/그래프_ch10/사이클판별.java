package 그래프_ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클판별 {
    static int v, e; // 정점, 간선
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1]; // 1번 정점부터
        
        // 자료구조를 집합관계로 만들어라 // 각 정점은 모두 서로소  // parent[3] => 4 ( 3 정점은 4 가 부모인 집합 포함 )
        makeSet(); 
        
        // 간선을 통해 연결 하는 과정에서 cycle 이 발생하는 지 판단
        boolean cycle = false;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if( findSet(x) == findSet(y) ) {
                System.out.println(x + ", " + y);
                cycle = true;
                break;
            }else {
                union(x, y);
            }
        }
        
        if( cycle ) {
            System.out.println("사이클 발생");
        }else {
            System.out.println("사이클 발생 X");
        }
    }
    static void makeSet() {
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
    }
    
    static int findSet(int x) { // 정점의 부모를 찾는 기능 
        if( parent[x] == x ) return x;
        return parent[x] = findSet(parent[x]);
    }
    
    static void union(int x, int y) { // 두 부모의 수 중 작은 수를 부모로
        int px = findSet(x);
        int py = findSet(y);
        if( px < py ) parent[py] = px;
        else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
    }
}

/*
3 3
1 2
1 3
2 3
*/

/*
3 3
1 2
1 3
2 3
7 9
1 2
1 5
5 6
2 3
2 6
3 4
6 4
6 7
4 7
-- 2 6 맨 뒤로
7 9
1 2
1 5
5 6
2 3
3 4
6 4
6 7
4 7
2 6
-- 2 6 6 4 제거
7 7
1 2
1 5
5 6
2 3
3 4
6 7
4 7
-- 4 7 제거
7 6
1 2
1 5
5 6
2 3
3 4
6 7
*/