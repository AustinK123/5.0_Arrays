import java.awt.*;


public class Chicken {


   public String name;
   public int xpos;
   public int ypos;
   public int dx;
   public int dy;
   public int width;
   public int height;
   public boolean isAlive;

   public Rectangle rec;



   public Chicken(int pXpos, int pYpos) {
      xpos = 500;
      ypos = 150;
      dx = 0;
      dy = -1;
      width = 50;
      height = 50;
      isAlive = true;
      rec = new Rectangle(xpos, ypos, width, height);

   }
   public void move() {
      xpos = xpos + dx;
      ypos = ypos + dy;


      rec = new Rectangle(xpos, ypos, width, height);


   }
}






