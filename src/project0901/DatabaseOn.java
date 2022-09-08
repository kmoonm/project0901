package project0901;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseOn {
	// jdbc 데이터 베이스 드라이버와 url 변수 지정하기
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	// "jdbc:mysql://(도메인명)/(데이터베이스명)?serverTimezone = UTC"
	private String jdbcUrl = "jdbc:mysql://localhost/yangjung?serverTimezone = UTC";		
	// Connection 클래스 변수 설정;
	private Connection conn = null;
	// PreparedStatement는 SQL 문을 미리 만들어 두고 변수를 따로 입력하는 방식
	// 데이터를 입력·수정·삭제하려고 SQL 문을 만들 때는 PreparedStatement를 사용하여 변수와 적절히 조합.
	private PreparedStatement pstmt = null;
	// 결과값 입력(?)
	ResultSet rs = null;
	// sql문 입력, 반환값 만들어 주기
	private String sql = "select * from student";
			
		public String getSql() {
				return sql;
			}
			public void setSql(String sql) {
				this.sql = sql;
			}		
		
		public void DatabaseOn_start() {
			try {
				// JDBC 드라이버 로드
				// 데이터 베이스 접속
				Class.forName(jdbcDriver);
				// Connection 클래스 인스턴스 레퍼런스(객체를 간접적으로 가리키는 변수) 얻기
				// 접속을 위한 아이디 비번 입력
				conn = DriverManager.getConnection(jdbcUrl, "kmoonm", "1234");
				// sql문 실행 시키기 위한 준비 코드
				pstmt = conn.prepareStatement(sql);	
				// SELECT 문을 수행할 때 사용
				rs = pstmt.executeQuery();
				
			} catch(Exception e) {
				System.out.println("연결에 실패하셨습니다.");
			}
	}
}
