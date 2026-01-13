package impl;

import java.util.HashMap;
import java.util.Map;

/// ## HashMap 을 사용한 구간 내 과일 종류 추적
/// ### 장점
/// - 과일 종류 개수 확인이 간단 ({@code size()})
/// - 과일 종류가 무제한이어도 사용 가능
/// ### 단점
/// - 오버헤드로 인한 메모리 사용
/// - 배열 대비 약간의 성능 오버헤드
/// ### 시간복잡도: O(N)
/// ### 공간복잡도: O(K) (K 는 구간내 최대 과일 종류 수)
public class HashMapCounter {

	/// 최대 2종류의 과일을 포함하는 가장 긴 구간의 길이를 반환
	/// @param fruits 과일 배열
	/// @return 최대 2종류의 과일을 포함하는 가장 긴 구간의 길이
	public static int getMaxLength(int[] fruits) {
		Map<Integer, Integer> fruitsCount = new HashMap<>();
		int left = 0;
		int maxLength = 0;

		for (int right = 0; right < fruits.length; right++) {
			// right 확장: 과일 추가
			fruitsCount.put(fruits[right], fruitsCount.getOrDefault(fruits[right], 0) + 1);

			// 조건 위반 시 left 축소
			while (fruitsCount.size() > 2) {
				int count = fruitsCount.get(fruits[left]) - 1;
				if (count == 0) {
					fruitsCount.remove(fruits[left]); // 개수가 0이면 제거
				} else {
					fruitsCount.put(fruits[left], count);
				}
				left++;
			}

			// 최대 길이 갱신
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
}
