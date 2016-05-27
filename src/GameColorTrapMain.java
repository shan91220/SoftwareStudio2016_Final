import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameColorTrapMain extends JFrame {
	
	private final static int windowWidth = 520, windowHeight = 645;
	
	public static void main(String [] args)
	{
		GameColorTrap colorTrap = new GameColorTrap();
		colorTrap.init();
		colorTrap.start();
		colorTrap.setFocusable(true);
		
		JFrame window = new JFrame("Color Trap");
		window.setContentPane(colorTrap);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
		
	}

}