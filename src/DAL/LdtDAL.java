package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class LdtDAL extends DatabaseService
{
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDataTableCaseF2L()
	{
		//tạo 1 model bảng có các cột
		DefaultTableModel model = new DefaultTableModel(new String[] {"Case Name", "Algorithm", "MoTa"}, 0);
		
		Object[] obj = new Object[4]; //dùng để truyền data vào table đó
		
		Statement st = null; //statement không truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select a.CaseName, a.Algorithm, a.MoTa from Solved a, CaseType b where b.CaseId = a.CaseId and b.CaseText = 'F2L'";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//tạo 1 máy đọc
			st = connection.createStatement();
			//truyền câu lệnh vào và đọc
			rs = st.executeQuery(sql);
			
			while(rs.next()) //đọc được kết quả
			{
				obj[0] = rs.getNString(1); //lấy dữ liệu từ cột 1 của database
				obj[1] = rs.getNString(2); //lấy dữ liệu từ cột 2 của database
				obj[2] = rs.getNString(3); //lấy dữ liệu từ cột 3 của database
				
			    model.addRow(obj); //truyền vào dòng dữ liệu này vào lại bảng
			}
			
			st.close();
			rs.close();
			connection.close();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return model; //chứa dữ liệu của bảng
	}
	
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDataTableCaseCross()
	{
		//tạo 1 model bảng có các cột
		DefaultTableModel model = new DefaultTableModel(new String[] {"Case Name", "Algorithm", "MoTa"}, 0);
		
		Object[] obj = new Object[4]; //dùng để truyền data vào table đó
		
		Statement st = null; //statement không truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select a.CaseName, a.Algorithm, a.MoTa from Solved a, CaseType b where b.CaseId = a.CaseId and b.CaseText = 'Cross'";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//tạo 1 máy đọc
			st = connection.createStatement();
			//truyền câu lệnh vào và đọc
			rs = st.executeQuery(sql);
			
			while(rs.next()) //đọc được kết quả
			{
				obj[0] = rs.getNString(1); //lấy dữ liệu từ cột 1 của database
				obj[1] = rs.getNString(2); //lấy dữ liệu từ cột 2 của database
				obj[2] = rs.getNString(3); //lấy dữ liệu từ cột 3 của database
				
			    model.addRow(obj); //truyền vào dòng dữ liệu này vào lại bảng
			}
			
			st.close();
			rs.close();
			connection.close();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return model; //chứa dữ liệu của bảng
	}
	
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDataTableCaseOLL()
	{
		//tạo 1 model bảng có các cột
		DefaultTableModel model = new DefaultTableModel(new String[] {"Case Name", "Algorithm", "MoTa"}, 0);
		
		Object[] obj = new Object[4]; //dùng để truyền data vào table đó
		
		Statement st = null; //statement không truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select a.CaseName, a.Algorithm, a.MoTa from Solved a, CaseType b where b.CaseId = a.CaseId and b.CaseText = 'OLL'";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//tạo 1 máy đọc
			st = connection.createStatement();
			//truyền câu lệnh vào và đọc
			rs = st.executeQuery(sql);
			
			while(rs.next()) //đọc được kết quả
			{
				obj[0] = rs.getNString(1); //lấy dữ liệu từ cột 1 của database
				obj[1] = rs.getNString(2); //lấy dữ liệu từ cột 2 của database
				obj[2] = rs.getNString(3); //lấy dữ liệu từ cột 3 của database
				
			    model.addRow(obj); //truyền vào dòng dữ liệu này vào lại bảng
			}
			
			st.close();
			rs.close();
			connection.close();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return model; //chứa dữ liệu của bảng
	}
	
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDataTableCasePLL()
	{
		//tạo 1 model bảng có các cột
		DefaultTableModel model = new DefaultTableModel(new String[] {"Case Name", "Algorithm", "MoTa"}, 0);
		
		Object[] obj = new Object[4]; //dùng để truyền data vào table đó
		
		Statement st = null; //statement không truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select a.CaseName, a.Algorithm, a.MoTa from Solved a, CaseType b where b.CaseId = a.CaseId and b.CaseText = 'PLL'";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//tạo 1 máy đọc
			st = connection.createStatement();
			//truyền câu lệnh vào và đọc
			rs = st.executeQuery(sql);
			
			while(rs.next()) //đọc được kết quả
			{
				obj[0] = rs.getNString(1); //lấy dữ liệu từ cột 1 của database
				obj[1] = rs.getNString(2); //lấy dữ liệu từ cột 2 của database
				obj[2] = rs.getNString(3); //lấy dữ liệu từ cột 3 của database
				
			    model.addRow(obj); //truyền vào dòng dữ liệu này vào lại bảng
			}
			
			st.close();
			rs.close();
			connection.close();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return model; //chứa dữ liệu của bảng
	}
}
