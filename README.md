# JDBC

- 데이터 베이스를 변경해야할때 추상화를 통해 쉽게 변경하기
- 자바 소스 코드와 DB작업에 필요한 공통 부분을 추상화하여 표준으로 만든다.
- 각 DB 회사들이 이 표준에 따라 구현해 놓는다.

- 데이터베이스 회사에서 구현한 코드 로딩

```java
public class DriverManager {
    public static Connection getConnection() throws SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql:주소:포트/DB명", "username", "password");
    }
}
```

- 데이터베이스 연결 인터페이스 (Connection)

```java
public interface Connection {
    PreparedStatement prepareStatement(String sql)
            throws SQLException;
}
```

- SQL 쿼리에 인자 전달 및 쿼리 실행

```java
public interface PreparedStatement extends Statement {
    void setInt(int parameterIndex, int x) throws SQLException; // int 값 전달

    void setString(int parameterIndex, String x) throws SQLException; // String 값 전달

    […] // 자바의 기본 데이터베이스 모두 지원

    ResultSet executeQuery() throws SQLException; // select 쿼리

    int executeUpdate() throws SQLException; // insert, update, delete 쿼리
}
```

- select 쿼리를 실행한 결과를 자바 데이터로 변환
```java
public interface ResultSet {
    int getInt(int columnIndex) throws SQLException;

    String getString(String columnLabel) throws SQLException;

    [...] // 자바가 지원하는 데이터 타입에 대한 메소드 존재함.

    boolean isFirst() throws SQLException;

    boolean isLast() throws SQLException;
}
```

- 인터페이스
  - 자바에서 한 단계 더 높은 추상화를 위해 사용
  - 구현 로직은 존재하지 않으며, 입력과 출력만 정의
  - 인터페이스를 이용하여 추상화하는 이유는 소프트웨어의 변경에 유연하게 반응하기 위함
  - 미래의 변화에 빠르게 대응이 가능하지만, 추상화에 따른 개발 비용 발생