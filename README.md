# 좌표계산기

## 선 길이

### 기능 요구사항

- 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
- 좌표 정보는 괄표"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
- X, Y좌표 모두 최대 24까지만 입력할 수 있다.
- 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다.
  좌표값과 좌표값 사이는 '-' 문자로 구분한다.
- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

### 실행 결과

```
좌표를 입력하세요.
(10,10)-(14,15)

24|
...
14|             .
  |
12|
  |
10|      .
 2|
  |
  +ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 0  2 ... 10 ... 15 ... 24

두 점 사이 거리는 6.403124
```

### 힌트

- 두 점 사이의 거리 `제곱근((A.x - B.x)^2 + (A.y)-(B.y)^2)`
- 제곱근 구하는 함수 Math.sqrt() 활용
- 테스트 코드의 경우 double 일 때 근사치를 테스트

- 테스트 코드 힌트
    - junit의 `assertEquals(1.413, line.length(), 0.001);`
      과 같이 세번째 인자에 정밀도를 지정할 수 있다.
    - assertj는 `asserThat(line.length()).isEqualTo(1.414, offset(0.00099));`
      과 같이 offset메소드로 정밀도를 지정할 수 있다.

### 설계 개요

- View 요구사항
    - 사용자의 입력에 따라 서비스가 달라지도록 구성
    - 좌표 정보는 괄호`( and )` 로 둘러 쌓여 있으며
    - 쉼표 ` , `로 x값과 y값을 구분
    - 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력
    - 좌표값과 좌표값 사이는 ` - ` 로 구분
- 도메인 요구사항 (선 길이)
    - 두 점 사이 거리를 계산

0. 입력에 따라 서비스(로직)이 달라지는 시스템이다.
1. 입력을 판단하고 그에 따라 요청을 결정하는 역할 (Knowing,Doing)
    - 입력한 판단이 어떤 판단인지에 대한 상태
    - 요청에 따른 응답을 외부(View)에 제공
2. 요청(메시지)에 따라 로직 수행하고 결과값을 반환하는 역할 (Doing)