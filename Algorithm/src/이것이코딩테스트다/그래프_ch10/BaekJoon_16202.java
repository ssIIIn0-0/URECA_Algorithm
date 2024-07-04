package 그래프_ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_16202 {

	static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static PriorityQueue<Edge> mst;
    static int[] parent;
 
    public static void main(String[] args) throws Exception {
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        for(int i = 1; i <= m; i++) {
            str = bf.readLine();
            st = new StringTokenizer(str);
            pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }
        //입력 끝
 
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < k; i++) {
            mst = new PriorityQueue<>();
            int[] result = kruskal(n);
            if(result[1] == n - 1) sb.append(result[0] + " ");
            else {
                sb.append("0 ".repeat(k - i));
                break;
            }
            mst.poll();
            pq = mst;
        }
        System.out.println(sb.toString());
    }
 
    public static int[] kruskal(int n) {
        int[] parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
 
        int total = 0;
        int size = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int p1 = find(e.n1, parent);
            int p2 = find(e.n2, parent);
            if(p1 != p2) {
                union(p1, p2, parent);
                total += e.cost;
                size++;
            }
            mst.offer(e);
        }
        return new int[] {total, size};
    }
 
    static void union(int a, int b, int[] parent) {
        parent[a] = b;
    }
 
    static int find(int n, int[] parent) {
        if(parent[n] == n) return n;
        else return parent[n] = find(parent[n], parent);
    }
 
    static class Edge{
        int n1, n2, cost;
 
        Edge(int n1, int n2, int cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }
    }
}

