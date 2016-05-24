
public class RightRoom {
	private int tape, tapeX, tapeY;		// 0->not visible, 1->visible
	
	public RightRoom() 
	{
		tape = 1;
		tapeX = 400;
		tapeY = 470;
	}

	public int tape() { return this.tape; }
	
	public void tape_vanish() { this.tape = 0; }
	
	public void tape_appear() { this.tape = 1; }
	
	public int getComX(String str)
	{
		if(str == "tape")
			return this.tapeX;
		else 
			return 0;
	}
	
	public int getComY(String str)
	{
		if(str == "tape")
			return this.tapeY;
		else 
			return 0;
	}
	
	public void setPostion(int x, int y, String str)
	{
		
	}
}
