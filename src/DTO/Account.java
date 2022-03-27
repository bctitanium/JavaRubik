package DTO;

public class Account 
{
	//attributes
	private int UserId; //identity
	private String UserName;
	private String PassWord;
	private int TypeId;
	
	//get
	public int get_UserId()
	{
		return this.UserId;
	}
	public String get_UserName()
	{
		return this.UserName;
	}
	public String get_PassWord()
	{
		return this.PassWord;
	}
	public int get_TypeId()
	{
		return this.TypeId;
	}
	
	//set
	public void set_UserId(int userid)
	{
		this.UserId = userid;
	}
	public void set_UserName(String username)
	{
		this.UserName = username;
	}
	
	//constructors
	public Account()
	{
		
	}
	public Account(String username, String password, int typeid)
	{
		this.UserName = username;
		this.PassWord = password;
		this.TypeId = typeid;
	}
	public Account(Account account)
	{
		this.UserName = account.UserName;
		this.PassWord = account.PassWord;
		this.TypeId = account.TypeId;
	}
}
