package attempts;

import java.util.HashMap;
import java.util.Map;

/// ## 그리디 접근법 시도 (실패한 접근)
/// 양쪽 끝에서 제거하는 그리디 방식으로 문제를 해결하려고 시도한 구현.
/// ### 실패 이유:
/// - 매 순간 최선의 선택(종류 수 최소화)이 전체 최적해를 보장하지 않음
/// - 최대 길이를 구하는 문제이므로, 최소 개수 제거가 아닌 최적 구간 탐색이 필요
/// - 양쪽 끝에서만 제거하므로 중간에 있는 최적 구간을 놓칠 수 있음
/// ### 시간복잡도: O(N²) - 매 단계마다 구간의 종류 수를 계산
public class GreedyApproach {

	/// ### 그리디 방식으로 최대 길이를 계산 (최적해 보장 안됨)
	/// #### 알고리즘 동작:
	/// - 현재 구간의 과일 종류가 2개 이하가 될 때까지 반복
	/// - 앞에서 제거했을 때와 뒤에서 제거했을 때의 종류 수를 비교
	/// - 종류 수가 더 적어지는 쪽을 선택하여 제거
	/// #### 문제점: 종류 수를 최소화하는 것이 최대 길이를 보장하지 않음
	/// @param fruits 과일 배열
	/// @return 계산된 구간의 길이 (최적해가 아닐 수 있음)
	public static int solve(int[] fruits) {
		int left = 0;
		int right = fruits.length - 1;

		while (right - left + 1 > 0 && getTypeCount(fruits, left, right) > 2) {
			// 앞에서 제거했을 때 종류 수
			int frontTypeCount = getTypeCount(fruits, left + 1, right);

			// 뒤에서 제거했을 때 종류 수
			int backTypeCount = getTypeCount(fruits, left, right - 1);

			// 종류가 더 적어지는 쪽 선택
			if (frontTypeCount < backTypeCount) {
				left++;
			} else if (backTypeCount < frontTypeCount) {
				right--;
			} else {
				// 같으면 임의로 앞에서 제거
				left++;
			}
		}

		return right - left + 1;
	}

	/// 주어진 구간 내의 과일 종류 개수를 계산
	/// @param fruits 과일 배열
	/// @param left 구간 시작 인덱스 (포함)
	/// @param right 구간 끝 인덱스 (포함)
	/// @return 구간 내 과일 종류 개수
	private static int getTypeCount(int[] fruits, int left, int right) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = left; i <= right; i++) {
			count.put(fruits[i], count.getOrDefault(fruits[i], 0) + 1);
		}
		return count.size();
	}
}
