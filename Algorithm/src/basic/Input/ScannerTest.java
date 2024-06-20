package basic.Input;

import java.util.Arrays;
import java.util.Scanner;

// Scanner : 편함 BUT 무거움
// Scanner sc = new Scanner(System.in); 선언
// 입력이 " " 공백이 있는 경우
// sc.nextInt(); 정수값을 받음
// sc.next().charAt(0); 문자가 섞여있는 경우, String으로 받은 후 char로 변경해서 char값으로 받음
// 입력이 " " 공백이 없는 경우 (String)인 경우
// sc.nextLine().toCharArray(); 한 줄의 String을 받은 후 char단위로 잘라줌
public class ScannerTest {

	public static void main(String[] args) throws Exception{
//		{// 입력 : 1 2 3 4 5
//			Scanner sc = new Scanner(System.in);
//			int[] input = new int[5];
//			for (int i = 0; i < 5; i++) {
//				input[i] = sc.nextInt();
//			}
//			
//			for (int i = 0; i < 5; i++) {
//				System.out.println(input[i]);
//			}
//			
//			System.out.println(Arrays.toString(input));	//,로 구분하는 문자열을 출력해줌
////			sc.close(); 어차피 vm이 끝나면 알아서 끝나기 때문에 알고리즘 문제를 풀 때는 close안해도 됨.
//		}

//		{// 입력 : 1 A 3 4 G
//			Scanner sc = new Scanner(System.in);
//			char[] input = new char[5];
//			for (int i = 0; i < 5; i++) {
//				input[i] = sc.next().charAt(0);	// String -> char을 해주기 위해 charAt(i)를 했고, 어차피 한 글자라 i=0
//				// sc.char() 이런게 없어서 String으로 받는 sc.next()를 사용
//			}
//			
//			System.out.println(Arrays.toString(input));
//		}

//		{// 입력 : XYESG
//			Scanner sc = new Scanner(System.in);
//			// new char로 객체배열1을 만들었는데, toCharArray()도 객체배열2를 만들어서 input에 넣는다.
//			// 그러면 객체배열1은 garbage가 되므로 비효율적이라
//			// toCharArray(); 를 사용할 때는 미리 객체 변수를 만들지 않는게 좋다.
//			char[] input = new char[5];
//			input = sc.nextLine().toCharArray();	// "XYESG" -> ['X', 'Y'...]
//			
//			char[] input = sc.nextLine().toCharArray();	// "XYESG" -> ['X', 'Y'...]
//			
//			System.out.println(Arrays.toString(input));
//		}

//		{	// 입력받을 개수 n 을 입력받고, n만큼 입력받는 경우 공백O
//			// 6
//			// 1 2 3 4 5 1
//			Scanner sc = new Scanner(System.in);
//			int N = sc.nextInt();
//			int[] input = new int[N];
//			
//			for(int i = 0; i < N; i++) {
//				input[i] = sc.nextInt();
//			}
//			
//			System.out.println(Arrays.toString(input));	
//		}

		{// 입력받을 개수 n 을 입력받고, n만큼 입력받는 경우 공백X
//			// 5\n
//			// XYESG\n
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();	// 5
			sc.nextLine();	// \n, 남아있는 빈 개행문자\n을 처리해야 밑에 있는 sc.nextLine에서 \n을 받지 않는다. 
			char[] input = sc.nextLine().toCharArray();	// XYESG

			System.out.println(Arrays.toString(input));
		}
	}

}
