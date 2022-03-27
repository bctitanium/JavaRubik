package DTO;

public class Scramble 
{
	//attributes
	private int ScrambleId;
	private String ScrambleText;
	private String ScrambleImage;
	
	//get
	public int get_ScrambleId()
	{
		return this.ScrambleId;
	}
	public String get_ScrambleText()
	{
		return this.ScrambleText;
	}
	public String get_ScrambleImage()
	{
		return this.ScrambleImage;
	}
	
	//constructors
	public Scramble()
	{
		
	}
	public Scramble(int scrambleid, String scrambletext, String scrambleimage)
	{
		this.ScrambleId = scrambleid;
		this.ScrambleText = scrambletext;
		this.ScrambleImage = scrambleimage;
	}
	public Scramble(Scramble scramble)
	{
		this.ScrambleId = scramble.ScrambleId;
		this.ScrambleText = scramble.ScrambleText;
		this.ScrambleImage = scramble.ScrambleImage;
	}
}
