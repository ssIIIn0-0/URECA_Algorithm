package 이것이코딩테스트다.DFSBFS_ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1260 {
	static int N, M, V;
	static List<List<Integer>> adjList = new ArrayList<>(); 
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 자료구조
        for (int i = 0; i < N+1; i++) {
            adjList.add(new ArrayList<Integer>());
        }
		
		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			adjList.get(i).add(j);
			adjList.get(j).add(i);	// 양방향 그래프이므로 반대쪽도 추가
		}
		
		// 오름차순으로 정렬
		for (List<Integer> list : adjList) {
            Collections.sort(list);
        }
		
		visit = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		visit = new boolean[N+1];
		bfs(V);
	}
	
	static void dfs(int V) {
		visit[V] = true;
		
		System.out.print(V + " ");
		
		List<Integer> list = adjList.get(V);
		for (Integer i : list) {
			if (visit[i]) continue;
			dfs(i);
		}
	}
	
	
	static void bfs(int V) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(V);
		visit[V] = true;
		
		while(! queue.isEmpty() ) {
            int v = queue.poll();
            
            System.out.print(v + " ");
            
            List<Integer> list = adjList.get(v);
            for (Integer i : list) {
                if( visit[i]) continue;
                queue.offer(i);
                visit[i] = true;
            }
        }
		
	}
}
