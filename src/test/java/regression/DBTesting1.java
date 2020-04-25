
package regression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DBTesting1 {
	
	@Test
	public void dBTest() throws SQLException
	{
		String dbName="reyazdb";
		String username="root";
		String password="reyaz123";
		String url="jdbc:mysql://localhost:3306/";
		
		Connection conn=DriverManager.getConnection(url+dbName, username, password);
		
		PreparedStatement psmt=conn.prepareStatement("select * from emp where sal>? and deptno=?");
		
		psmt.setString(1, "2000");
		
		psmt.setString(2, "10");
		
		ResultSet rs=psmt.executeQuery();
		
		while(rs.next())
		{
			
			for(int i=1;i<=8;i++)
			{
				
				System.out.print(rs.getString(i)+"\t");
			}
			
			System.out.println();
		}
		
		
		
		
		
		
		
	}

}
