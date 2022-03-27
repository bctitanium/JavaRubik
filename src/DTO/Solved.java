package DTO;

public class Solved 
{
	//attributes
	private int PicId; //identity
	private String CaseName;
	private String PicCover;
	private String Algorithm;
	private String MoTa;
	private int CaseId;
	
	//get
	public int get_PicId()
	{
		return this.PicId;
	}
	public String get_CaseName()
	{
		return this.CaseName;
	}
	public String get_PicCover()
	{
		return this.PicCover;
	}
	public String get_Algorithm()
	{
		return this.Algorithm;
	}
	public String get_MoTa()
	{
		return this.MoTa;
	}
	public int get_CaseId()
	{
		return this.CaseId;
	}
	
	//constructors
	public Solved()
	{
		
	}
	public Solved(String casename, String piccover, String algorithm, String mota, int caseid)
	{
		this.CaseName = casename;
		this.PicCover = piccover;
		this.Algorithm = algorithm;
		this.MoTa = mota;
		this.CaseId = caseid;
	}
	public Solved(Solved solved)
	{
		this.CaseName = solved.CaseName;
		this.PicCover = solved.PicCover;
		this.Algorithm = solved.Algorithm;
		this.MoTa = solved.MoTa;
		this.CaseId = solved.CaseId;
	}
}
