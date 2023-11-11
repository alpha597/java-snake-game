public class tupple {
    public int x;
    public int y;
    public int xf;
    public int yf;
    public tupple(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void changedata(int x,int y){
        this.x = x;
        this.y = y;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getFx(){
        return xf;
    }
    public int getFy(){
        return yf;
    }
}
