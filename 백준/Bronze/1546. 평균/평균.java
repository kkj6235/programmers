import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        // Collections를 사용하여 합계와 최대값 계산
        int sum = s.stream().mapToInt(Integer::intValue).sum();
        int max = Collections.max(s);

        // 결과 출력 (소수점 포함)
        System.out.println((sum/(n * (double) max)) * 100);
    }
}