package project0901;

import java.sql.*;

public class Student {
			
	public static void main(String[] args) {
		// jdbc 데이터 베이스 드라이버와 url 변수 지정하기
			String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		// "jdbc:mysql://(도메인명)/(데이터베이스명)?serverTimezone = UTC"
			String jdbcUrl = "jdbc:mysql://localhost/yangjung?serverTimezone = UTC";		
		// Connection 클래스 변수 설정;
			Connection conn = null;
		// PreparedStatement는 SQL 문을 미리 만들어 두고 변수를 따로 입력하는 방식
		// 데이터를 입력·수정·삭제하려고 SQL 문을 만들 때는 PreparedStatement를 사용하여 변수와 적절히 조합.
			PreparedStatement pstmt = null;
		// 결과값 입력(?)
			ResultSet rs = null;
		// sql문 입력
			String sql = "select * from student";
			
			
			
			
		// 예외 처리
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
			// 반복 조건 걸어주기
			// rs는 윈도우로 치면 (처음, 이전, 다음, 마지막) 이동하는 기준을 잡아준다. ex) rs.next , rs.previous(?) 
			while(rs.next()) {
				// 학번 컬럼에 있는 데이터를 가져옴
				System.out.print(rs.getInt(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getDate("birthday") + " ");
				System.out.println(rs.getString("address"));
			}
			// System.out.println("데이터베이스 연결 성공");
		} catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
	}

}
