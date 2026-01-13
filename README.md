# 백준 30804 - 과일 탕후루: 그리디의 함정에서 투포인터로

[![문제 링크](https://img.shields.io/badge/Baekjoon-30804-blue)](https://www.acmicpc.net/problem/30804)
[![블로그 포스트](https://img.shields.io/badge/Blog-Read%20Full%20Story-green)](https://b-mokk.tistory.com/87)

## 📊 성능 개선

| 접근법 | 시간복잡도 | 구간 확인 방식 | 결과 |
|--------|-----------|---------------|------|
| 완전탐색 | O(N²) | 모든 구간 확인 | ❌ 비효율적 |
| 그리디 | O(N²) | 매 순간 최선 선택 | ❌ 최적해 보장 안됨 |
| 투포인터 | O(N) | 필요한 구간만 확인 | ✅ 통과 |

**N² 번 연산 → N번 연산으로 최적화**

## 🎯 핵심 개념

- **Two Pointer (투포인터)**
    - 연속된 구간을 효율적으로 탐색
    - 단조성을 활용한 포인터 이동
    - 구간 확장/축소를 통한 최적 구간 탐색

## 📂 코드 구조

### 시행착오 과정
1. **[GreedyApproach.java](src/main/java/attempts/GreedyApproach.java)**
    - 그리디 접근 시도
    - 실패 이유: 매 순간 최선의 선택(종류 수 최소화)이 전체 최적해를 보장하지 않음
    - 문제: 양쪽 끝에서만 제거하므로 중간 최적 구간을 놓침

2. **[TwoPointerApproach.java](src/main/java/attempts/TwoPointerApproach.java)**
    - 투포인터 기본 구현 (attempts 패키지)
    - 그리디와의 비교를 위한 구현

### 구현 비교
3. **[HashMapCounter.java](src/main/java/impl/HashMapCounter.java)**
    - HashMap 기반 투포인터 구현
    - 장점: `size()`로 종류 개수 확인 간단
    - 단점: 메모리 오버헤드

4. **[ArrayCounter.java](src/main/java/impl/ArrayCounter.java)**
    - 배열 기반 투포인터 구현
    - 장점: 메모리 효율적 (고정 10칸)
    - 단점: `typeCount` 직접 관리 필요

### 최종 해결
- **[TwoPointer.java](src/main/java/solution/TwoPointer.java)**
    - HashMap 기반 최종 솔루션
    - 백준 제출용 입출력 처리 포함
    - 포인터 이동 순서: 확장 → 조건 체크 → 축소 → 갱신

## 💡 배운 것들

### 1. 문제 재해석
```
Before: "앞에서 a개, 뒤에서 b개를 빼낸다"
After:  "연속된 부분 배열 [a, N-b-1]을 선택한다"
```

### 2. 단조성의 중요성
```
left 고정, right 증가 → 과일 종류는 증가하거나 유지 (절대 감소 안함)
과일 종류가 3개가 되면 → left를 줄이기 전까지 right를 더 늘려도 의미 없음
→ left와 right 모두 한 방향으로만 이동 가능 → O(N)
```

### 3. 구현 디테일
- **자료구조 선택**: HashMap vs 배열 (과일 종류 제한 여부)
- **포인터 이동 순서**: right 확장 → 조건 체크 → left 축소 → 길이 갱신
- **HashMap 제거 시점**: 개수가 0이 되면 반드시 제거 (size() 정확성)

## 📝 전체 해결 과정

전체 문제 해결 과정은 블로그 포스트에서 확인할 수 있습니다:
👉 **[투 포인터](https://b-mokk.tistory.com/87)**

## 🔗 관련 링크

- [백준 30804번 문제](https://www.acmicpc.net/problem/30804)
- [블로그 포스트](https://b-mokk.tistory.com/87)

---

**Keywords**: `Two Pointer`, `Sliding Window`, `Greedy`, `HashMap`, `Array`, `Time Complexity Optimization`
