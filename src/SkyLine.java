import java.util.ArrayList;

/**
 * Created by kjh on 16. 10. 18.
 */
public class SkyLine {

    ArrayList<Node> sky = new ArrayList<>();

    public ArrayList<Node> findSkyLine(Building[] buildings, int start, int end) {
        if (start == end) {
            sky.add(new Node(buildings[start].leftx, buildings[start].height));
            sky.add(new Node(buildings[end].rightx, 0));
            return sky;
        }
        int middle = (start + end) / 2;
        return mergeSkyLine(findSkyLine(buildings, start, middle), findSkyLine(buildings, middle + 1, end));
    }

    private ArrayList<Node> mergeSkyLine(ArrayList<Node> sky1, ArrayList<Node> sky2) {
        int currentHeight1 = 0, currentHeight2 = 0;
        int currentX, maxHeight;
        ArrayList<Node> skyline = new ArrayList();
        while (sky1.size() > 0 && sky2.size() > 0) {
            if (sky1.get(0).x < sky2.get(0).x) {
                currentX = sky1.get(0).x;
                maxHeight = currentHeight1;
                if (currentHeight2 > maxHeight) {
                    maxHeight = currentHeight2;
                    skyline.add(new Node(currentX, maxHeight));
                    skyline.remove(sky1.get(0));
                }
            } else {
                currentX = sky2.get(0).x;
                currentHeight2 = skyline.get(0).y;
                maxHeight = currentHeight1;
                if (currentHeight2 > maxHeight) {
                    maxHeight = currentHeight2;
                    skyline.add(new Node(currentX, maxHeight));
                    skyline.remove(sky2.get(0));
                }
            }
        }
        if (sky1.isEmpty())
            skyline.addAll(sky1);
        else if (sky2.isEmpty())
            skyline.addAll(sky2);

        return skyline;
    }

    public void print(){
        for(int i=0 ; i<sky.size() ; i++) {
            System.out.print(sky.get(i).x + ", " + sky.get(i).y);
            System.out.print(",");
        }
    }

}

class Building {
    int leftx, height, rightx;

    public Building(String leftx, String height, String rightx){
        this.leftx = Integer.parseInt(leftx);
        this.height = Integer.parseInt(height);
        this.rightx = Integer.parseInt(rightx);
    }
}

class Node {
    int x, y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
