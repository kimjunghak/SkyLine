import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kjh on 16. 10. 18.
 */
public class SkyLine {


    public ArrayList<int[]> findSkyLine(Building[] buildings, int start, int end) {
        if (start == end) {
            ArrayList<int[]> skyline = new ArrayList<>();
            skyline.add(new int[]{buildings[start].leftx, buildings[start].height});
            skyline.add(new int[]{buildings[end].rightx, 0});
            return skyline;
        }
        int middle = (start + end) / 2;
        ArrayList<int[]> sky1 = findSkyLine(buildings, start, middle);
        ArrayList<int[]> sky2 = findSkyLine(buildings, middle+1, end);
        return mergeSkyLine(sky1, sky2);
    }

    private ArrayList<int[]> mergeSkyLine(ArrayList<int[]> sky1, ArrayList<int[]> sky2) {
        ArrayList<int[]> result = new ArrayList<>();

        while(sky1.size() > 0 && sky2.size() > 0){
            if(sky1.get(0)[0] < sky2.get(0)[0]){
                result.add(sky1.get(0));
                sky1.remove(0);
            }
            else{
                result.add(sky2.get(0));
                sky2.remove(0);
            }
        }

        while(sky1.size() > 0){

            sky1.remove(0);
        }

        while(sky2.size() > 0){

            sky2.remove(0);
        }

        return result;
    }

    private int getFirstIndex(ArrayList<int[]> sky1) {
        return sky1.indexOf(sky1.get(0));
    }

    public void print(Building[] buildings, int num){
        ArrayList<int[]> print = findSkyLine(buildings, 0, num);
        for(int i=0 ; i<print.size() ; i++){
            System.out.print(print.get(i)[0] + ", " + print.get(i)[1]);
            System.out.print(", ");
        }
    }

}

class Building {
    int leftx, height, rightx;

    public Building(int leftx, int height, int rightx){
        this.leftx = leftx;
        this.height = height;
        this.rightx = rightx;
    }
}
