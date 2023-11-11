import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;


public class window extends JFrame {
    private static long serialUid= -123L;
    public static ArrayList<ArrayList<dataOfSquare>> grid ;
    public static int height =20;
    public static int width =20;

    public window(){
        grid = new ArrayList<>();
        ArrayList<dataOfSquare> data;
        // add all the threads
        for(int a=0 ;a<width;a++){
            data = new ArrayList<dataOfSquare>();
            for(int b=0;b< width;b++){
                dataOfSquare d = new dataOfSquare(2);
                data.add(d);
            }
            grid.add(data);
        }
            
    
    //setting layout
    getContentPane().setLayout(new GridLayout(20,20,0,0));

              for(int i=0;i< width;i++){
			    for(int j=0;j<height;j++){
				        getContentPane().add(grid.get(i).get(j).square);
			}
		}
        //initial position snake
        tupple position = new tupple(10,10);
        ThreadsController c = new ThreadsController(position);
        c.start();
        //links the window to the keyboardlistener
        this.addKeyListener((KeyListener) new keyboardlistener());



    }
    
}
