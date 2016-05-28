import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.image.ImagingOpException;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextField;
import controlP5.ControlP5;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

@SuppressWarnings("serial")
public class MainApplet extends PApplet
{
	private final static int width = 1000, height = 540;
	private HashMap<String, PImage> images = new HashMap<String, PImage>();
	private int curRoom;
	private ControlP5 cp5;
	private int catMove = 0, backbutton = 0, startmenu = 1;
	private int questionButton = 0;
	private int inputQuestion = 0;
	private int pusheenNum = 0;
	private int beknifnum = 0, becutnum = 0;
	private AudioClip cat;
	private LeftRoom leftRoom = new LeftRoom();
	private RightRoom rightRoom = new RightRoom();
	private MiddleRoom middleRoom = new MiddleRoom();
	private Itemtable itemtable = new Itemtable();
	private Question q = new Question(this);
	private String password = "520053";
	private int mouseState;
	private int rightroomState;
	
	private String[] file = {
		"background/middle.png",
		"background/right.png",
		"background/right2.png",
		"background/right3.png",
		"background/right4.png",
		"background/carpet lifted.png",
		"background/left.png",
		"background/start.jpg",
		"background/start2.jpg",
		"background/password.png",
		"background/setquestion.png",
		"background/questionInput.png",
		"background/middle+candle.png",
		"background/light.png",
		"background/middle+lamp.png",
		"background/middle+lamp+candle.png",
		"component/beknif_pusheen.png",
		"component/hammer.png",
		"component/hose.png",
		"component/knif.png",
		"component/normal_bottle.png",
		"component/normal_bottle_full.png",
		"component/pusheen_bottle.png",
		"component/pusheen_bottle_full.png",
		"component/pusheen_cut.png",
		"component/pusheen_hammer.png",
		"component/pusheenBack.png",
		"component/pusheenLeft.png",
		"component/pusheenRight.png",
		"component/securitybox.png",
		"component/tape.png",
		"component/pusheenFront.png",
		"component/lighter.png",
		"component/lighterfire.png",
		"component/pusheen.png",
		"component/itemtable.png",
		"component/normalBottle+hose.png",
		"component/fillingbottle.png",
		"component/fillingbottle2.png",
		"component/fillingbottle3.png",
		"component/fillingbottle4.png",
		"component/fillingbottle5.png",
		"component/fillingbottle6.png",
		"component/normal_bottle_rotate35.png",
		"component/normal_bottle_rotate75.png",
		"component/normal_bottle_rotate120.png",
		"component/pusheen_bottle2.png",
		"component/pusheen_bottle3.png",
		"component/pusheen_bottle4.png",
		"component/pusheen_bottle5.png",
		
	};
	
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		mouseState = 0;
		rightroomState = 1;
		String []temp = new String[10];
		String input = new String("12345678");   //for WriteExcel
		
		for(int i=0;i<file.length;i++)
		{
			PImage image = loadImage(this.file[i]);
			temp = this.file[i].split("/");
			images.put(temp[1], image);
		}
		
		cat = getAudioClip(getCodeBase(), "sound/cat.mp3");
		curRoom = 2;
		cp5 = new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("voice").setLabel("Voice On").setPosition(60, 450).setSize(200, 50);
		cp5.addButton("startbutton").setLabel("Start").setPosition(380, 450).setSize(200, 50);
		cp5.addButton("questionnaire").setLabel("questionnaire").setPosition(700, 450).setSize(200,50);
		
