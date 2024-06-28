package Sort_ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1074 {

	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 2 제곱수
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N); // N 을 2^N 으로 보정

		// 원접부터 (r,c) 까지의 거리
		int y = 0;
		int x = 0;

		// 반복문으로 분할 정복
		// (r,c) 위치까지 찾아질 동안 계속 분할 처리
		while (true) {
			if (N == 1)
				break;

			N /= 2;

			if (r < y + N && c < x + N) {
				; // 분할 영역
			} else if (r < y + N && c >= x + N) {
				ans += N * N * 1;
				x += N;
			} else if (r >= y + N && c < x + N) {
				ans += N * N * 2;
				y += N;
			} else {
				ans += N * N * 3;
				y += N;
				x += N;
			}
		}

		System.out.println(ans);
	}

}
