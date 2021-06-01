package commands;
import hitting.*;
import java.util.Scanner;

public class Shoot {
    private Shot sh;
    public void shoot(History history){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the coordinates and radius of the shot through the space without other characters X Y R");
        float x;
        float y;
        float r;
        String [] coords;
        String coordinates;
        while (true)
        {
            try {
                coordinates = in.nextLine();
                coords = coordinates.split(" ", 3);
                if (Float.parseFloat(coords[2])<0){
                    coords[2] = "a";
                }
                x = Float.parseFloat(coords[0]);
                y = Float.parseFloat(coords[1]);
                r = Float.parseFloat(coords[2]);
                break;
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong. Possible causes of failure:");
                System.out.println("1) Your numbers are deceiving you (maybe they are not numbers at all)");
                System.out.println("2)Your numbers are deceiving you again (maybe they are too large)");
                System.out.println("3) The radius is deceiving you (it may be negative)");
                System.out.println("Try again: ");
            }
        }
        sh = new Shot(x,y,r);
        Hit.hit_a_target(sh);
        history.add(sh);
    }
    public boolean checkShoot(String... args){
        float x;
        float y;
        float r;
        try {
                x = Float.parseFloat(args[0]);
                y = Float.parseFloat(args[1]);
                r = Float.parseFloat(args[2]);
            }
            catch (Exception e)
            {
                return false;
            }
        sh = new Shot(x,y,r);
        Hit.hit_a_target(sh);
        return sh.getHit();
    }
}