		cat.play();
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void draw()				// override the processing that paint the main components
	{
		background(0);
		
		if(this.curRoom == 0 || this.curRoom == 1 || this.curRoom == -1){
			image(images.get("itemtable.png"), 840, 0, 160, 400);
			
			
			if(mouseState==0) cursor(ARROW);
			else if(mouseState == 1) cursor(images.get("knif.png"),16,16);
			else if(mouseState == 2) cursor(images.get("normal_bottle.png"),16,16);
			else if(mouseState == 3) cursor(images.get("pusheen_bottle.png"),16,16);
			else if(mouseState == 4) cursor(images.get("hammer.png"),16,16);
			else if(mouseState == 5) cursor(images.get("lighter.png"),16,16);
			else if(mouseState == 6) cursor(images.get("tape.png"),16,16);
			else if(mouseState == 7) cursor(images.get("hose.png"),16,16);
			else if(mouseState == 8) cursor(images.get("normal_bottle_full.png"),16,16);
			else if(mouseState == 9) cursor(images.get("normalBottle+hose.png"),16,16);
			else if(mouseState == 10) cursor(images.get("pusheen_bottle_full.png"),16,16);
			else if(mouseState == 11) cursor(images.get("lighterfire.png"),16,16);
			else cursor(ARROW);
			
			if(itemtable.hammer()==1){
				image(images.get("hammer.png"), 845, 5, 60, 60);
			}
			if(itemtable.pusheenBottle()==1){
				image(images.get("pusheen_bottle.png"),845 , 70, 60, 60);
			}
			if(itemtable.hose()==1){
				image(images.get("hose.png"), 925, 65, 60, 60);
			}
			if(itemtable.knif()==1){
				image(images.get("knif.png"), 845, 200, 65, 65);
			}
			if(itemtable.normalBottle()==1){
				image(images.get("normal_bottle.png"), 845, 140, 60, 60);
			}
			if(itemtable.tape()==1){
				image(images.get("tape.png"), 930, 5, 60, 60);
			}
			if(itemtable.lighter()==1){
				image(images.get("lighter.png"),845, 270, 60, 60);
			}
			if(itemtable.normalBottleFull()==1){
				image(images.get("normal_bottle_full.png"), 925, 140, 60, 60);
			}
			if(itemtable.normalBottleWithHose()==1){
				image(images.get("normalBottle+hose.png"), 925, 200, 60,60);
			}
			if(itemtable.pusheenBottleFull()==1){
				image(images.get("pusheen_bottle_full.png"), 925, 270, 60, 60);
			}
		}
		else {
			cursor(ARROW);
		}
		
		if(this.curRoom == 0) //middle room
		{
			if(middleRoom.middlebackground==0){
				image(images.get("middle.png"), 0, 0, 840, 540);
			}else if(middleRoom.middlebackground==1){
				image(images.get("middle+lamp.png"), 0, 0, 840, 540);
			}else if(middleRoom.middlebackground==2){
				image(images.get("middle+candle.png"), 0, 0, 840, 540);
			}else if(middleRoom.middlebackground==3){
				image(images.get("middle+lamp+candle.png"), 0, 0, 840, 540);
			}
			if(middleRoom.lightleft()==1){
				image(images.get("light.png"), 253, 182, 60, 60);
			}
			if(middleRoom.lightright()==1){
				image(images.get("light.png"), 478, 182, 60, 60);
			}
			
			if(middleRoom.pusheenBottle() == 1){
				image(images.get("pusheen_bottle.png"), middleRoom.getComX("pusheenBottle"), middleRoom.getComY("pusheenBottle"), 80, 60);
			}
			if(middleRoom.securitybox() == 1){
				image(images.get("securitybox.png"), middleRoom.getComX("securitybox"), middleRoom.getComY("securitybox"), 100, 100);
			}
			if(middleRoom.knif() == 1){
				image(images.get("knif.png"), middleRoom.getComX("knif"), middleRoom.getComY("knif"), 40, 60);
			}
			if(middleRoom.lighter() == 1){
				image(images.get("lighter.png"), middleRoom.getComX("lighter"), middleRoom.getComY("lighter"), 120, 100);
				
			}
			if(this.startmenu == 1)
			{
				cp5.remove("voice");
				cp5.remove("startbutton");
				cp5.remove("questionnaire");
				this.startmenu = 0;
			}
		}
		else if(this.curRoom == 1) //right room
		{
			if(rightroomState==1) image(images.get("right.png"), 0, 0, 840, 540);
			else if(rightroomState == 2) image(images.get("right2.png"), 0, 0, 840, 540);
			else if(rightroomState == 3) image(images.get("right3.png"), 0, 0, 840, 540);
			else if(rightroomState == 4) image(images.get("right4.png"), 0, 0, 840, 540);
			
			if(rightRoom.animate==1){
				rightRoom.animateNum++;
				if(rightRoom.animateNum<=30){
					image(images.get("fillingbottle.png"), 540, 360, 200, 200);
				}else if(rightRoom.animateNum<=30*2){
					image(images.get("fillingbottle2.png"), 540, 360, 200, 200);
				}else if(rightRoom.animateNum<=30*3){
					image(images.get("fillingbottle3.png"), 540, 360, 200, 200);
				}else if(rightRoom.animateNum<=30*4){
					image(images.get("fillingbottle4.png"), 540, 360, 200, 200);
				}else if(rightRoom.animateNum<=30*5){
					image(images.get("fillingbottle5.png"), 540, 360, 200, 200);
				}else if(rightRoom.animateNum<=30*6){
					image(images.get("fillingbottle6.png"), 540, 360, 200, 200);
				}else{
					itemtable.normalBottleFull_appear();
					rightRoom.animate = 0;
				}
				
			}
			
			if(rightRoom.tape() == 1){
				image(images.get("tape.png"), rightRoom.getComX("tape"), rightRoom.getComY("tape"), 30, 20);
			}
		}
		else if(this.curRoom == -1) //left room
		{
			image(images.get("left.png"),0,0,840,540);
			if(leftRoom.pusheenFront()==1)
			{
				if(pusheenNum%120 < 30){
					image(images.get("pusheenFront.png"), leftRoom.getComX("pusheenFront"), leftRoom.getComY("pusheenFront"), 150, 150);		// warning overflow
				}
				else if(pusheenNum%120 < 60){
					image(images.get("pusheenLeft.png"), leftRoom.getComX("pusheenLeft"), leftRoom.getComY("pusheenLeft"), 150, 150);
				}
				else if(pusheenNum%120 < 90){
					image(images.get("pusheenBack.png"), leftRoom.getComX("pusheenBack"), leftRoom.getComY("pusheenBack"), 150, 150);
				}
				else {
					image(images.get("pusheenRight.png"), leftRoom.getComX("pusheenRight"), leftRoom.getComY("pusheenRight"), 150, 150);
				}
				pusheenNum++;
				if(pusheenNum==120) pusheenNum=0;
			}
			if(leftRoom.normalBottle()==1){
				image(images.get("normal_bottle.png"), leftRoom.getComX("normalBottle"), leftRoom.getComY("normalBottle"),75,75);
			}
			if(leftRoom.hose()==1){
				image(images.get("hose.png"), 0,0);
			}
			if(leftRoom.securitybox()==1){
				image(images.get("securitybox.png"), leftRoom.getComX("securitybox"), leftRoom.getComY("securitybox"),840,540);
			}
			if(leftRoom.pusheenBottle()==1){
				image(images.get("pusheen_bottle.png"), leftRoom.getComX("pusheenBottle"), leftRoom.getComY("pusheenBottle"),60,60);
			}
			
			
			if(leftRoom.bottleAnimate==1){
				leftRoom.bottleAnimateNum++;
				
				if(leftRoom.bottleAnimateNum<30){
					image(images.get("normal_bottle_rotate35.png"), 630, 70,60,60);
					image(images.get("pusheen_bottle2.png"), leftRoom.getComX("pusheenBottle"), leftRoom.getComY("pusheenBottle"),60,60);
				}else if(leftRoom.bottleAnimateNum<60){
					image(images.get("normal_bottle_rotate75.png"), 625, 60,60,60);
					image(images.get("pusheen_bottle3.png"), leftRoom.getComX("pusheenBottle"), leftRoom.getComY("pusheenBottle"),60,60);
				}else if(leftRoom.bottleAnimateNum<90){
					image(images.get("normal_bottle_rotate120.png"), 620, 50,60,60);
					image(images.get("pusheen_bottle5.png"), leftRoom.getComX("pusheenBottle"), leftRoom.getComY("pusheenBottle"),60,60);
				}else {
					leftRoom.bottleAnimate = 0;
					itemtable.pusheenBottleFull_appear();
				}
			}
			
			
			if(leftRoom.pusheenCut()==1){
				
				image(images.get("pusheen_cut.png"), leftRoom.getComX("pusheenCut"), leftRoom.getComY("pusheenCut"), 840, 540);
				becutnum++;
				if(becutnum==30){
					leftRoom.pusheenCut_vanish();
					leftRoom.pusheenWithoutHammer_appear();
					leftRoom.hammer_appear();
				}
			}
			if(leftRoom.pusheenWithoutHammer()==1){
				image(images.get("pusheen_hammer.png"), leftRoom.getComX("pusheenWithoutHammer"), leftRoom.getComY("pusheenWithoutHammer"), 840, 540);
			}
			if(leftRoom.hammer()==1){
				image(images.get("hammer.png"), leftRoom.getComX("hammer"), leftRoom.getComY("hammer"), 90, 90);
			}
			if(leftRoom.pusheenBeKnif()==1){
				image(images.get("beknif_pusheen.png"), leftRoom.getComX("pusheenBeKnif"), leftRoom.getComY("pusheenBeKnif"), 840, 540);
				beknifnum++;
				if(beknifnum==30){
					leftRoom.pusheenBeKnif_vanish();
					leftRoom.pusheenCut_appear();
				}
			}
		}
		else if(this.curRoom == 2) //start room
		{
			if(this.startmenu == 0)
			{
				cp5.addButton("voice").setLabel("Voice On").setPosition(60, 450).setSize(200, 50);
				cp5.addButton("startbutton").setLabel("Start").setPosition(380, 450).setSize(200, 50);
				cp5.addButton("questionnaire").setLabel("questionnaire").setPosition(700, 450).setSize(200,50);
				this.startmenu = 1;
			}
			if(this.catMove < 10 )
				image(images.get("start.jpg"), 0, 0, 1000, 540);
			else
				image(images.get("start2.jpg"), 0, 0, 1000, 540);
		}
		else if(this.curRoom == 3) //question room
		{	
			if(q.getQuestionSet() == false){
				image(images.get("password.png"), 0, 0, 1000, 540);
			}
			
			if(q.getQuestionSet()== true ){
				image(images.get("setquestion.png"), 0, 0, 1000, 540);
				
				if(questionButton == 0){
					 q.removeText();	
					 cp5.addButton("questionOne").setLabel("Question 1").setPosition(70, 100).setSize(200, 70);
					 cp5.addButton("questionTwo").setLabel("Question 2").setPosition(680, 100).setSize(200, 70);
					 cp5.addButton("questionThree").setLabel("Question 3").setPosition(70, 200).setSize(200, 70);
					 cp5.addButton("questionFour").setLabel("Question 4").setPosition(680, 200).setSize(200, 70);
					 cp5.addButton("questionFive").setLabel("Question 5").setPosition(70, 300).setSize(200, 70);
					 cp5.addButton("questionSix").setLabel("Question 6").setPosition(680, 300).setSize(200, 70);
					 questionButton = 1;
				}
			}
			
			if(inputQuestion == 1)
			{	 	
				 cp5.remove("questionOne");
				 cp5.remove("questionTwo");
				 cp5.remove("questionThree");
				 cp5.remove("questionFour");
				 cp5.remove("questionFive");
				 cp5.remove("questionSix");    
				 image(images.get("questionInput.png"), 0, 0, 1000, 540);
			}
			
			if(this.startmenu == 1)
			{
				cp5.remove("voice");
				cp5.remove("startbutton");
				cp5.remove("questionnaire");
				this.startmenu = 0;
			}
		}
		
		if(this.catMove < 19)
			this.catMove ++;
		else
			this.catMove = 0;
		
		if( (this.curRoom == 0 || this.curRoom == 1 || this.curRoom == -1 || this.curRoom == 3) && backbutton == 0)     // waiting for modifying
		{
			cp5.addButton("buttonBack").setLabel("Back").setPosition(890, 450).setSize(50,50);
			this.backbutton = 1;
		}
		else if(this.curRoom == 2 && backbutton == 1)
		{
			cp5.remove("buttonBack");
			this.backbutton = 0;
		}
		
		//for object drag but it can only drag lighter now	
		
		q.display();
	}
	
