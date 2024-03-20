# ToDo : 요구사항 분석

- Row 사다리 방향을 표시하는 1과 -1 하드코딩된 것을 상수로 표현
  - Direction Enum 클래스 
- primitive type들을 찾아서 Wrapper 클래스로 포장
  - Ladder 생성자 -> 자연수 NaturalNumber 클래스
  - Position 나타내는 변수 -> Position Wrapper 클래스
  - Row 상태값 int -> Node Wrapper 클래스
- Ladder 클래스 분리
  - LadderRunner
  - LadderCreator
  - LadderGame