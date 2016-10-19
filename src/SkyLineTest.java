import java.util.Scanner;

/**
 * Created by kjh on 16. 10. 18.
 */
public class SkyLineTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SkyLine skyline = new SkyLine();
        Building[] buildings;
        String[] xhArray;
        int loop = 0;

        System.out.println("빌딩 갯수를 입력하세요 : ");
        int x = scan.nextInt();
        scan.nextLine();

        buildings = new Building[x];

        while(loop < x) {
            System.out.println("왼쪽 x 좌표, 높이, 오른쪽 x 좌표를 입력하세요 : (ex 1,11,5)");
            String xh = scan.nextLine();
            xhArray = xh.split(",");
            buildings[loop] = new Building(xhArray[0], xhArray[1], xhArray[2]);
            loop++;
        }
        if(x == 1)
            skyline.findSkyLine(buildings, 0, 0);



    }
}
