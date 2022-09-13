import java.awt.*;

public class Log {

    public int xpos;
    public int ypos;
    public boolean isAlive;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public int multiplier;
    public Image pic;
    public Rectangle rec;

    public Log(int xParameter, int yParameter, Image picParameter)
    {
        xpos = xParameter;
        ypos = yParameter;
        isAlive=true;
        width = 120;
        height=60;
        multiplier=1;
        pic = picParameter;
        dx=-2;
        dy=-1;
        rec= new Rectangle (xpos,ypos,width,height);


    }

    public void move()

    {
        xpos = xpos + dx;
        ypos = ypos + dy;

        rec= new Rectangle (xpos,ypos,width,height);

    }


    public void logWrapping(){
        if(xpos+width<0)
        {
            xpos = 1000;
        }

        if(xpos>1000)
        {
            xpos = 0-width;
        }
        rec= new Rectangle (xpos,ypos,width,height);
    }


}
