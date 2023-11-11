import java.util.ArrayList;

public class ThreadsController extends Thread{
   ArrayList<ArrayList<dataOfSquare>> Squares = new ArrayList<>();
   tupple headsnakepos ;
   int snakesize =5;
   public static int direction;
   int speed =50;

   ArrayList<tupple> pos = new ArrayList<>();
   tupple foodpos;
   // constructor
   ThreadsController( tupple positiondepart){
          Squares = window.grid;
          headsnakepos = new tupple(positiondepart.x, positiondepart.y);
          direction =1;
          //pointer
          tupple headpos = new tupple(headsnakepos.getX(),headsnakepos.getY());
          pos.add(headpos);
          foodpos = new tupple(window.height-1, window.width-1);
          spawnfood(foodpos);

   }
    public void run() {
      while(true){
         moveInterne(direction);
         checkCollision();
         moveExterne();
         deleteTail();
         pauser();
      }
   }
   // delay for each move
    private void pauser(){
      try {
           sleep(speed);
      } catch (InterruptedException e) {
           e.printStackTrace();
      }
   }
   private void checkCollision() {
      tupple posCritique = pos.get(pos.size()-1);
      for(int i = 0;i<=pos.size()-2;i++){
         boolean biteItself = posCritique.getX()==pos.get(i).getX() && posCritique.getY()==pos.get(i).getY();
         if(biteItself){
           stopTheGame();
         }
      }
      
      boolean eatingFood = posCritique.getX()==foodpos.y && posCritique.getY()==foodpos.x;
      if(eatingFood){
         System.out.println("Yummy!");
         snakesize = snakesize +1;
            foodpos= getValAleaNotInSnake();

         spawnFood(foodpos);	
      }
   }
    //stops the game
   private void stopTheGame(){
      System.out.println("COLISION! \n");
      while(true){
         pauser();
      }
   }
   private void spawnFood(tupple foodPositionIn){
      Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightmeup(1);
         }
        /*returns position not occupied by snake */
         private tupple getValAleaNotInSnake(){
            tupple p ;
            int ranX= 0 + (int)(Math.random()*19); 
            int ranY= 0 + (int)(Math.random()*19); 
            p=new tupple(ranX,ranY);
            for(int i = 0;i<=pos.size()-1;i++){
               if(p.getY()==pos.get(i).getX() && p.getX()==pos.get(i).getY()){
                  ranX= 0 + (int)(Math.random()*19); 
                  ranY= 0 + (int)(Math.random()*19); 
                  p=new tupple(ranX,ranY);
                  i=0;
               }
            }
            return p;
         }
         /*move the position os snake 1: left ,2: right,  3: top ,4 :bottom ,5 :0 */

         private void moveInterne(int dir){
		 switch(dir){
		 	case 4:
				 headsnakepos.changedata(headsnakepos.x,(headsnakepos.y+1)%20);
				 pos.add(new tupple(headsnakepos.x,headsnakepos.y));
		 		break;
		 	case 3:
		 		if(headsnakepos.y-1<0){
		 			 headsnakepos.changedata(headsnakepos.x,19);
		 		 }
		 		else{
				 headsnakepos.changedata(headsnakepos.x,Math.abs(headsnakepos.y-1)%20);
		 		}
				 pos.add(new tupple(headsnakepos.x,headsnakepos.y));
		 		break;
		 	case 2:
		 		 if(headsnakepos.x-1<0){
		 			 headsnakepos.changedata(19,headsnakepos.y);
		 		 }
		 		 else{
		 			 headsnakepos.changedata(Math.abs(headsnakepos.x-1)%20,headsnakepos.y);
		 		 } 
		 		pos.add(new tupple(headsnakepos.x,headsnakepos.y));

		 		break;
		 	case 1:
				 headsnakepos.changedata(Math.abs(headsnakepos.x+1)%20,headsnakepos.y);
				 pos.add(new tupple(headsnakepos.x,headsnakepos.y));
		 		 break;
		 }
	 }
	 
	 //Refresh the squares that needs to be 
	 private void moveExterne(){
		 for(tupple t : pos){
			 int y = t.getX();
			 int x = t.getY();
			 Squares.get(x).get(y).lightmeup(0);
			 
		 }
	 }
    // refreshes the tail of the snake
    private void deleteTail(){
      int cmpt = snakesize;
      for(int i = pos.size()-1;i>=0;i--){
         if(cmpt==0){
            tupple t = pos.get(i);
            Squares.get(t.y).get(t.x).lightmeup(2);
         }
         else{
            cmpt--;
         }
      }
      cmpt = snakesize;
      for(int i = pos.size()-1;i>=0;i--){
         if(cmpt==0){
            pos.remove(i);
         }
         else{
            cmpt--;
         }
      }
   }

         
   

   
}