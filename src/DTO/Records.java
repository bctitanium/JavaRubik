package DTO;

public class Records 
{
	//attributes
	private int RecordId; //identity
	private String RecordTime;
	private int ScrambleId;
	private int UserId;
	private int MethodId;
	
	//get
	public int get_RecordId()
	{
		return this.RecordId;
	}
	public String get_RecordTime()
	{
		return this.RecordTime;
	}
	public int get_ScrambleId()
	{
		return this.ScrambleId;
	}
	public int get_UserId()
	{
		return this.UserId;
	}
	public int get_MethodId()
	{
		return this.MethodId;
	}
	
	//set
	public void set_RecordTime(String recordtime)
	{
		this.RecordTime = recordtime;
	}
	
	//constructors
	public Records()
	{
		
	}
	public Records(String recordtime, int scrambleid)
	{
		this.RecordTime = recordtime;
		this.ScrambleId = scrambleid;
	}
	public Records(Records records)
	{
		this.RecordTime = records.RecordTime;
		this.ScrambleId = records.ScrambleId;
	}
}
