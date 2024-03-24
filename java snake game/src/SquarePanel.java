import java.awt.Color;
import javax.swing.JPanel;
public class SquarePanel  extends JPanel{
    private static final long serialUid = 1L;

       public SquarePanel(Color c){
        this.setBackground(c);
       }
       public void ChangeColor(Color d){
        this.setBackground(d);
        this.repaint();
       }

}
