package 이것이코딩테스트다.Greedy_ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주어지는 배열의 수 전체를 다 고려하지 않고, 가장 큰 수, 두 번째 큰수만 고려
// 가장 큰 수, 두 번째 큰수를 정렬을 통해서 구함
// 이 후 코딩
//	1. 반복 <- 하나씩 하나씩...
//	2. 반복 미리 계산 <- 한꺼번에 계산

public class 큰수의법칙_3 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수
        // 가장 큰 수가 더해지는 횟수 계산
        // 큰 수 F 두 번째 수 S
        // m : 8, k : 3
        // FFFS + FFFS <= (k + 1) (k + 1)
        // m : 10, k : 3
        // FFFS + FFFS + FF <= (k + 1) (k + 1) 2
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);
        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기
        System.out.println(result);
    }
}
/*
5 8 3
2 4 5 4 6
46
*/

