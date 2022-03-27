package DTO;

public class AccountType 
{
	//attributes
	private int TypeId;
	private String Type;
	
	//get
	public int get_TypeId()
	{
		return this.TypeId;
	}
	public String get_Type()
	{
		return this.Type;
	}
	
	//constructors
	public AccountType()
	{
		
	}
	public AccountType(int typeid, String type)
	{
		this.TypeId = typeid;
		this.Type = type;
	}
	public AccountType(AccountType accountType)
	{
		this.TypeId = accountType.TypeId;
		this.Type = accountType.Type;
	}
}
