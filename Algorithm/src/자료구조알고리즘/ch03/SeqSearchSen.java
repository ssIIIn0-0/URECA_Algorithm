package 자료구조알고리즘.ch03;

import java.util.Arrays;
import java.util.Scanner;

// 보초법
public class SeqSearchSen {
	static int seqSearchSen(int[] a, int n, int key) { // key : 찾는 항목
		int i = 0;
		a[n] = key; // 맨 마지막 인덱스에 찾는 key 추가

		while (true) {
			if (a[i] == key)
				break; // 중간에 찾던, 마지막에 찾던
			i++;
		}

		return i == n ? -1 : i;
	}

	public static void main(String[] args) {
		// 사용자로부터 배열의 길이, 각 배열의 항목을 입력받고 검색하는 코드
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요소 수 :");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1]; // 마지막 보초를 위한 차리 1 더 만든다.

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		System.out.println(Arrays.toString(x));

		while (true) {
			System.out.print("검색할 값: ");
			int ky = stdIn.nextInt();
			if (ky == -1)
				break;

			int idx = seqSearchSen(x, num, ky);

			if (idx == -1) {
				System.out.println("검색 실패");
			} else {
				System.out.println("검색 요소는 " + idx + " 번째에 있습니다.");
			}
		}
	}
}
