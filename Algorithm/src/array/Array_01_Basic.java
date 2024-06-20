package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Array_01_Basic {

	public static void main(String[] args) throws Exception {
		// Q1
		// "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi"
		// 위 문자열 중 각 알파벳 문자의 사용 횟수(빈도수)
		// a ~ z 까지 모든 알파벳의 사용 횟수를 출력하세요

		// 씬 코드 (map 사용)
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			char[] input = br.readLine().toCharArray();
//			Map<Character, Integer> answer = new HashMap<>();
//
//			for (char c = 'a'; c <= 'z'; c++) {
//				answer.put(c, 0);
//			}
//
//			for (char c : input) {
//				if (answer.containsKey(c))
//					answer.put(c, answer.get(c) + 1);
//			}
//
//			for (char c = 'a'; c <= 'z'; c++) {
//				System.out.println(answer.get(c));
//			}
//		}

		// 씬 코드 (배열만 사용)
//		{
//			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
//			char[] input2 = br2.readLine().toCharArray();
//			int[] answer2 = new int[26];
//
//			for (char c : input2) {
//				answer2[c - 'a']++;
//			}
//
//			for (int i : answer2)
//				System.out.println(i);
//		}

		// 강사님 코드
//		{
//			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
//			String input3 = br3.readLine();
//			int[] answer3 = new int[26];
//
//			for (int i = 0; i < input3.length(); i++) {
//				answer3[input3.charAt(i) - 'a']++;
//			}
//
//			for (int i = 0; i < 26; i++) {
//				System.out.println( (char)(i + 'a') + " " + answer3[i]);
//			}
//		}

		// Q2
		// 배열의 맨 앞부터 각 3개씩 일정한 규칙이 있다. 앞 * 중 = 뒤
		// 규칙에 위반되는 쌍이 몇 개인지 츌력
		// 3,2,6,3,4,4,1,4,2,2,3,6,1,3,5,1,5,1,1,1,1,2,4,2,2,2,4
		// 씬 코드
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int len = str.length();	// 53 (,까지 계산됨)
			StringTokenizer st = new StringTokenizer(str, ",");
			int[] intArray = new int[len];
			int answer = 0;

			for (int i = 0; i < len/2+1; i++) {
				intArray[i] = Integer.parseInt(st.nextToken());
				System.out.print(intArray[i]);
			}

			len = intArray.length;
			for (int i = 2; i < len; i++) {
				if (i % 3 == 2) {
					if (intArray[i - 2] * intArray[i - 1] != intArray[i]) {
						System.out.println(intArray[i - 2] +" " + intArray[i - 1] + " " + intArray[i] );
						answer++;
					}
					else
						continue;
				}
			}

			System.out.println(answer);
		}

		// 강사님 코드
//		{
//			int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
//			
//			int wrongCnt = 0;
//			int intLength = intArray.length - 2;
//			
//			for (int i = 0; i < intLength; i = i + 3) {
//				if (intArray[i] * intArray[i+1] != intArray[i+2]) wrongCnt++;
//			}
//			System.out.println(wrongCnt);
//		}

		// Q3
		// "XYZEBFFGQOVVPWGFFCEAYX"
		// --> <--
		// 좌우 배대칭 문자가 있으면 출력, 저ㅓㄴ체 비대칭 문자가 몇 개인지 출력
		// 문자열의 길이는 짝수 보장
//		{
//			String str = "XYZEBFFGQOVVPWGFFCEAYX";
//			char[] chArray = str.toCharArray();
//			int wrongCnt = 0;
//			int center = chArray.length / 2;
//
//			for (int l = 0, r = chArray.length - 1; l < chArray.length; l++, r--) {
//				if (chArray[l] != chArray[r]) {
//					System.out.println(chArray[l] + " " + chArray[r]);
//					wrongCnt++;
//				}
//			}
//			System.out.println(wrongCnt);
//		}

	}

}

