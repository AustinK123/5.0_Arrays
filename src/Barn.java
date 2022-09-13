import java.awt.*;

public class Barn {

        public int xpos;
        public int ypos;
        public int dx;
        public int dy;
        public int width;
        public int height;

        public Rectangle rec;

        public Barn(int pXpos, int pYpos, Image mapPic) {
            xpos = 0;
            ypos = 4798;
            dx = 0;
            dy = -1;
            width = 1000;
            height = 500;
            rec = new Rectangle(xpos, ypos, width, height);
        }

        public void move() {
            xpos = xpos + dx;
            ypos = ypos + dy;

            rec = new Rectangle(xpos, ypos, width, height);

        }
}
