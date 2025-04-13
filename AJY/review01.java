// 바닥공사 1
// don't place package name.

import java.io.*;
import java.util.*; 

// don't change 'Main' class name and  'public' accessor.

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int MOD = 796796;
        int[] dp = new int[n+2]; // n까지 접근 가능하도록 n+2 크기로 선언

        // 초기값 설정
        dp[0] = 1; // 가로 길이 0일 때는 아무 타일도 놓지 않는 한 가지 경우
        dp[1] = 1; // 가로 길이 1일 때는 세로로 2x1 타일 하나를 놓는 경우 한 가지

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[n]);
    }
}