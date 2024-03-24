import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class keyboardlistener extends KeyAdapter {
    public void keyPressd(KeyEvent e){
        switch(e.getKeyCode()){
            case 39:	// -> Right 
                        //if it's not the opposite direction
                        if(ThreadsController.direction!=2) 
                            ThreadsController.direction=1;
                          break;
            case 38:	// -> Top
                        if(ThreadsController.direction!=4) 
                            ThreadsController.direction=3;
                        break;
                        
            case 37: 	// -> Left 
                        if(ThreadsController.direction!=1)
                            ThreadsController.direction=2;
                        break;
                        
            case 40:	// -> Bottom
                        if(ThreadsController.direction!=3)
                            ThreadsController.direction=4;
                        break;
            
            default: 	break;
         }
    }
    
}
