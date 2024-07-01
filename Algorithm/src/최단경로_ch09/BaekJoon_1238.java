package 최단경로_ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_1238 {
	static int N; // N명의 학생
	static int M; // M개의 단방향 도로
	static int X; // 파티를 하는 X번 마을

	static class Node implements Comparable<Node> {
		int node;
		int cost;

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 내 마을 -> 파티 열리는 마을
        // 각 마을당 연결될 길을 받을 리스트 할당
        List<List<Node>> city = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }

        // 각 마을당 길 입력(파티가는 길)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //city[해당 마을]-NODE(연결된마을, 거리)
            city.get(start).add(new Node(dest, cost));
        }
        // 다익스트라 시작
        int[] toX = dijkstra(city, N, X);

        
        //  파티 열리는 마을 -> 내 마을
        // 각 마을당 연결될 길을 받을 리스트 할당
        List<List<Node>> reverseCity = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            reverseCity.add(new ArrayList<>());
        }
        
        // 각 마을당 길 입력(집가는 길)
        for (int i = 1; i <= N; i++) {
            for (Node node : city.get(i)) {
                reverseCity.get(node.node).add(new Node(i, node.cost));
            }
        }
        
        // 다익스트라 시작
        int[] fromX = dijkstra(reverseCity, N, X);

        for (int i = 1; i <= N; i++) {
        	System.out.println("toX " + i + " : " + toX[i]);
        	System.out.println("fromX " + i + " : " + fromX[i]);
        }
        
        // 결과값 출력
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }

        System.out.println(max);
	}
	
	static int[] dijkstra(List<List<Node>> graph, int n, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.node;

            if (visited[curNode]) continue;
            visited[curNode] = true;

            for (Node neighbor : graph.get(curNode)) {
                if (dist[neighbor.node] > dist[curNode] + neighbor.cost) {
                    dist[neighbor.node] = dist[curNode] + neighbor.cost;
                    pq.offer(new Node(neighbor.node, dist[neighbor.node]));
                }
            }
        }

        return dist;
    }
}
