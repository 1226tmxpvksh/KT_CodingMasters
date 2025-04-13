#배수만들기
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        int n = scanner.nextInt(); // 숫자의 개수
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = scanner.nextInt();
        }

        // Step 1: 내림차순 정렬
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (digits[j] < digits[j + 1]) {
                    int temp = digits[j];
                    digits[j] = digits[j + 1];
                    digits[j + 1] = temp;
                }
            }
        }

        // Step 2: 모든 숫자가 0인지 확인
        if (digits[0] == 0) { // 가장 큰 숫자가 0이면 모든 숫자가 0임
            System.out.println("0");
            return;
        }

        // Step 3: 모든 자리 숫자의 합 계산
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += digits[i];
        }

        // Step 4: 3의 배수 조건 확인
        if (totalSum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        // Step 5: 최소 두 개의 '0'이 있는지 확인
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                zeroCount++;
            }
        }

        if (zeroCount < 2) {
            System.out.println("-1");
            return;
        }

        // Step 6: 조건을 만족하면 정렬된 숫자를 이어붙임
        String result = ""; // 빈 문자열 초기화
        for (int i = 0; i < n; i++) {
            result += digits[i]; // 문자열 연결
        }

        System.out.println(result);
    }
}
