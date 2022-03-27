package BLL;

import DAL.AccountDAL;

public class AccountBLL 
{
	AccountDAL accDAL = new AccountDAL();
	
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
		
		if (accDAL.CheckAccount(username, password)) //tài khoản có tồn tại
		{
			kq = true; //có tồn tại
		}
		else //tài khoản không tồn tại
		{
			kq = false; //không tồn tại
		}
		
		return kq; //trả về kết quả của kq
	}
	
	/**
	 * hàm kiểm tra sự tồn tại của username, dùng để kiểm tra trước khi tạo account
	 * @param username truyền vào username
	 * @return kết quả kiểm tra là có tồn tại hoặc không
	 */
	public boolean CheckUsername(String username)
	{
		//dùng để xác nhận kết quả của hàm, true thì tồn tại acc, false thì không tồn tại acc, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		
		if (accDAL.CheckUsername(username)) //tài khoản có tồn tại
		{
			kq = true; //có tồn tại
		}
		else //tài khoản không tồn tại
		{
			kq = false; //không tồn tại
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
		
		if (accDAL.isAdmin(username)) //tài khoản có tồn tại
		{
			kq = true; //là admin
		}
		else //tài khoản không tồn tại
		{
			kq = false; //là user
		}
		
		return kq;
	}
	
	/**
	 * tạo acc mới
	 * @param username tên username
	 * @param password password
	 * @return 1 acc mới
	 */
	public boolean CreateAccount(String username, String password)
	{
		//true thì tạo acc thành công, false thì ngược lại, mặc định là false vì nếu có sự cố nhập liệu thì vẫn trả về false cho an toàn
		boolean kq = false;
		
		if (accDAL.CreateAccount(username, password))
		{
			kq = true; //tạo được
		}
		else
		{
			kq = false; //không tạo được
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
		
		if (accDAL.ChangePassword(userid, new_password))
		{
			kq = true; //đổi được
		}
		else
		{
			kq = false; //không đổi được
		}
		
		return kq;
	}
}
