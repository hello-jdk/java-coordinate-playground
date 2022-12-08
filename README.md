# 연료 주입

## 기능 요구사항

- 렌터카를 운영하고 있는 회사
- 보유 차량 Sonata 2대, Avante 1대, K5 2대 (총 5대)
- 고객으로 부터 목적지의 대략적인 이동거리를 입력받아 필요한 연료를 주입.

- 연비
    - Sonata: 10km/L
    - Avante: 15km/L
    - K5: 13km/L

## 프로그래밍 요구사항

- 1단계
    - 상속과 추상 메소드 활용
    - 위 요구사항을 if/else 절을 사용하지 않고 구현
    - 만족해야하는 테스트 코드

```java

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void report() throws Exception {
        RentCompany company = RentCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                        "K5 : 20리터" + NEWLINE +
                        "Sonata : 12리터" + NEWLgINE +
                        "Avante : 20리터" + NEWLINE +
                        "K5 : 30리터" + NEWLINE
        );
    }
}

 ```

- 힌트
    1. Coffee, Tea 예제같이 상속을 활용
    2. 공통 기능 구현을 담당할 Car 추상 클래스 추가

```java
public abstract class Car {
    /**
     * 리터당 이동 거리. 즉, 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 여행하려는 거리
     */
    abstract double getTripDistance();

    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
```

- 2단계
    - 인터페이스를 적용해 구현하기

- 추상화 단계
    1. 현실세계의 객체의 인스턴스 들의 공통적인 부분을 추상화
    2. 필요한 부분(핵심적인)만 사용을 위해 가져오기 (행동이 상태를 만든다)

## 1단계 구현

- Car (추상 클래스) (소나타, 아반떼, K5)
    - [x] Sonata
    - [x] Avante
    - [ ] K5
    - 구현
      - getDistancePerLiter()
          - 연비 (정적 모델)
          -  자동차에 대한 연비 반환
      - getTripDistance()
          - 이동거리 (동적 모델)
          -  해당 자동차가 이g동할 거리 반환
      - String getName()
          - 자동차이름 (정적 모델)
          - 해당 자동차 이름 반환
      - getChargeQuantity()
          - 동적 모델 / 정적 모델 = 동적 모델
          - 주입해야할 연료량 반환

- RentCompany
    - create()
        - 팩토리 메서드 패턴을 사용
        - [x] RentCompany 객체(회사)를 생성한다.
          - [x] 회사가 소유하고 있는 자동차들의 상태
    - addCar()
        - [x] 회사에 자동차를 추가(등록)한다.
          - [x] 회사가 소유하고 있는 자동차리스트에 추가
    - generateReport()
        - [x] 회사에 있는 모든 자동차에 대해 이동거리에 따른 필요한 연료를 출력한다.
          - [x] 각 자동차의 리포트를 합친다