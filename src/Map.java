import java.awt.*;


public class Map {


        public String name;
        public int xpos;
        public int ypos;
        public int dx;
        public int dy;
        public int width;
        public int height;
        public boolean isAlive;

        public Rectangle rec;
        public Rectangle waterRec;
        public Rectangle lavaRec;

        public Map(int pXpos, int pYpos, Image mapPic) {
            xpos = 0;
            ypos = 100;
            dx = 0;
            dy = -1;
            width = 1000;
            height = 4700;
            isAlive = true;
            rec = new Rectangle(xpos, ypos, width, height);
            waterRec = new Rectangle(1,1270+ypos,999,220);
            lavaRec = new Rectangle(1,4330+ypos, 999, 370);
        }

        public void move() {
            xpos = xpos + dx;
            ypos = ypos + dy;


            rec = new Rectangle(xpos, ypos, width, height);
            waterRec = new Rectangle(1,1270+ypos,999,220);
            lavaRec = new Rectangle(1,4330+ypos, 999, 370);

        }
    }

