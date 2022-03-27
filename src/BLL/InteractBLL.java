package BLL;

import java.util.List;
import DAL.InteractDAL;

public class InteractBLL 
{
	InteractDAL inteDAL = new InteractDAL();
	
	/**
	 * trả về id của type đó để gán nó vào bảng solved
	 * @param typecase truyền vào tên của type đó
	 * @return id của type đó
	 */
	public int GetIdOfTypeCase(String typecase)
	{
		return inteDAL.GetIdOfTypeCase(typecase);
	}
	
	/**
	 * hàm lấy ra id của username
	 * @param username truyền vào username cần lấy id
	 * @return id của username đó
	 */
	public int GetIdOfUsername(String username)
	{
		return inteDAL.GetIdOfUsername(username);
	}
	
	/**
	 * hàm lấy ra id của method
	 * @param method truyền vào tên của method
	 * @return id của method đó
	 */
	public int GetIdOfMethod(String method)
	{
		return inteDAL.GetIdOfMethod(method);
	}

	/**
	 * hàm lấy ra các bước thực hiện của rubik để nhét vào combobox
	 * @return các trường hợp để lựa rồi thêm vào database cho đúng
	 */
	public List<String> getComboBoxType()
	{
		return inteDAL.getComboBoxType();
	}
	
	/**
	 * hàm lấy ra các method để truyền vào combobox
	 * @return các method có thể lựa chọn
	 */
	public List<String> getComboBoxMethod()
	{
		return inteDAL.getComboBoxMethod();
	}
	
	/**
	 * hàm lấy ra path của hình trong các case
	 * @param caseNameinTable truyền vào tên của case đó
	 * @return tên case nào thì lấy được path hình đó
	 */
	public String GetImgPathFromCaseName(String caseNameinTable)
	{
		return inteDAL.GetImgPathFromCaseName(caseNameinTable);
	}
	
	/**
	 * hàm lấy ra path của hình trong scramble
	 * @param scrambleId truyền vào id của cái scramble đó
	 * @return id nào thì lấy đc hình của scramble đó
	 */
	public String GetImgPathFromScrambleId(int scrambleId)
	{
		return inteDAL.GetImgPathFromScrambleId(scrambleId);
	}
	
	/**
	 * hàm lấy ra id của casename
	 * @param caseNameinTable truyền vào case name
	 * @return id của case name đó
	 */
	public int GetIdFromCasename(String caseNameinTable)
	{
		return inteDAL.GetIdFromCasename(caseNameinTable);
	}
	
	/**
	 * hàm lấy ra 1 chuỗi scrambles trong database
	 * @param randomInt truyền vào 1 số nguyên để random ra 1 scramble tương ứng
	 * @return chuỗi scramble
	 */
	public String GetScramblesFromRandomNumber(int randomInt)
	{
		return inteDAL.GetScramblesFromRandomNumber(randomInt);
	}
	
	/**
	 * hàm lấy ra số lượng min max của scrambles 
	 * @return vị trí [0] là MIN, [1] là MAX 
	 */
	public int[] GetMinMaxOfScrambles()
	{
		return inteDAL.GetMinMaxOfScrambles();
	}
	
	/**
	 * hàm lấy ra kỷ lục của user đó
	 * @param userid truyền vào id của user đó
	 * @return kỷ lục chơi của user đó
	 */
	public String GetBestRecord(int userid)
	{
		return inteDAL.GetBestRecord(userid);
	}
}
