package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InteractDAL extends DatabaseService
{
	/**
	 * trả về id của type đó để gán nó vào solved
	 * @param typecase truyền vào tên của type đó
	 * @return id của type đó
	 */
	public int GetIdOfTypeCase(String typecase)
	{
		//dùng lưu id của type
		int kq = 0;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select CaseId from CaseType where CaseText=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, typecase); //truyền tham số typecase, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = rs.getInt(1); //lấy ra dữ liệu của cột đầu tiên
			}
			else //đọc không được kết quả
			{
				kq = 0; //không có type đó
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
	 * hàm lấy ra id của username
	 * @param username truyền vào username cần lấy id
	 * @return id của username đó
	 */
	public int GetIdOfUsername(String username)
	{
		//dùng lưu id của username
		int kq = 0;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select UserId from Account where UserName=?";
		
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
				kq = rs.getInt(1); //lấy ra dữ liệu của cột đầu tiên
			}
			else //đọc không được kết quả
			{
				kq = 0; //không có type đó
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
	 * hàm lấy ra id của method
	 * @param method truyền vào tên của method
	 * @return id của method đó
	 */
	public int GetIdOfMethod(String method)
	{
		//dùng lưu id của method
		int kq = 0;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select MethodId from Method where MethodName=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setString(1, method); //truyền tham số method, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = rs.getInt(1); //lấy ra dữ liệu của cột đầu tiên
			}
			else //đọc không được kết quả
			{
				kq = 0; //không có type đó
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
	 * hàm lấy ra các bước thực hiện của rubik để nhét vào combobox
	 * @return các trường hợp để lựa rồi thêm vào database cho đúng
	 */
	public List<String> getComboBoxType()
	{
		List<String> str = new ArrayList<String>();
		
		Statement st = null; //statement không truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select CaseText from CaseType";
		
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
				str.add(rs.getString(1)); //lấy ra dữ liệu của cột đầu tiên rồi truyền vào list str
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
		
		return str;
	}
	
	/**
	 * hàm lấy ra các method để truyền vào combobox
	 * @return các method có thể lựa chọn
	 */
	public List<String> getComboBoxMethod()
	{
		List<String> str = new ArrayList<String>();
		
		Statement st = null; //statement không truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select MethodName from Method";
		
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
				str.add(rs.getString(1)); //lấy ra dữ liệu của cột đầu tiên rồi truyền vào list str
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
		
		return str;
	}
	
	/**
	 * hàm lấy ra path của hình trong các case
	 * @param caseNameinTable truyền vào tên của case đó
	 * @return tên case nào thì lấy được path hình đó
	 */
	public String GetImgPathFromCaseName(String caseNameinTable)
	{
		//dùng để lưu path
		String kq = "";
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select PicCover from Solved where CaseName=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setNString(1, caseNameinTable); //truyền tham số caseNameinTable, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = rs.getString("PicCover"); //lấy ra dữ liệu của cột 'PicCover'
			}
			else //đọc không được kết quả
			{
				kq = ""; //để rỗng
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
	 * hàm lấy ra path của hình trong scramble
	 * @param scrambleId truyền vào id của cái scramble đó
	 * @return id nào thì lấy đc hình của scramble đó
	 */
	public String GetImgPathFromScrambleId(int scrambleId)
	{
		//dùng để lưu path
		String kq = "";
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select ScrambleImage from Scramble where ScrambleId=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setInt(1, scrambleId); //truyền tham số scrambleId, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = rs.getString("ScrambleImage"); //lấy ra dữ liệu của cột 'ScrambleImage'
			}
			else //đọc không được kết quả
			{
				kq = ""; //để rỗng
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
	 * hàm lấy ra id của casename
	 * @param caseNameinTable truyền vào case name
	 * @return id của case name đó
	 */
	public int GetIdFromCasename(String caseNameinTable)
	{
		//dùng lấy id
		int kq = 0;
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select PicId from Solved where CaseName=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setNString(1, caseNameinTable); //truyền tham số caseNameinTable, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = rs.getInt("PicId"); //lấy ra dữ liệu của cột 'PicId'
			}
			else //đọc không được kết quả
			{
				kq = 0; //để rỗng
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
	 * hàm lấy ra 1 chuỗi scrambles trong database
	 * @param randomInt truyền vào 1 số nguyên để random ra 1 scramble tương ứng
	 * @return chuỗi scramble
	 */
	public String GetScramblesFromRandomNumber(int randomInt)
	{
		//dùng lấy ra chuỗi scrambles
		String kq = "";
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select ScrambleText from Scramble where ScrambleId=?";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setInt(1, randomInt); //truyền tham số randomInt, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = rs.getString("ScrambleText"); //lấy ra dữ liệu của cột 'ScrambleText'
			}
			else //đọc không được kết quả
			{
				kq = ""; //để rỗng
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
	 * hàm lấy ra số lượng min max của scrambles 
	 * @return vị trí [0] là MIN, [1] là MAX 
	 */
	public int[] GetMinMaxOfScrambles()
	{
		//dùng lấy min, max
		int[] kq = new int[2];
		Statement st = null; //statement không truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select MIN(ScrambleId), MAX(ScrambleId) from Scramble";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//tạo 1 máy đọc
			st = connection.createStatement();
			//truyền câu lệnh vào và đọc
			rs = st.executeQuery(sql); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq[0] = rs.getInt(1); //lấy ra dữ liệu của cột 1
				kq[1] = rs.getInt(2); //lấy ra dữ liệu của cột 2
			}
			else //đọc không được kết quả
			{
				kq = null; //để rỗng
			}
			
			st.close();
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
	 * hàm lấy ra kỷ lục của user đó
	 * @param userid truyền vào id của user đó
	 * @return kỷ lục chơi của user đó
	 */
	public String GetBestRecord(int userid)
	{
		//dùng lấy ra kỷ lục của user
		String kq = "";
		PreparedStatement ps = null; //statement có truyền tham số, dùng để thực thi sql
		ResultSet rs = null; //dùng để đọc kết quả từ việc thực thì sql
		
		String sql = "Select TOP 1 RecordTime from Records where UserId=? order by RecordTime ASC";
		
		try 
		{
			//kết nối tới database
			Connection connection = DriverManager.getConnection(db_connection, db_username, db_password);
			//truyền sql vào máy thực thi
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userid); //truyền tham số userid, dựa theo số thứ tự của dấu '?' ở trên sql
			rs = ps.executeQuery(); //thực thi sql
			
			if (rs.next()) //đọc được kết quả
			{
				kq = rs.getString("RecordTime"); //lấy ra dữ liệu của cột 'RecordTime'
			}
			else //đọc không được kết quả
			{
				kq = ""; //để rỗng
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
}
