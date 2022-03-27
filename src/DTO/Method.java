package DTO;

public class Method 
{
	//attributes
	private int MethodId;
	private String MethodName;
	
	//get
	public int get_MethodId()
	{
		return this.MethodId;
	}
	public String get_MethodName()
	{
		return this.MethodName;
	}
	
	//constructors
	public Method()
	{
		
	}
	public Method(int methodid, String methodname)
	{
		this.MethodId = methodid;
		this.MethodName = methodname;
	}
	public Method(Method method)
	{
		this.MethodId = method.MethodId;
		this.MethodName = method.MethodName;
	}
}