	public void keyPressed(KeyEvent arg0)
	{
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && curRoom < 1)
		{
			this.curRoom += 1;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_LEFT && curRoom > -1 && curRoom != 2)
		{
			this.curRoom -= 1;
		}
	}
	
	public void voice()
	{
		
	}
	
	public void startbutton()
	{
		this.curRoom = 0;
	}
	
	public void questionnaire()
	{
		this.curRoom = 3;
	}
	
	public void buttonBack()
	{
		if(this.curRoom == 3 && this.inputQuestion == 1)
		{
			this.curRoom = 3;
			this.inputQuestion = 0;	
			this.questionButton = 0;
			//qs.removeText();
		}
		else
		{
			cp5.remove("questionOne");
			cp5.remove("questionTwo");
			cp5.remove("questionThree");
			cp5.remove("questionFour");
			cp5.remove("questionFive");
			cp5.remove("questionSix");
			questionButton = 0;
			q.setQuestionSet(false);
			this.curRoom = 2;
		}
	}
	
	public int getCurRoom()
	{
		return this.curRoom;
	}
	
	//Question Set Button
	 public void questionOne(){
		 JxlWriteExcel createExcel = new JxlWriteExcel();
		inputQuestion = 1;
	 }
	 public void questionTwo(){
		 JxlWriteExcel createExcel = new JxlWriteExcel();
	 	inputQuestion = 1;
	 }
	 public void questionThree(){
		 JxlWriteExcel createExcel = new JxlWriteExcel();
	 	inputQuestion = 1;
	 }
	 public void questionFour(){
		 JxlWriteExcel createExcel = new JxlWriteExcel();
	 	inputQuestion = 1;
	 }
	 public void questionFive(){
		 JxlWriteExcel createExcel = new JxlWriteExcel();
	 	inputQuestion = 1;
	 }
	 public void questionSix(){
		 JxlWriteExcel createExcel = new JxlWriteExcel();
	 	inputQuestion = 1;
	 }
	public String questionPassword()
	{
		return this.password;
	}
	
	public float getMouseX()
	{
		return mouseX;
	}
	
	public float getMouseY()
	{
		return mouseY;
	}
	
	public void mouseReleased(){
		if(mouseState==11 && (this.curRoom==0 || this.curRoom==1 || this.curRoom==-1)){
			mouseState = 5;
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public void mousePressed()
	{
		/////// item panel
		if((this.curRoom == 0 || this.curRoom==1 || this.curRoom==-1) && mouseX>=840 ){
			if(mouseX>840 && mouseX<920 && mouseY<265 && mouseY>200) {
				if(itemtable.knif()==1){
					putItemBack();
					mouseState=1;
					itemtable.knif_vanish();
				}else if(mouseState==1 && itemtable.knif()==0){
					mouseState=0;
					itemtable.knif_appear();
				}
			}
			else if(mouseX>840 && mouseX<920 && mouseY<198 && mouseY>140) {
				if(itemtable.normalBottle()==1){
					if(mouseState == 1) itemtable.knif_appear();
					else if(mouseState==2) itemtable.normalBottle_appear();
					else if(mouseState==3) itemtable.pusheenBottle_appear();
					else if(mouseState==4) itemtable.hammer_appear();
					else if(mouseState==5) itemtable.lighter_appear();
					else if(mouseState==6) itemtable.tape_appear();
					else if(mouseState==7) itemtable.normalBottleFullWithHose_appear();
					else if(mouseState==8) itemtable.normalBottleFull_appear();
					else if(mouseState==9) itemtable.normalBottleFullWithHose_appear();
					else if(mouseState==10) itemtable.pusheenBottleFull_appear();
					
					if(mouseState==7) mouseState = 0;
					else mouseState=2;
					
					itemtable.normalBottle_vanish();;
				}else if(mouseState==2 && itemtable.normalBottle()==0){
					mouseState=0;
					itemtable.normalBottle_appear();
				}
			}
			else if(mouseX>840 && mouseX<920 && mouseY<135 && mouseY>65) {
				if(itemtable.pusheenBottle()==1){
					putItemBack();
					mouseState=3;
					itemtable.pusheenBottle_vanish();
				}else if(mouseState==3 && itemtable.pusheenBottle()==0){
					mouseState=0;
					itemtable.pusheenBottle_appear();
				}
			}
			else if(mouseX>840 && mouseX<920 && mouseY<63 && mouseY>2) {
				if(itemtable.hammer()==1){
					putItemBack();
					mouseState=4;
					itemtable.hammer_vanish();
				}else if(mouseState==4 && itemtable.hammer()==0){
					mouseState=0;
					itemtable.hammer_appear();
				}
			}
			else if(mouseX>840 && mouseX<920 && mouseY<330 && mouseY>265) {
				if(itemtable.lighter()==1){
					putItemBack();
					mouseState=5;
					itemtable.lighter_vanish();;
				}else if(mouseState==5 && itemtable.lighter()==0){
					mouseState=0;
					itemtable.lighter_appear();
				}
			}
			else if(mouseX>920 && mouseX<1000 && mouseY<63 && mouseY>2) {
				if(itemtable.tape()==1){
					putItemBack();
					mouseState=6;
					itemtable.tape_vanish();
				}else if(mouseState==6 && itemtable.tape()==0){
					mouseState=0;
					itemtable.tape_appear();
				}
			}
			else if(mouseX>920 && mouseX<1000 && mouseY<135 && mouseY>65) {
				if(itemtable.hose()==1){
					if(mouseState == 1) itemtable.knif_appear();
					else if(mouseState==2) itemtable.normalBottleFullWithHose_appear();
					else if(mouseState==3) itemtable.pusheenBottle_appear();
					else if(mouseState==4) itemtable.hammer_appear();
					else if(mouseState==5) itemtable.lighter_appear();
					else if(mouseState==6) itemtable.tape_appear();
					else if(mouseState==7) itemtable.hose_appear();
					else if(mouseState==8) itemtable.normalBottleFull_appear();
					else if(mouseState==9) itemtable.normalBottleFullWithHose_appear();
					else if(mouseState==10) itemtable.pusheenBottleFull_appear();
					
					if(mouseState==2) mouseState = 0;
					else mouseState=7;
					itemtable.hose_vanish();
				}else if(mouseState==7 && itemtable.hose()==0){
					mouseState=0;
					itemtable.hose_appear();
				}
			}
			else if(mouseX>920 && mouseX<1000 && mouseY<195 && mouseY>135) {
				if(itemtable.normalBottleFull()==1){
					putItemBack();
					mouseState=8;
					itemtable.normalBottleFull_vanish();
				}else if(mouseState==8 && itemtable.normalBottleFull()==0){
					mouseState=0;
					itemtable.normalBottleFull_appear();
				}
			}
			else if(mouseX>920 && mouseX<1000 && mouseY<265 && mouseY>200) {
				if(itemtable.normalBottleWithHose()==1){
					putItemBack();
					mouseState=9;
					itemtable.normalBottleFullWithHose_vanish();
				}else if(mouseState==9 && itemtable.normalBottleWithHose()==0){
					mouseState=0;
					itemtable.normalBottleFullWithHose_appear();
				}
			}
			else if(mouseX>920 && mouseX<1000 && mouseY<330 && mouseY>265) {
				if(itemtable.pusheenBottleFull()==1){
					putItemBack();
					mouseState=10;
					itemtable.pusheenBottleFull_vanish();
				}else if(mouseState==10 && itemtable.pusheenBottleFull()==0){
					mouseState=0;
					itemtable.pusheenBottleFull_appear();
				}
			}
			
		}
		
		if(mouseState==5 && (this.curRoom==0 || this.curRoom==1 || this.curRoom==-1)){
			mouseState = 11;
		}
		//////////// middle room
		if(this.curRoom == 0)			
		{
			System.out.println(mouseX+" "+mouseY);
			if(mouseX >= middleRoom.getComX("pusheenBottle")+25 && mouseX <= middleRoom.getComX("pusheenBottle")+58 && mouseY >= middleRoom.getComY("pusheenBottle")+5 && mouseY <= middleRoom.getComY("pusheenBottle")+60 ){
				middleRoom.pusheenBottle_vanish();
				itemtable.pusheenBottle_appear();
			}
			else if(mouseX >= 328 && mouseX <= 462 && mouseY >= 147 && mouseY <= 269 && mouseState == 0)
			{
				MovePusheen pusheen = new MovePusheen();
			}
			else if(mouseX >= 585 && mouseX <= 650 && mouseY >= 215 && mouseY <= 250 && mouseState == 11){
				if(middleRoom.middlebackground==0){
					middleRoom.middlebackground = 1;//mid+lamp
				}else if(middleRoom.middlebackground==2){
					middleRoom.middlebackground = 3;//mid+lamp+candle
				}
			}
			else if(mouseX >= 585 && mouseX <= 650 && mouseY >= 215 && mouseY <= 250 && mouseState == 11){
				if(middleRoom.middlebackground==0){
					middleRoom.middlebackground = 1;//mid+lamp
				}else if(middleRoom.middlebackground==2){
					middleRoom.middlebackground = 3;//mid+lamp+candle
				}
			}else if(mouseState==11  && mouseX >= 255 && mouseX <= 280 && mouseY >= 180 && mouseY <= 230){
				middleRoom.lightleft_appear();
			}else if(mouseState==11  && mouseX >= 485 && mouseX <= 520 && mouseY >= 180 && mouseY <= 230){
				middleRoom.lightright_appear();
			}
		}
		
		////////////// right room
		else if(this.curRoom == 1)		
		{
			System.out.println(mouseX+" "+mouseY);
			
			if(mouseState==10 && mouseX >500 && mouseX <550 && mouseY>480 && mouseY <520 ){
				rightroomState = 2;
				itemtable.pusheenBottleFull_vanish();
				rightRoom.tape_appear();
				mouseState = 0;
			}else if(rightRoom.tape()==1 && mouseX >500 && mouseX <530 && mouseY>480 && mouseY <520){
				rightRoom.tape_vanish();
				itemtable.tape_appear();
			}else if(mouseState==6 && mouseX >425 && mouseX <505 && mouseY>200 && mouseY <300){
				rightroomState = 3;
				itemtable.tape_vanish();
				mouseState = 0;
			}else if(rightroomState == 3 && mouseState == 4 && mouseX >425 && mouseX <505 && mouseY>200 && mouseY <300){
				rightroomState = 4;
				itemtable.hammer_vanish();
				mouseState = 0;
			}else if(mouseState==9 && mouseX >650 && mouseX <750 && mouseY>430 && mouseY <470){
				mouseState=0;
				rightRoom.animate = 1;
			}
		}
		else if(this.curRoom == -1)		// left room
		{
			System.out.println(mouseX+" "+mouseY);
			if(leftRoom.isanimate==0 && leftRoom.normalBottle()==1 && mouseX >= leftRoom.getComX("normalBottle")+23 && mouseX <= leftRoom.getComX("normalBottle")+53 && mouseY >= leftRoom.getComY("normalBottle") && mouseY <= leftRoom.getComY("normalBottle")+73 ){
				leftRoom.normalBottle_vanish();
				itemtable.normalBottle_appear();
			}
			if(mouseState==1 && leftRoom.isanimate==0 && leftRoom.pusheenFront()==1 && mouseX >= leftRoom.getComX("pusheenBack")+30 && mouseX <= leftRoom.getComX("pusheenBack")+125 && mouseY >= leftRoom.getComY("pusheenBack")+35 && mouseY <= leftRoom.getComY("pusheenBack")+120 ){
				leftRoom.pusheenFront_vanish();
				leftRoom.pusheenBeKnif_appear();
				leftRoom.isanimate = 1;
				mouseState = 0;
			}
			if(leftRoom.isanimate==1 && leftRoom.hammer()==1 && mouseX >= leftRoom.getComX("hammer")+20 && mouseX <= leftRoom.getComX("hammer")+80 && mouseY >= leftRoom.getComY("hammer")+0 && mouseY <= leftRoom.getComY("hammer")+90 ){
				leftRoom.hammer_vanish();
				leftRoom.pusheenWithoutHammer_vanish();
				itemtable.hammer_appear();
				leftRoom.isanimate = 0;
			}
			if(leftRoom.isanimate==0 && mouseState==3 && mouseX >740 && mouseX <770 && mouseY>320 && mouseY <350){
				mouseState= 0;
				leftRoom.pusheenBottle_appear();
			}
			if(leftRoom.isanimate==0 && leftRoom.pusheenBottle()==1 && mouseState==8 && mouseX >650 && mouseX <690 && mouseY>75 && mouseY <95){
				mouseState = 0;
				leftRoom.bottleAnimate = 1;
				leftRoom.pusheenBottle_vanish();
				
			}
			if(mouseX >= 225 && mouseX <= 370 && mouseY >= 310 && mouseY <= 370 && mouseState == 0){
				GameColorTrapMain colorTrap = new GameColorTrapMain();
				
			}
			if(mouseX >= 0)  //  567,491    642,462    789,478    722,521   (681,485)
			{
				if( ( ((mouseX-681.f)*(mouseX-681.f))/10000.f+((mouseY-485.f)*(mouseY-485.f))/900.f) <= 1.f )
				{
					RapidSorting sort = new RapidSorting();
				}
			}
		}
	}
	
	private void putItemBack(){
		if(mouseState == 1) itemtable.knif_appear();
		else if(mouseState==2) itemtable.normalBottle_appear();
		else if(mouseState==3) itemtable.pusheenBottle_appear();
		else if(mouseState==4) itemtable.hammer_appear();
		else if(mouseState==5) itemtable.lighter_appear();
		else if(mouseState==6) itemtable.tape_appear();
		else if(mouseState==7) itemtable.hose_appear();
		else if(mouseState==8) itemtable.normalBottleFull_appear();
		else if(mouseState==9) itemtable.normalBottleFullWithHose_appear();
		else if(mouseState==10) itemtable.pusheenBottleFull_appear();
	}
	
}