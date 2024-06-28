package Sort_ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//재귀 호출
public class BaekJoon_1074_2 {

	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 2 제곱수
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N); // N 을 2^N 으로 보정

		z(0, 0);

		System.out.println(ans);
	}

	static void z(int y, int x) {
		if (N == 1)
			return;

		N /= 2;

		if (r < y + N && c < x + N) {
			z(y, x);
		} else if (r < y + N && c >= x + N) {
			ans += N * N * 1;
			z(y, x + N);
		} else if (r >= y + N && c < x + N) {
			ans += N * N * 2;
			z(y += N, x);
		} else {
			ans += N * N * 3;
			z(y + N, x + N);
		}
	}

}
