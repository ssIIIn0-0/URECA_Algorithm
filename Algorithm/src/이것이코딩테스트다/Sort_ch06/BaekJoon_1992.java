package 이것이코딩테스트다.Sort_ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_1992 {
	static int[][] img;
	static StringBuilder sb = new StringBuilder();	// 출력값을 한번에 묶어서 출력
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		img = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				img[i][j] = str.charAt(j) - '0';
			}
		}
		
		QuadTree(0, 0, N);
		System.out.println(sb);
	}
	
	public static void QuadTree(int x, int y, int size) {
		
		// 압축이 가능할 경우 압축
		if(isPossible(x, y, size)) {
			sb.append(img[x][y]);
			return;
		}
		
		int newSize = size / 2;	// 압축이 불가능 할 경우 한 변의 길이를 반으로 나눈다.
		
		sb.append('(');	// 각 레벨(depth)에서 여는괄호로 시작해야한다. 
		
		QuadTree(x, y, newSize);						// 왼쪽 위
		QuadTree(x, y + newSize, newSize);				// 오른쪽 위
		QuadTree(x + newSize, y, newSize);				// 왼쪽 아래
		QuadTree(x + newSize, y + newSize, newSize);	// 오른쪽 아래
		
		sb.append(')');	// 해당 레벨이 끝나면 닫는괄호도 닫아준다.
	}
	
	// 압축이 가능한지 해당 공간을 체크해주는 함수
	static boolean isPossible(int x, int y, int size) {
		int value = img[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(value != img[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
