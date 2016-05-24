public class LeftRoom
{
	private int hammer, hammerX, hammerY;							// 0->not visible, 1->visible
	private int pusheenBack, pusheenBackX, pusheenBackY;
	private int pusheenFront, pusheenFrontX, pusheenFrontY;
	private int pusheenLeft, pusheenLeftX, pusheenLeftY;
	private int pusheenCut, pusheenCutX, pusheenCutY;
	private int pusheenWithoutHammer, pusheenWithoutHammerX, pusheenWithoutHammerY;
	private int pusheenBeKnif, pusheenBeKnifX, pusheenBeKnifY;
	private int hose, hoseX, hoseY;
	private int securitybox, securityboxX, securityboxY;
	private int normalBottle, normalBottleX, normalBottleY;

	public LeftRoom() 
	{	
		hammer = 0;
		hammerX = 397;
		hammerY = 230;
		pusheenBack = 1;
		pusheenBackX = 350;
		pusheenBackY = 250;
		pusheenFront = 1;
		pusheenFrontX = 350;
		pusheenFrontY = 250;
		pusheenLeft = 1;
		pusheenLeftX = 350;
		pusheenLeftY = 250;
		pusheenCut = 0;
		pusheenCutX = 0;
		pusheenCutY = 0;
		pusheenWithoutHammer = 0;
		pusheenWithoutHammerX = 0;
		pusheenWithoutHammerY = 0;
		pusheenBeKnif = 0;
		pusheenBeKnifX = 0;
		pusheenBeKnifY = 0;
		hose = 0;
		hoseX = 0;
		hoseY = 0;
		securitybox = 0;
		securityboxX = 0;
		securityboxY = 0;
		normalBottle = 1;
		normalBottleX = 50;
		normalBottleY = 350;
	}
	
	public int hammer() { return this.hammer; }
	public int pusheenBack() { return this.pusheenBack; }
	public int pusheenFront() { return this.pusheenFront; }
	public int pusheenLeft() { return this.pusheenLeft; }
	public int pusheenCut() { return this.pusheenCut; }
	public int pusheenWithoutHammer() { return this.pusheenWithoutHammer; }
	public int pusheenBeKnif() { return this.pusheenBeKnif; }
	public int hose(){return this.hose; }
	public int securitybox(){return this.securitybox; }
	public int normalBottle(){return this.normalBottle; }
	
	public void hammer_vanish() { this.hammer = 0; }
	public void pusheenBack_vanish() {this.pusheenBack = 0; }
	public void pusheenFront_vanish() { this.pusheenFront = 0; }
	public void pusheenLeft_vanish() { this.pusheenLeft = 0; }
	public void pusheenCut_vanish() { this.pusheenCut = 0; }
	public void pusheenWithoutHammer_vanish() { this.pusheenWithoutHammer = 0; }
	public void pusheenBeKnif_vanish() { this.pusheenBeKnif = 0; }
	public void hose_vanish(){	this.hose = 0;}
	public void securitybox_vanish(){ this.securitybox = 0;}
	public void normalBottle_vanish(){	this.normalBottle = 0;}
	
	public void hammer_appear() { this.hammer = 1; }
	public void pusheenBack_appear() {this.pusheenBack = 1; }
	public void pusheenFront_appear() { this.pusheenFront = 1; }
	public void pusheenLeft_appear() { this.pusheenLeft = 1; }
	public void pusheenCut_appear() { this.pusheenCut = 1; }
	public void pusheenWithoutHammer_appear() { this.pusheenWithoutHammer = 1; }
	public void pusheenBeKnif_appear() { this.pusheenBeKnif = 1; }
	public void hose_appear(){this.hose = 1;}
	public void securitybox_appear(){this.securitybox = 1;}
	public void normalBottle_appear(){this.normalBottle = 1;}
	
	public int getComX(String str)
	{
		if(str == "hammer")
			return this.hammerX;
		else if(str == "pusheenBack")
			return this.pusheenBackX;
		else if(str == "pusheenFront")
			return this.pusheenFrontX;
		else if(str == "pusheenLeft")
			return this.pusheenLeftX;
		else if(str == "pusheenCut")
			return this.pusheenCutX;
		else if(str == "pusheenWithoutHammer")
			return this.pusheenWithoutHammerX;
		else if(str == "pusheenBeKnif")
			return this.pusheenBeKnifX;
		else if(str == "hose")
			return this.hoseX;
		else if(str == "securitybox")
			return this.securityboxX;
		else if(str == "normalBottle")
			return this.normalBottleX;
		else
			return 0;
	}
	
	public int getComY(String str)
	{
		if(str == "hammer")
			return this.hammerY;
		else if(str == "pusheenBack")
			return this.pusheenBackY;
		else if(str == "pusheenFront")
			return this.pusheenFrontY;
		else if(str == "pusheenLeft")
			return this.pusheenLeftY;
		else if(str == "pusheenCut")
			return this.pusheenCutY;
		else if(str == "pusheenWithoutHammer")
			return this.pusheenWithoutHammerY;
		else if(str == "pusheenBeKnif")
			return this.pusheenBeKnifY;
		else if(str == "hose")
			return this.hoseY;
		else if(str == "securitybox")
			return this.securityboxY;
		else if(str == "normalBottle")
			return this.normalBottleY;
		else
			return 0;
	}
	
	public void setPostion(int x, int y, String str)
	{
		
	}
}
