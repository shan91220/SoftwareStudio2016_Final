import javax.swing.JFrame;

public class JxlReadExcel {
	private final static int windowWidth = 600, windowHeight = 600;
	public JxlReadExcel() {
		
		JxlReadExcelApplet xl = new JxlReadExcelApplet();
		xl.init();
		xl.start();
		xl.setFocusable(true);
		
		JFrame window = new JFrame("Create your excel file.");
		window.setContentPane(xl);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
	}

}
