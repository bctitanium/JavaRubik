package DTO;

public class CaseType 
{
	//attributes
	private int CaseId;
	private String CaseText;
	
	//get
	public int get_CaseId()
	{
		return this.CaseId;
	}
	public String get_CaseText()
	{
		return this.CaseText;
	}
	
	//constructors
	public CaseType()
	{
		
	}
	public CaseType(int caseid, String casetext)
	{
		this.CaseId = caseid;
		this.CaseText = casetext;
	}
	public CaseType(CaseType caseType)
	{
		this.CaseId = caseType.CaseId;
		this.CaseText = caseType.CaseText;
	}
}
