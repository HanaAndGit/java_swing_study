package java_swing_study.ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class JdbcConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false";
		String user = "user_mysql_study";
		String password =  "rootroot";
		
		//selectDepartment(url, user, password);
		//insertDepartment(url, user, password);
		//updateDepartment(url, user, password);
		
		//delete
		//delete from department where deptno = 7;
		String deleteSql = "delete from department where deptno = ?";
		try(Connection con = DriverManager.getConnection(url, user, password);
			java.sql.PreparedStatement pstmt = con.prepareStatement(deleteSql)){
			pstmt.setInt(1, 6);
			
			int res = pstmt.executeUpdate();
			System.out.println("수정 성공" + res );
			
		} catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			if(e.getErrorCode()==1062) {
				JOptionPane.showMessageDialog(null, "해당 부서번호가 이미 존재함");
			}
			e.printStackTrace();
		}
		selectDepartment(url, user, password);
	}

	private static void updateDepartment(String url, String user, String password) {
		//update
		String updateSql = "update department set deptname=?, floor=? where deptno=?";
		try(Connection con = DriverManager.getConnection(url, user, password);
			java.sql.PreparedStatement psmtmt = con.prepareStatement(updateSql)){
			//? 자리에 1, 2, 3 차례대로
			psmtmt.setString(1, "마케팅");
			psmtmt.setInt(2, 11);
			psmtmt.setInt(3, 5);
			System.out.println(psmtmt);
			
			int res = psmtmt.executeUpdate();
			System.out.println("수정 성공" + res);
			
		}catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망"+e.getErrorCode());
			if(e.getErrorCode()==1062) {
				JOptionPane.showMessageDialog(null, "해당 부서번호가 이미 존재함");
			}
			//e.printStackTrace();
		}
	}

	private static void insertDepartment(String url, String user, String password) {
		//insert
		String insertSql = "insert into department values(?,?,?)";
		try(Connection con = DriverManager.getConnection(url, user, password);
			java.sql.PreparedStatement pstmt = con.prepareStatement(insertSql)){
			pstmt.setInt(1, 7);
			pstmt.setString(2, "총무");
			pstmt.setInt(3, 30);
			
			System.out.println("연결성공" + pstmt);
			int res = pstmt.executeUpdate();
			
			
			System.out.println(res);
			
		} catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망"+e.getErrorCode());
			if(e.getErrorCode()==1062) {
				JOptionPane.showMessageDialog(null, "해당 부서번호가 이미 존재함");
			}
			//e.printStackTrace();
		}
		selectDepartment(url, user, password);
	}

	//select
	private static void selectDepartment(String url, String user, String passwd) {
		String sql = "select deptno, deptname, floor from department";
		try(Connection con = DriverManager.getConnection(url, user, passwd);//DB연결
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){//finally 대신 ()열고 원래 try 안에 있던 코드를 써주면 finally 로 순서거꾸로 종료하지 않아도 자동으로 종료됨
			
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_study?useSSL=false", "user_mysql_study", "rootroot");
			//Connection import -> java.sql에 있는 Connection
			//System.out.println("접속 성공" + con);
			//Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select deptno, deptname, floor from department");
			List<Department> deptList = new ArrayList<>();
			
			while(rs.next()) {//그 다음 값이 있으면 이동
				deptList.add(getDepartment(rs));
				
				//System.out.printf("%d %s %d%n", deptno, deptName, floor);
			}
			for(Department d : deptList) {
				System.out.println(d);
			}
			
			
			
		} /*
			 * catch (ClassNotFoundException e) {
			 * System.err.println("해당 드라이버를 로드할 수 없습니다."); e.printStackTrace(); }
			 */ catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망"+e.getErrorCode());
			//에러 코드 1045 - DB가 없을 경우 (비밀번호 or DB 이름 틀릴 경우)
			
			e.printStackTrace();
		} /*
			 * finally {//종료
			 * 
			 * }
			 */
	}

	private static Department getDepartment(ResultSet rs) throws SQLException {
		int deptno = rs.getInt("deptno");//컬럼명으로 하는 게  좋다
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		return new Department(deptno, deptName, floor);
	}

}
