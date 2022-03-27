package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyDAL extends DatabaseService
{
	/**
	 * thêm vào table case 1 công thức
	 * @param casename tên loại trường hợp
	 * @param piccover đường dẫn hình
	 * @param algorithm công thức
	 * @param mota mô tả
	 * @param type loại
	 * @return thêm 1 case vào bảng
	 */
	public boolean AddCase(String casename, String piccover, String algorithm, String mota, int type)
	{
		//true thì thêm thành công, false thì ngược lại, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		//ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Insert into Solved(CaseName, PicCover, Algorithm, MoTa, CaseId) values(?, ?, ?, ?, ?)";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, casename); //truyền tham số casename, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(2, piccover); //truyền tham số piccover, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(3, algorithm); //truyền tham số algorithm, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(4, mota); //truyền tham số mota, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setInt(5, type); //truyền tham số type, dựa theo số thứ tự của dấu '?' ở trên sql
						
			if (ps.executeUpdate() != 0) //ghi được kết quả
			{
				kq = true; //thì thêm thành công
			}
			else //ghi không được kết quả
			{
				kq = false; //thì thêm không thành công
			}
			
			ps.close();
			//rs.close();
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
	 * hàm sửa case
	 * @param Id id của case đó
	 * @param casename tên case đó
	 * @param piccover link file case đó
	 * @param algorithm công thức case đó
	 * @param mota mô tả case đó
	 * @return sửa được hay không thì tùy
	 */
	public boolean UpdateCase(int Id, String casename, String piccover, String algorithm, String mota)
	{
		//true thì sửa case thành công, false thì ngược lại, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		//ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Update Solved set CaseName=?, PicCover=?, Algorithm=?, MoTa=? where PicId=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, casename); //truyền tham số casename, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(2, piccover); //truyền tham số piccover, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(3, algorithm); //truyền tham số algorithm, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setString(4, mota); //truyền tham số mota, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setInt(5, Id); //truyền tham số Id, dựa theo số thứ tự của dấu '?' ở trên sql
			
			if (ps.executeUpdate() != 0) //ghi được kết quả
			{
				kq = true; //thì sửa case thành công
			}
			else //ghi không được kết quả
			{
				kq = false; //thì sửa case không thành công
			}
			
			ps.close();
			//rs.close();
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
	 * hàm xóa case
	 * @param casename tên case
	 * @return xóa được thì true, ngược lại
	 */
	public boolean DeleteCase(String casename)
	{
		//true thì xóa case thành công, false thì ngược lại, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		//ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Delete from Solved where CaseName=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, casename); //truyền tham số casename, dựa theo số thứ tự của dấu '?' ở trên sql
						
			if (ps.executeUpdate() != 0) //ghi được kết quả
			{
				kq = true; //thì xóa case thành công
			}
			else //ghi không được kết quả
			{
				kq = false; //thì xóa case không thành công
			}
			
			ps.close();
			//rs.close();
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
	 * thêm kỷ lục của người chơi
	 * @param recordtime thời gian hoàn thành
	 * @param scrambleid id của scramble
	 * @param userid id của user
	 * @param methodid id của method sử dụng
	 * @return true thì thêm thành công, ngược lại
	 */
	public boolean AddRecords(String recordtime, int scrambleid, int userid, int methodid)
	{
		//true thì thêm thành công, false thì ngược lại, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
				
		String sql = "Insert into Records(RecordTime, ScrambleId, UserId, MethodId) values(?, ?, ?, ?)";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, recordtime); //truyền tham số recordtime, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setInt(2, scrambleid); //truyền tham số scrambleid, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setInt(3, userid); //truyền tham số userid, dựa theo số thứ tự của dấu '?' ở trên sql
			ps.setInt(4, methodid); //truyền tham số methodid, dựa theo số thứ tự của dấu '?' ở trên sql
						
			if (ps.executeUpdate() != 0) //ghi được kết quả
			{
				kq = true; //thì thêm thành công
			}
			else //ghi không được kết quả
			{
				kq = false; //thì thêm không thành công
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
