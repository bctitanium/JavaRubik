package BLL;

import DAL.ModifyDAL;

public class ModifyBLL 
{
	ModifyDAL mDAL = new ModifyDAL();
	
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
		return mDAL.AddCase(casename, piccover, algorithm, mota, type);
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
		
		if (mDAL.UpdateCase(Id, casename, piccover, algorithm, mota))
		{
			kq = true; //thì sửa case thành công
		}
		else
		{
			kq = false; //thì sửa case không thành công
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
		
		if (mDAL.DeleteCase(casename)) 
		{
			kq = true; //thì xóa case thành công
		}
		else //ghi không được kết quả
		{
			kq = false; //thì xóa case không thành công
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
		
		if (mDAL.AddRecords(recordtime, scrambleid, userid, methodid)) 
		{
			kq = true; //thì thêm thành công
		}
		else //ghi không được kết quả
		{
			kq = false; //thì thêm không thành công
		}
		
		return kq;
	}
}
