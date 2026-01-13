package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TwoPointer {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			int N = Integer.parseInt(br.readLine());
			int[] fruits = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				fruits[i] = Integer.parseInt(st.nextToken());
			}

			int maxLength = getMaxLength(N, fruits);
			bw.write(maxLength + "");
			bw.flush();
		}
	}

	private static int getMaxLength(int N, int[] fruits) {
		Map<Integer, Integer> fruitCount = new HashMap<>();
		int left = 0;
		int maxLength = 0;
		for (int right = 0; right < N; right++) {
			fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

			while (fruitCount.size() > 2) {
				int count = fruitCount.get(fruits[left]) - 1;
				if (count == 0) {
					fruitCount.remove(fruits[left]);
				} else {
					fruitCount.put(fruits[left], count);
				}
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
}
