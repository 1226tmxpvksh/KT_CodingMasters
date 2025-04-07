// 분리수거장
// don't place package name.

import java.io.*;
import java.util.*;

// don't change 'Main' class name and 'public' accessor.

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // 아파트 정보를 저장할 배열 생성
        int[][] apt = new int[n][3];

        for (int i = 0; i < n; i++) {
            apt[i][0] = scanner.nextInt();
            apt[i][1] = scanner.nextInt(); 
            apt[i][2] = i + 1;             
        }

        // 버블 정렬로 아파트 위치 기준으로 정렬
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (apt[j][0] > apt[j + 1][0]) {
                    int[] temp = apt[j];
                    apt[j] = apt[j + 1];
                    apt[j + 1] = temp;
                }
            }
        }

        int totalPerson = 0;
        int sumPerson = 0;
        int resultIndex = 0;

        // 총 주민 수 계산
        for (int i = 0; i < n; i++) {
            totalPerson += apt[i][1];
        }

        // 중간값 조건을 만족하는 아파트 단지 찾기
        for (int i = 0; i < n; i++) {
            sumPerson += apt[i][1];
            if (sumPerson >= (totalPerson + 1) / 2) { // 중간값은 정렬된 데이터에서 "전체 값의 절반 이상을 포함하는 첫 번째 위치"입니다.
                result = apt[i][2]; // 원래 입력 순서의 번호 저장
                break;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
