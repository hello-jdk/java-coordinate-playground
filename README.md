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

- 힌트: g