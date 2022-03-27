package BLL;

import javax.swing.table.DefaultTableModel;
import DAL.LdtDAL;

public class LdtBLL 
{
	LdtDAL ldt = new LdtDAL();
	
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDTF2L()
	{
		return ldt.LoadDataTableCaseF2L();
	}
	
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDTOLL()
	{
		return ldt.LoadDataTableCaseOLL();
	}
	
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDTPLL()
	{
		return ldt.LoadDataTableCasePLL();
	}
	
	/**
	 * load vào table từ database
	 * @return table chứa dữ liệu từ database
	 */
	public DefaultTableModel LoadDTCross()
	{
		return ldt.LoadDataTableCaseCross();
	}
}
