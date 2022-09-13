import java.awt.*;

public class Coin {
    public int xpos;
    public int ypos;
    public boolean isAlive;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public Image pic;
    public Rectangle rec;

    public Coin(int xParameter, int yParameter, Image picParameter)
    {

        //DXrange
        int DXmax = 10;
        int DXmin = 1;
        int DXrange = DXmax - DXmin + 1;
        int DXrand = (int)(Math.random() * DXrange) + DXmin;

        //DYrange
        int DYmax = 10;
        int DYmin = 1;
        int DYrange = DYmax - DYmin + 1;
        int DYrand = (int)(Math.random() * DXrange) + DXmin;

        xpos = xParameter;
        ypos = yParameter;
        isAlive= true;
        width = 40;
        height = 40;
        pic = picParameter;
        dx= DXrand;
        dy= DYrand;
        rec= new Rectangle (xpos,ypos,width,height);


    }

    public void move()

    {
        xpos = xpos + dx;
        ypos = ypos + dy;

        rec= new Rectangle (xpos,ypos,width,40);	//construct a rectangle

    }


    public void coinBouncing(){
        if(xpos<0)
        {
            dx = dx*-1;
            dy = dy*-1;
        }

        if(xpos+width>1000) {
            dx = dx*-1;
            dy = dy*-1;
        }

        if(ypos>4000)
        {
            dx = dx*-1;
            dy = dy*-1;
        }

        if(ypos<0) {
            dx = dx*-1;
            dy = dy*-1;
        }
    }

}
