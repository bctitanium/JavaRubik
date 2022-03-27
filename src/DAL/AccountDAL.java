package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAL extends DatabaseService
{
	/**
	 * hàm dùng để kiểm tra tài khoản đăng nhập
	 * @param username kiểm tra username
	 * @param password kiểm tra password
	 * @return kết quả kiểm tra là có tồn tại hoặc không
	 */
	public boolean CheckAccount(String username, String password)
	{
		//true thì tồn tại acc, false thì không tồn tại acc, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select UserName, PassWord from Account where UserName=? and PassWord=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, username); //truyền tham số username, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(2, password); //truyền tham số password, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = true; //thì tài khoản có tồn tại
			}
			else //đọc không được kết quả
			{
				kq = false; //thì tài khoản không tồn tại
			}
			
			ps.close();
			rs.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq; //trả về kết quả của kq
	}
	
	/**
	 * hàm kiểm tra sự tồn tại của username, dùng để kiểm tra trước khi tạo account
	 * @param username kiểm tra username này
	 * @return kết quả kiểm tra là có tồn tại hoặc không
	 */
	public boolean CheckUsername(String username)
	{
		//true thì tồn tại username, false thì không tồn tại username, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select UserName from Account where UserName=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, username); //truyền tham số username, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = true; //thì tài khoản có tồn tại
			}
			else //đọc không được kết quả
			{
				kq = false; //thì tài khoản không tồn tại
			}
			
			ps.close();
			rs.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq; //trả về kết quả của kq
	}
	
	/**
	 * hàm kiểm tra account vừa đăng nhập có phải là admin hay không
	 * @param username username truyền vào để kiểm tra
	 * @return là admin thì true, ko phải admin là false
	 */
	public boolean isAdmin(String username)
	{
		//true thì là admin, false thì là user, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn, user là ít quyền nhứt
		boolean kq = false;
		
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select TypeId from Account where UserName=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, username); //truyền tham số username, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next() && rs.getInt(1) == 0) //đọc được kết quả
			{
				kq = true; //là admin
			}
			else //đọc không được kết quả
			{
				kq = false; //là user
			}
			
			ps.close();
			rs.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}
	
	/**
	 * tạo account
	 * @param username tên username
	 * @param password password
	 * @return tạo 1 account mới
	 */
	public boolean CreateAccount(String username, String password)
	{
		//true thì tạo acc thành công, false thì ngược lại, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		
		String sql = "Insert into Account(UserName, PassWord, Type) values(?, ?, ?)";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, username); //truyền tham số username, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(2, password); //truyền tham số password, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setInt(3, 1); //truyền tham số 1 là user, dựa theo số thứ tự của dấu '?' ở trên sql
						
			if (ps.executeUpdate() != 0) //ghi được kết quả
			{
				kq = true; //thì tạo acc thành công
			}
			else //ghi không được kết quả
			{
				kq = false; //thì tạo acc không thành công
			}
			
			ps.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq; //trả về kết quả của kq
	}
	
	/**
	 * hàm thay đổi password của 1 username
	 * @param userid id của user đó
	 * @param new_password password mới
	 * @return true thì đổi đc pass, false thì không đổi được
	 */
	public boolean ChangePassword(int userid, String new_password)
	{
		//true thì đổi đc pass, false thì không đổi được, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		
		String sql = "Update Account set PassWord=? where UserId=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, new_password); //truyền tham số new_password, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setInt(2, userid); //truyền tham số userid, dựa theo số thứ tự của dấu '?' ở trên sql
			
			if (ps.executeUpdate() != 0) //ghi được kết quả
			{
				kq = true; //thì đổi pass thành công
			}
			else //ghi không được kết quả
			{
				kq = false; //thì đổi pass không thành công
			}
			
			ps.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq; //trả về kết quả của kq
	}
}
