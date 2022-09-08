package project0901;

import java.sql.SQLException;

public class DbStart {

	public static void main(String[] args) {
		DatabaseOn dbon = new DatabaseOn();
		dbon.DatabaseOn_start();
		
		try {
			while(dbon.rs.next()) {
				// 학번 컬럼에 있는 데이터를 가져옴
				System.out.print(dbon.rs.getInt(1) + " ");
				System.out.print(dbon.rs.getString(2) + " ");
				System.out.print(dbon.rs.getDate("birthday") + " ");
				System.out.println(dbon.rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (dbon.rs != null) try {
				dbon.rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	}

}
