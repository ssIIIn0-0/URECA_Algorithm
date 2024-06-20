package basic.Input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {

	public static void main(String[] args) throws Exception {
//		{// 1 2 3 4 5
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String str = br.readLine();	// 한 줄 전체를 문자열 하나로 읽음
//			StringTokenizer st = new StringTokenizer(str);	// 문자열을 전달해서 StringTokenizer 가 개별 문자열로 쪼갤 준비
//			
//			int[] input = new int[5];
//			for (int i = 0; i < 5; i++) {
//				input[i] = Integer.parseInt(st.nextToken());	// "1" -> 1, "2" -> 2 ...
//			}
//			System.out.println(Arrays.toString(input));
//		}

//		{	// 1 A 3 4 G
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String str = br.readLine();	
//			StringTokenizer st = new StringTokenizer(str);
//			
//			char[] input = new char[5];
//			for(int i = 0; i < 5; i++) {
//				input[i] = st.nextToken().charAt(0);
//			}
//			System.out.println(Arrays.toString(input));
//		}

//		{	// XYESG
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			char[] input = br.readLine().toCharArray();
//			System.out.println(Arrays.toString(input));
//		}

//		{// 입력받을 개수 n 을 입력받고, n만큼 입력받는 경우 공백O
//		 // 6
//		 // 1 2 3 4 5 1
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			int N = Integer.parseInt(br.readLine());
//			int[] input = new int[N];	// 6
//			StringTokenizer st = new StringTokenizer(br.readLine());	// 1 2 3 4 5 1
//			
//			for(int i = 0; i < N; i++) {
//				input[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			System.out.println(Arrays.toString(input));
//		}

//		{// 입력받을 개수 n 을 입력받고, n만큼 입력받는 경우 공백X
//			// 5\n
//			// XYESG\n
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			int N = Integer.parseInt(br.readLine());
//			char[] input = br.readLine().toCharArray();
//
//			System.out.println(Arrays.toString(input));
//
//		}

//		{// 입력받을 개수 n 을 입력받고, n만큼 입력받는 경우 공백X
//			// 5
//			// 1 2 3 4 5
//			// 6 7 8 9 0
//			// 1 2 3 4 5
//			// 6 7 8 9 0
//			// 1 2 3 4 5
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			int N = Integer.parseInt(br.readLine());
//			
//			int[][] input = new int[N][N];
//			
//			for (int i = 0; i < N; i++) {	// 행
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < N; j++) {	// 열
//					input[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			for (int i = 0; i < N; i++) {	// 행
//				System.out.println(Arrays.toString(input[i]));
//			}
//
//		}
		
//		{// 입력받을 개수 n 을 입력받고, n만큼 입력받는 경우 공백X
//			// 3 5
//			// 1 2 3 4 5
//			// 6 7 8 9 0
//			// 1 2 3 4 5
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			StringTokenizer st = new StringTokenizer(br.readLine());	// "3 5"
//			int N = Integer.parseInt(st.nextToken());	// 3
//			int M = Integer.parseInt(st.nextToken());	// 5
//			
//			int[][] input = new int[N][M];
//			
//			for (int i = 0; i < N; i++) {	// 행
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < M; j++) {	// 열
//					input[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			for (int i = 0; i < N; i++) {	// 행
//				System.out.println(Arrays.toString(input[i]));
//			}
//
//		}
		
		
		{// 첫 줄에 테스트케이스 개수 (3), 둘째줄부터 테스트케이스, 각 테스트케이스는 첫 줄ㄹ에 N, M, 이어지는 N개의 줄에 M개의 수가 주어진다
		 // 3
			
		 // 2 2
		 // 1 2
		 // 6 7
			
		 // 3 5
		 // 1 2 3 4 5
		 // 6 7 8 9 0
		 // 1 2 3 4 5
			
		 // 2 1
		 // 8
		 // 9
			System.setIn (new FileInputStream("input.txt"));	// 테케 붙여넣기 대신 사용(파일 생성)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t <= T; t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				
				int[][] input = new int[N][M];
				
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < M; j++) {
						input[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				// 출력
				System.out.println(t);
				for (int i = 0; i < N; i++) {
					System.out.println(Arrays.toString(input[i]));
				}
			}
			
		}

	}
// 1. 디버거를 적극적으로 활용
// 2. 파일 입력을 적극적으로 활용
}
