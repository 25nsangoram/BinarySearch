import processing.core.PApplet;
import java.util.ArrayList;
public class Main extends PApplet {
    //private int [] bArray = {2,5,25,100};
    private ArrayList<Wrapper> things;
    private int low;
    private int high;
    private int mid;
    private int target;
    private int size;
    public static Main app;
    private String userInput;
    private int status;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public Main() {//Main's constructor
        super();
        app = this;
    }

    public void settings() {
        size(600, 600);

    }

    public void setup() {
        things = new ArrayList<Wrapper>();
        size = 10;
        int l = 0;
        int rand = (int) (Math.random() * 10);
        while(l < size){
            things.add(new Wrapper(rand, width / size, 100));
            rand = (int) (Math.random() * 10);
            l++;
        }

        //for (int i = 0; i < size; i++) {
            //things.add(new Wrapper(i, width / size, 100, i * (width / size), 0));
        //}
        reset();
    }

    public void draw() {
        background(0, 0, 0);
        stroke(0, 0, 0);

        for (int z = 0; z < things.size(); z++) {
            things.get(z);
        }
        for (int i = 0; i < size; i++) {
            things.get(i).draw(i * (width / size), 0);
        }
        fill(255, 255, 255);
        if (status == 0) {
            text(target + " FOUND AT INDEX: " + mid, width / 2, height / 2);
        } else if (status == -1) {

            text("Searching for: " + target + "\n ITEM NOT FOUND", width / 2, height / 2);
        } else if (status == 1) {
            text("Searching for: " + target + " \n STILL LOOKING", width / 2, height / 2);
        } else {
            text("Instructions: CLICK 'n' TO PUT THE LIST IN ORDER \n Input a target value  by pressing number keys\n and hit return to start the search. \n Press the 's' key to search \n and the 'r' key to reset.", width / 3, height / 2);
        }

    }
    private void selectionSort(ArrayList <Wrapper> thingOne) {
        for (int curIndex = 0; curIndex < thingOne.size() - 1; curIndex++) {
            int minIndex = findMin(thingOne, curIndex);
            swap(thingOne, curIndex, minIndex);
        }
        for(Wrapper i: thingOne){
            System.out.print(i);
        }

    }
    private int findMin(ArrayList <Wrapper> thingTwo, int startingIndex) {
        int minIndex = startingIndex;
        for (int i = minIndex + 1; i < thingTwo.size(); i++) {
            if (thingTwo.get(i).getNumber() < thingTwo.get(minIndex).getNumber()) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    private void swap(ArrayList <Wrapper> thingThree, int x, int y) {
        Wrapper temp = thingThree.get(x);
        thingThree.set(x, thingThree.get(y));
        thingThree.set(y,temp);
    }


    //
    private int binarySearch() {
        if(low<=high){
            mid = (low+high)/2;
            things.get(mid).hasBeenSearched();
            if(things.get(mid).getNumber() == target){
                return 0;
            }
            else if(things.get(mid).getNumber() < target){
                low=mid+1;
                return 1;
            }
            else{
                high=mid-1;
                return 1;
            }
        }
        else {
            return -1;

        }
    }
    //private int integer(){

    //}
    public void keyPressed(){
        if(key =='s'){
            status = binarySearch();
        }
        else if(key == 'r'){
            reset();
        }
        else if(key == 'n'){
            selectionSort(things);
        }
        else{
            if(key != '\n'){
                userInput += key;
            }
            else{
                target = Integer.parseInt(userInput);
            }
        }
    }
    public void reset(){
        status = -100;
        low = 0;
        high = things.size()-1;
        mid = (low+high)/2;
        userInput = "";

    }
}