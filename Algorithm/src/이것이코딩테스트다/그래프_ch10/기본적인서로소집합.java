package 이것이코딩테스트다.그래프_ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정점과 간선 정보 <= 집합 소속 관계
// 배열의 index : 정점, 배열의 값 : 정점이 포함되어있는 집합의 대표원소
public class 기본적인서로소집합 {
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
        
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }
        
        // 인덱스
        for (int i = 1; i <= v; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // parent 배열
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
        
        // 부모
        for (int i = 1; i <= v; i++) {
            System.out.print(findSet(i) + " ");
        }
        System.out.println();
        
    }
    static void makeSet() {
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
    }
    
    static int findSet(int x) { // 정점의 부모를 찾는 기능 
        if( parent[x] == x ) return x;
        return findSet(parent[x]);
    }
    
    static void union(int x, int y) { // 두 부모의 수 중 작은 수를 부모로
        int px = findSet(x);
        int py = findSet(y);
        if( px < py ) parent[py] = px;
        else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
    }
}

/*
6 4
1 4
2 3
2 4
5 6
*/