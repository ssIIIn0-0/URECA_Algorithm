package 이것이코딩테스트다.구현_ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1158_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        boolean[] isRemoved = new boolean[n];  // 각 사람이 제거되었는지 여부를 기록
        int[] result = new int[n];  // 요세푸스 순열을 저장할 배열
        
        int currentIndex = 0;  // 현재 인덱스
        int count = 0;  // 제거된 사람 수
        int currentPerson = 0;  // 현재 사람 번호
        
        while (count < n) {
            int steps = 0;
            while (steps < k) {
                if (!isRemoved[currentIndex]) {
                    steps++;
                }
                if (steps == k) {
                    break;
                }
                currentIndex = (currentIndex + 1) % n;
            }
            
            result[currentPerson] = currentIndex + 1;  // 사람 번호는 1부터 시작하므로 +1
            isRemoved[currentIndex] = true;
            count++;
            currentPerson++;
        }
        
        System.out.print("<");
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(result[i]);
            } else {
                System.out.print(result[i] + ", ");
            }
        }
        System.out.print(">");
    }
}

