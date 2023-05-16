public class Wrapper {
    private int number;
    private int width;
    private int height;
   // private int x;
   // private int y;
    private boolean hasBeenCompared;
    public Wrapper(int number, int width, int height){// int x, int y){
        this.width = width;
        this.height = height;
        this.number = number;
        //this.x = x;
        //this.y = y;
        hasBeenCompared = false;
    }
    public void draw(int x, int y){
        if(!hasBeenCompared) {
            Main.app.fill(215,0,64);
            Main.app.rect(x, y+100, width, height);
            //Main.app.ellipse(x, height/2, width, width);
        }
        else{
            Main.app.fill(139, 0, 0);
            Main.app.rect(x, y+100, width, height);
            //Main.app.ellipse(x, height/2, width, width);
        }

       // Main.app.text(number, x, y);
        Main.app.fill(255,255,255);
        Main.app.text(number , (width/2) +x, (height/2)+y+100);

    }
    public String toString(){
        return "" + number;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int x){
        number = x;
    }
    public int compareTo(Wrapper w){
        if(this.number<w.number){
            return -1;
        }
        else if(this.number == w.number){
            return 0;
        }
        return -1;
    }
    public boolean hasBeenSearched(){
        hasBeenCompared = true;
        return hasBeenCompared;
    }
}
