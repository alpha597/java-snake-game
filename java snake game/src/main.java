import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {

		//Creating the window with all its awesome snaky features
		window f1= new window();
		
		//Setting up the window settings
		f1.setTitle("Snake");
		f1.setSize(300,300);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

	}
}
