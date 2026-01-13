package impl;

/// ## 배열을 사용한 구간 내 과일 종류 추적
/// ### 장점
/// - 메모리 효율적 (고정 10칸)
/// - 배열 접근이 HashMap 보다 빠름
/// ### 단점
/// - 과일 종류 개수를 직접 카운트해야 함 ({@code typeCount} 관리)
/// - 과일 종류가 무제한이면 사용 불가
/// ### 시간복잡도: O(N)
/// ### 공간복잡도: O(1) (과일 종류가 제한적)
public class ArrayCounter {

	/// 최대 2종류의 과일을 포함하는 가장 긴 구간의 길이를 반환
	/// @param fruits 과일 배열
	/// @return 최대 2종류의 과일을 포함하는 가장 긴 구간의 길이
	public static int getMaxLength(int[] fruits) {
		int[] fruitCount = new int[10]; // 과일 종류 1~9
		int typeCount = 0; // 종류 개수 직접 카운트
		int left = 0;
		int maxLength = 0;

		for (int right = 0; right < fruits.length; right++) {
			// right 확장: 과일 추가
			if (fruitCount[fruits[right]] == 0)
				typeCount++;
			fruitCount[fruits[right]]++;

			// 조건 위반 시 left 축소
			while (typeCount > 2) {
				fruitCount[fruits[left]]--;
				if (fruitCount[fruits[left]] == 0)
					typeCount--;
				left++;
			}

			// 최대 길이 갱신
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
}
