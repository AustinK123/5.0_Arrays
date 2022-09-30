import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;




import java.io.*;
import java.net.URL;
import java.util.EventListener;
import javax.sound.sampled.*;


//*******************************************************************************

public class BasicGameApp implements Runnable, KeyListener, MouseListener {


    final int WIDTH = 1000;
    final int HEIGHT = 700;

    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
//was previously public vvv
    private BufferStrategy bufferStrategy;

        //image variable was previously public
        private Image chickenPic;

        public Image carPic4;
        public Image carPic5;
        public Image carPic6;
        public Image carPic7;
        public Image carPic8;
        public Image carPic9;
        public Image carPic10;
        public Image carPic11;
        public Image carPic12;
        public Image carPic13;
        public Image carPic14;
        public Image carPic15;
        public Image carPic16;
        public Image carPic17;
        public Image carPic18;
        public Image carPic19;
        public Image carPic20;
        public Image carPic21;
        public Image carPic22;
        public Image carPic23;

        public double timecount= 0;

        public Image polarPic;

        public Image coinPic;

        public Image logPic;

        public Image rockPic;

        public Image mapPic;

        public Image barnPic;

    public boolean hitboxCoutner = false;
    public boolean logBool = false;
    public boolean lavaBool = false;
    public boolean startBool = false;
    public int moneys = 0;
    public int movementCounter;
    public int mapSpeed = 1;
    public boolean Intersection = true;
    public boolean victoryBool = false;

    public Chicken chick;

    public Map map;
    public Barn barn;
    public String backgroundNoise = "highway-1.wav";

    public Car[] cars;
    public Car[] cars2;
    public Car[] cars3;
    public Car[] cars4;
    public Car[] cars5;
    public Car[] cars6;
    public Car[] cars7;
    public Car[] cars8;
    public Car[] cars9;
    public Car[] cars10;
    public Car[] cars11;
    public Car[] cars12;
    public Car[] cars13;
    public Car[] cars14;
    public Car[] cars15;
    public Car[] cars16;
    public Car[] cars17;
    public Car[] cars18;
    public Car[] cars19;
    public Car[] cars20;

    public Car[] polarbear;
    public Car[] polarbear2;

    public Log log1;
    public Log log2;
    public Log[] logs;
    public Log[] logs2;
    public Log[] lavaRock;
    public Log[] lavaRock2;
    public Log[] lavaRock3;
    public Log[] lavaRock4;

    public Coin[] coins;


    public static void main(String[] args) {
        BasicGameApp myApp = new BasicGameApp();
        new Thread(myApp).start();
    }



    public BasicGameApp() {

        setUpGraphics();

        canvas.addMouseListener(this);
        canvas.addKeyListener(this);
        chickenPic = Toolkit.getDefaultToolkit().getImage("treadmill-chicken.gif");

        carPic4 = Toolkit.getDefaultToolkit().getImage("Car1-01.png"); //red, left
        carPic5 = Toolkit.getDefaultToolkit().getImage("Car3-02.png"); //blue, left
        //road division
        carPic6 = Toolkit.getDefaultToolkit().getImage("Car4-06.png"); //blue, right
        carPic7 = Toolkit.getDefaultToolkit().getImage("Car2-04.png"); //red, right
        //road division
        carPic8 = Toolkit.getDefaultToolkit().getImage("Car4-06.png");
        carPic9 = Toolkit.getDefaultToolkit().getImage("Car2-04.png");
        //road division
        carPic10 = Toolkit.getDefaultToolkit().getImage("Car1-01.png");
        carPic11 = Toolkit.getDefaultToolkit().getImage("Car3-02.png");
        //road division
        carPic12 = Toolkit.getDefaultToolkit().getImage("Car2-04.png");
        carPic13 = Toolkit.getDefaultToolkit().getImage("Car4-06.png");
        //road division
        carPic14 = Toolkit.getDefaultToolkit().getImage("Car1-01.png");
        carPic15 = Toolkit.getDefaultToolkit().getImage("Car3-02.png");
        //road division
        carPic16 = Toolkit.getDefaultToolkit().getImage("Car2-04.png");
        carPic17 = Toolkit.getDefaultToolkit().getImage("Car3-02.png");
        carPic18 = Toolkit.getDefaultToolkit().getImage("Car2-04.png");
        carPic19 = Toolkit.getDefaultToolkit().getImage("Car3-02.png");
        //road division
        carPic20 = Toolkit.getDefaultToolkit().getImage("Car2-04.png");
        carPic21 = Toolkit.getDefaultToolkit().getImage("Car4-06.png");
        //road division
        carPic22 = Toolkit.getDefaultToolkit().getImage("green-car-left.png");
        carPic23 = Toolkit.getDefaultToolkit().getImage("Car3-02.png");

        polarPic = Toolkit.getDefaultToolkit().getImage("snowman-6.gif");

        logPic = Toolkit.getDefaultToolkit().getImage("Log3.png");

        coinPic = Toolkit.getDefaultToolkit().getImage("Moneys.gif");

        mapPic = Toolkit.getDefaultToolkit().getImage("Game_Background_Updated.png");

        rockPic = Toolkit.getDefaultToolkit().getImage("rock7!!!.png");

        barnPic = Toolkit.getDefaultToolkit().getImage("barn7!!!.png");

        chick = new Chicken(10, 100);

        map = new Map(0, 0, mapPic);

        barn = new Barn(0,map.ypos+4700,barnPic);

        cars = new Car[5];
        cars2 = new Car[5];
        cars3 = new Car[5];
        cars4 = new Car[5];
        cars5 = new Car[5];
        cars6 = new Car[5];
        cars7 = new Car[5];
        cars8 = new Car[5];
        cars9 = new Car[5];
        cars10 = new Car[5];
        cars11 = new Car[5];
        cars12 = new Car[5];
        cars13 = new Car[5];
        cars14 = new Car[5];
        cars15 = new Car[5];
        cars16 = new Car[5];
        cars17 = new Car[5];
        cars18 = new Car[5];
        cars19 = new Car[5];
        cars20 = new Car[5];
        logs = new Log[3];
        logs2 = new Log[3];

        lavaRock = new Log[3];
        lavaRock2 = new Log[3];
        lavaRock3 = new Log[3];
        lavaRock4 = new Log[3];


        polarbear = new Car[3];
        polarbear2 = new Car[3];

        coins = new Coin[20];


        int carsxpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars[i] = new Car(carsxpos-i*(map.width+90)/cars.length, 870, carPic4);
            cars[i].dx = -1;
        }
        int cars2xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars2[i] = new Car(cars2xpos-i*(map.width+90)/cars2.length, 970, carPic5);
        }
        int cars3xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars3[i] = new Car(cars3xpos-i*(map.width+90)/cars3.length, 1120, carPic6);
            cars3[i].dx = 2;
        }
        int cars4xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars4[i] = new Car(cars4xpos-i*(map.width+90)/cars4.length, 1225, carPic7);
            cars4[i].dx = 1;
        }
        int cars5xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars5[i] = new Car(cars5xpos-i*(map.width+90)/cars5.length, 2075, carPic8);
            cars5[i].dx = 1;
        }
        int cars6xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars6[i] = new Car(cars6xpos-i*(map.width+90)/cars6.length, 2190, carPic9);
            cars6[i].dx = 2;
        }
        int cars7xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars7[i] = new Car(cars7xpos-i*(map.width+90)/cars7.length, 2340, carPic10);
            cars7[i].dx = -1;
        }
        int cars8xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars8[i] = new Car(cars8xpos-i*(map.width+90)/cars8.length, 2455, carPic11);
            cars8[i].dx = -2;
        }
        int cars9xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars9[i] = new Car(cars9xpos-i*(map.width+90)/cars9.length, 3005, carPic12);
            cars9[i].dx = 2;
        }
        int cars10xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars10[i] = new Car(cars10xpos-i*(map.width+90)/cars10.length, 3115, carPic13);
            cars10[i].dx = 1;
        }
        int cars11xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars11[i] = new Car(cars11xpos-i*(map.width+90)/cars11.length, 3270, carPic14);
            cars11[i].dx = -1;
        }
        int cars12xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars12[i] = new Car(cars12xpos-i*(map.width+90)/cars12.length, 3375, carPic15);
            cars12[i].dx = -2;
        }
        int cars13xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars13[i] = new Car(cars13xpos-i*(map.width+90)/cars13.length, 3510, carPic16);
            cars13[i].dx = 1;
            cars13[i].width = cars13[i].width - 10;
            cars13[i].height = cars13[i].height - 10;
        }
        int cars14xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars14[i] = new Car(cars14xpos-i*(map.width+90)/cars14.length, 3600, carPic17);
            cars14[i].dx = -2;
            cars14[i].width = cars14[i].width - 10;
            cars14[i].height = cars14[i].height - 10;
        }
        int cars15xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars15[i] = new Car(cars15xpos-i*(map.width+90)/cars15.length, 3690, carPic18);
            cars15[i].dx = 1;
            cars15[i].width = cars15[i].width - 10;
            cars15[i].height = cars15[i].height - 10;
        }
        int cars16xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars16[i] = new Car(cars16xpos-i*(map.width+90)/cars16.length, 3780, carPic19);
            cars16[i].dx = -2;
            cars16[i].width = cars16[i].width - 10;
            cars16[i].height = cars16[i].height - 10;
        }
        int cars17xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars17[i] = new Car(cars17xpos-i*(map.width+90)/cars17.length, 3925, carPic20);
            cars17[i].dx = 2;
        }
        int cars18xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars18[i] = new Car(cars18xpos-i*(map.width+90)/cars18.length, 4032, carPic21);
            cars18[i].dx = 1;
        }
        int cars19xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars19[i] = new Car(cars19xpos-i*(map.width+90)/cars19.length, 4185, carPic22);
            cars19[i].dx = -1;
        }
        int cars20xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 5; i++) {
            cars20[i] = new Car(cars20xpos-i*(map.width+90)/cars20.length, 4290, carPic23);
            cars20[i].dx = -2;
        }

        int polarxpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            polarbear[i] = new Car(polarxpos-i*(map.width+90)/polarbear.length, 2600, polarPic);
            polarbear[i].dx = -4;
        }

        int polar2xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            polarbear2[i] = new Car(polar2xpos-i*(map.width+90)/polarbear2.length, 2750, polarPic);
            polarbear2[i].dx = -3;
        }


        //Xrange
        int Xmax = 999;
        int Xmin = 1;
        int Xrange = Xmax - Xmin + 1;
        //Yrange
        int Ymax = 3999;
        int Ymin = 1;
        int Yrange = Ymax - Ymin + 1;

        for (int i = 0; i < 20; i++) {
            int Xrand = (int)(Math.random() * Xrange) + Xmin;
            int Yrand = (int)(Math.random() * Yrange) + Ymin;
            coins[i] = new Coin(Xrand,Yrand,coinPic);
        }

        log1 = new Log(800,1360, logPic);
        log1.dx = 3;
        log2 = new Log(600,1420, logPic);

        int logsxpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            logs[i] = new Log(logsxpos-i*(map.width+90)/logs.length, 1480, logPic);
            logs[i].dx = -2;
        }
        int logs2xpos = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            logs2[i] = new Log(logs2xpos - i * (map.width + 90) / logs2.length, 1560, logPic);
            logs2[i].dx = -1;
        }

        int rocks = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            lavaRock[i] = new Log(rocks - i * (map.width + 90) / lavaRock.length, 4420, rockPic);
            lavaRock[i].dx = -1;
        }
        int rocks2 = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            lavaRock2[i] = new Log(rocks2 - i * (map.width + 90) / lavaRock2.length, 4520, rockPic);
            lavaRock2[i].dx = -2;
        }
        int rocks3 = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            lavaRock3[i] = new Log(rocks3 - i * (map.width + 90) / lavaRock3.length, 4620, rockPic);
            lavaRock3[i].dx = 1;
        }
        int rocks4 = (int) (Math.random() * 200)+700;
        for (int i = 0; i < 3; i++) {
            lavaRock4[i] = new Log(rocks4 - i * (map.width + 90) / lavaRock4.length, 4700, rockPic);
            lavaRock4[i].dx = -3;
        }
            //playSound("highway-1.wav");

    }




        public void run () {

    while (true) {
        moveThings();
        if(Intersection == true){
            checkIntersections();
        }
        render();
        pause(20);
    }

    }



    public void moveThings() {
        if(victoryBool == false){
            timecount += 0.02;
        }

        log1.move();
        log1.logWrapping();
        log2.move();
        log2.logWrapping();

        barn.move();

        for (int index = 0; index < logs.length; index++) {
            logs[index].move();
            logs[index].logWrapping();
        }
        for (int index = 0; index < logs2.length; index++) {
            logs2[index].move();
            logs2[index].logWrapping();
        }

        for (int index = 0; index < lavaRock.length; index++) {
            lavaRock[index].move();
            lavaRock[index].logWrapping();
        }
        for (int index = 0; index < lavaRock2.length; index++) {
            lavaRock2[index].move();
            lavaRock2[index].logWrapping();
        }
        for (int index = 0; index < lavaRock3.length; index++) {
            lavaRock3[index].move();
            lavaRock3[index].logWrapping();
        }
        for (int index = 0; index < lavaRock4.length; index++) {
            lavaRock4[index].move();
            lavaRock4[index].logWrapping();
        }
        chick.move();

        map.move();

        for (int index = 0; index < cars.length; index++) {
            cars[index].move();
            cars[index].carwrapping();
        }
        for (int index = 0; index < cars2.length; index++) {
            cars2[index].move();
            cars2[index].carwrapping();
        }
        for (int index = 0; index < cars3.length; index++) {
            cars3[index].move();
            cars3[index].carwrapping();
        }
        for (int index = 0; index < cars4.length; index++) {
            cars4[index].move();
            cars4[index].carwrapping();
        }
        for (int index = 0; index < cars5.length; index++) {
            cars5[index].move();
            cars5[index].carwrapping();
        }
        for (int index = 0; index < cars6.length; index++) {
            cars6[index].move();
            cars6[index].carwrapping();
        }
        for (int index = 0; index < cars7.length; index++) {
            cars7[index].move();
            cars7[index].carwrapping();
        }
        for (int index = 0; index < cars8.length; index++) {
            cars8[index].move();
            cars8[index].carwrapping();
        }
        for (int index = 0; index < cars9.length; index++) {
            cars9[index].move();
            cars9[index].carwrapping();
        }
        for (int index = 0; index < cars10.length; index++) {
            cars10[index].move();
            cars10[index].carwrapping();
        }
        for (int index = 0; index < cars11.length; index++) {
            cars11[index].move();
            cars11[index].carwrapping();
        }
        for (int index = 0; index < cars12.length; index++) {
            cars12[index].move();
            cars12[index].carwrapping();
        }
        for (int index = 0; index < cars13.length; index++) {
            cars13[index].move();
            cars13[index].carwrapping();
        }
        for (int index = 0; index < cars14.length; index++) {
            cars14[index].move();
            cars14[index].carwrapping();
        }
        for (int index = 0; index < cars15.length; index++) {
            cars15[index].move();
            cars15[index].carwrapping();
        }
        for (int index = 0; index < cars16.length; index++) {
            cars16[index].move();
            cars16[index].carwrapping();
        }
        for (int index = 0; index < cars17.length; index++) {
            cars17[index].move();
            cars17[index].carwrapping();
        }
        for (int index = 0; index < cars18.length; index++) {
            cars18[index].move();
            cars18[index].carwrapping();
        }
        for (int index = 0; index < cars19.length; index++) {
            cars19[index].move();
            cars19[index].carwrapping();
        }
        for (int index = 0; index < cars20.length; index++) {
            cars20[index].move();
            cars20[index].carwrapping();
        }

        for (int index = 0; index < polarbear.length; index++) {
            polarbear[index].move();
            polarbear[index].carwrapping();
            polarbear2[index].move();
            polarbear2[index].carwrapping();
        }

        for (int index = 0; index < coins.length; index++) {
            coins[index].move();
            coins[index].coinBouncing();
        }


    }



    public void checkIntersections() {


        for (int i = 0; i < cars.length; i++) {
            if (chick.rec.intersects(cars[i].rec) && cars[i].isAlive) {
                chick.isAlive = false;
            }
        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars2.length; i++) {
            if (chick.rec.intersects(cars2[i].rec) && cars2[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ////////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars3.length; i++) {
            if (chick.rec.intersects(cars3[i].rec) && cars3[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ////////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars4.length; i++) {
            if (chick.rec.intersects(cars4[i].rec) && cars4[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ////////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars5.length; i++) {
            if (chick.rec.intersects(cars5[i].rec) && cars5[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        /////////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars6.length; i++) {
            if (chick.rec.intersects(cars6[i].rec) && cars6[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        /////////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars7.length; i++) {
            if (chick.rec.intersects(cars7[i].rec) && cars7[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars8.length; i++) {
            if (chick.rec.intersects(cars8[i].rec) && cars8[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars9.length; i++) {
            if (chick.rec.intersects(cars9[i].rec) && cars9[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars9.length; i++) {
            if (chick.rec.intersects(cars9[i].rec) && cars9[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars10.length; i++) {
            if (chick.rec.intersects(cars8[i].rec) && cars10[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars11.length; i++) {
            if (chick.rec.intersects(cars11[i].rec) && cars11[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars12.length; i++) {
            if (chick.rec.intersects(cars12[i].rec) && cars12[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars13.length; i++) {
            if (chick.rec.intersects(cars13[i].rec) && cars13[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars14.length; i++) {
            if (chick.rec.intersects(cars14[i].rec) && cars14[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars15.length; i++) {
            if (chick.rec.intersects(cars15[i].rec) && cars15[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars16.length; i++) {
            if (chick.rec.intersects(cars16[i].rec) && cars16[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars17.length; i++) {
            if (chick.rec.intersects(cars17[i].rec) && cars17[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars18.length; i++) {
            if (chick.rec.intersects(cars18[i].rec) && cars18[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars19.length; i++) {
            if (chick.rec.intersects(cars8[i].rec) && cars19[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < cars20.length; i++) {
            if (chick.rec.intersects(cars20[i].rec) && cars20[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////
        for (int i = 0; i < polarbear.length; i++) {
            if (chick.rec.intersects(polarbear[i].rec) && polarbear[i].isAlive == true) {
                chick.isAlive = false;
            }

        }
        for (int i = 0; i < polarbear2.length; i++) {
            if (chick.rec.intersects(polarbear2[i].rec)) {
                chick.isAlive = false;
            }

        }
        ///////////////////////////////////////////////////////////////////////////////
        if(map.ypos < -2000) {
            for (int i = 0; i < 3; i++) {
                if (chick.rec.intersects(lavaRock[i].rec)) {
                    chick.dx = lavaRock[i].dx;
                    lavaBool = true;
                } else if (chick.rec.intersects(lavaRock2[i].rec)) {
                    chick.dx = lavaRock2[i].dx;
                    lavaBool = true;
                } else if (chick.rec.intersects(lavaRock3[i].rec)) {
                    chick.dx = lavaRock3[i].dx;
                    lavaBool = true;
                } else {
                    lavaBool = false;
                    chick.dx = 0;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (chick.rec.intersects(lavaRock4[i].rec)) {
                    chick.dx = lavaRock4[i].dx;
                    lavaBool = true;
                } else if (chick.rec.intersects(lavaRock[i].rec)) {
                    chick.dx = lavaRock[i].dx;
                    lavaBool = true;
                } else if (chick.rec.intersects(lavaRock2[i].rec)) {
                    chick.dx = lavaRock2[i].dx;
                    lavaBool = true;
                } else if (chick.rec.intersects(lavaRock3[i].rec)) {
                    chick.dx = lavaRock3[i].dx;
                    lavaBool = true;
                }
            }
            if (chick.rec.intersects(map.lavaRec) && lavaBool == false) {
                chick.isAlive = false;
                System.out.println("fried chicken");
            }
        }
        else{
            if(chick.rec.intersects(log1.rec)){
                chick.dx = log1.dx;
                logBool = true;
            }
            else if(chick.rec.intersects(log2.rec)){
                chick.dx = log2.dx;
                logBool = true;
            }
            else{
                logBool = false;
                chick.dx = 0;
            }
            for(int i = 0; i < 3; i++){
                if(chick.rec.intersects(logs[i].rec)){
                    chick.dx = logs[i].dx;
                    logBool = true;
                }
                else if(chick.rec.intersects(log1.rec)){
                    chick.dx = log1.dx;
                    logBool = true;
                }
                else if (chick.rec.intersects(log2.rec)) {
                    chick.dx = log2.dx;
                    logBool = true;
                }
                else if (chick.rec.intersects(logs2[i].rec)) {
                    chick.dx = logs2[i].dx;
                    logBool = true;
                }
            }
            if(chick.rec.intersects(map.waterRec) && logBool == false){
                chick.isAlive = false;
                System.out.println("splash");
            }
        }
        ///////////////////////////////////////////////////////////////////////////////
        for(int i = 0; i < 20; i++){
            if(chick.rec.intersects(coins[i].rec)){
                coins[i].isAlive = false;
                moneys++;
            }
        }
        ///////////////////////////////////////////////////////////////////////////////
            if(chick.rec.intersects(barn.rec)){
                victoryBool = true;
                System.out.println("BARN");
            }

        }


    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        if (chick.ypos < 0- chick.height) {
            chick.isAlive = false;
        }
        if (chick.xpos < 0- chick.width) {
            chick.isAlive = false;
        }
        if (chick.xpos > 1000+ chick.width) {
            chick.isAlive = false;
        }



        g.drawImage(mapPic, map.xpos, map.ypos, map.width, map.height, null);

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].isAlive)
                g.drawImage(logs[i].pic, logs[i].xpos, logs[i].ypos, logs[i].width, logs[i].height, null);
            g.drawImage(logs2[i].pic, logs2[i].xpos, logs2[i].ypos, logs2[i].width, logs2[i].height, null);
        }
        for (int i = 0; i < lavaRock.length; i++) {
            if (lavaRock[i].isAlive)
                g.drawImage(lavaRock[i].pic, lavaRock[i].xpos, lavaRock[i].ypos, lavaRock[i].width, lavaRock[i].height, null);
            g.drawImage(lavaRock2[i].pic, lavaRock2[i].xpos, lavaRock2[i].ypos, lavaRock2[i].width, lavaRock2[i].height, null);
            g.drawImage(lavaRock3[i].pic, lavaRock3[i].xpos, lavaRock3[i].ypos, lavaRock3[i].width, lavaRock3[i].height, null);
            g.drawImage(lavaRock4[i].pic, lavaRock4[i].xpos, lavaRock4[i].ypos, lavaRock4[i].width, lavaRock4[i].height, null);

        }

        g.drawImage(logPic, log1.xpos, log1.ypos, log1.width, log1.height, null);
        g.drawImage(logPic, log2.xpos, log2.ypos, log2.width, log2.height, null);
        g.drawImage(chickenPic, chick.xpos, chick.ypos, chick.width, chick.height, null);

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].isAlive)
                g.drawImage(cars[i].pic, cars[i].xpos, cars[i].ypos, cars[i].width, cars[i].height, null);
        }

        for (int i = 0; i < cars2.length; i++) {

            if (cars2[i].isAlive)
                g.drawImage(cars2[i].pic, cars2[i].xpos, cars2[i].ypos, cars2[i].width, cars2[i].height, null);
        }
        for (int i = 0; i < cars3.length; i++) {

            if (cars3[i].isAlive)
                g.drawImage(cars3[i].pic, cars3[i].xpos, cars3[i].ypos, cars3[i].width, cars3[i].height, null);
        }
        for (int i = 0; i < cars4.length; i++) {

            if (cars4[i].isAlive)
                g.drawImage(cars4[i].pic, cars4[i].xpos, cars4[i].ypos, cars4[i].width, cars4[i].height, null);
        }
        for (int i = 0; i < cars5.length; i++) {

            if (cars5[i].isAlive)
                g.drawImage(cars5[i].pic, cars5[i].xpos, cars5[i].ypos, cars5[i].width, cars5[i].height, null);
        }
        for (int i = 0; i < cars6.length; i++) {

            if (cars6[i].isAlive)
                g.drawImage(cars6[i].pic, cars6[i].xpos, cars6[i].ypos, cars6[i].width, cars6[i].height, null);
        }
        for (int i = 0; i < cars7.length; i++) {

            if (cars7[i].isAlive)
                g.drawImage(cars7[i].pic, cars7[i].xpos, cars7[i].ypos, cars7[i].width, cars7[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars8[i].isAlive)
                g.drawImage(cars8[i].pic, cars8[i].xpos, cars8[i].ypos, cars8[i].width, cars8[i].height, null);
        }
        for (int i = 0; i < cars9.length; i++) {

            if (cars9[i].isAlive)
                g.drawImage(cars9[i].pic, cars9[i].xpos, cars9[i].ypos, cars9[i].width, cars9[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars9[i].isAlive)
                g.drawImage(cars9[i].pic, cars9[i].xpos, cars9[i].ypos, cars9[i].width, cars9[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars9[i].isAlive)
                g.drawImage(cars9[i].pic, cars9[i].xpos, cars9[i].ypos, cars9[i].width, cars9[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars10[i].isAlive)
                g.drawImage(cars10[i].pic, cars10[i].xpos, cars10[i].ypos, cars10[i].width, cars10[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars11[i].isAlive)
                g.drawImage(cars11[i].pic, cars11[i].xpos, cars11[i].ypos, cars11[i].width, cars11[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars12[i].isAlive)
                g.drawImage(cars12[i].pic, cars12[i].xpos, cars12[i].ypos, cars12[i].width, cars12[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars13[i].isAlive)
                g.drawImage(cars13[i].pic, cars13[i].xpos, cars13[i].ypos, cars13[i].width, cars13[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars14[i].isAlive)
                g.drawImage(cars14[i].pic, cars14[i].xpos, cars14[i].ypos, cars14[i].width, cars14[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars15[i].isAlive)
                g.drawImage(cars15[i].pic, cars15[i].xpos, cars15[i].ypos, cars15[i].width, cars15[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars16[i].isAlive)
                g.drawImage(cars16[i].pic, cars16[i].xpos, cars16[i].ypos, cars16[i].width, cars16[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars17[i].isAlive)
                g.drawImage(cars17[i].pic, cars17[i].xpos, cars17[i].ypos, cars17[i].width, cars17[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars18[i].isAlive)
                g.drawImage(cars18[i].pic, cars18[i].xpos, cars18[i].ypos, cars18[i].width, cars18[i].height, null);
        }
        for (int i = 0; i < cars8.length; i++) {

            if (cars19[i].isAlive)
                g.drawImage(cars19[i].pic, cars19[i].xpos, cars19[i].ypos, cars19[i].width, cars19[i].height, null);
        }
        for (int i = 0; i < cars20.length; i++) {

            if (cars20[i].isAlive)
                g.drawImage(cars20[i].pic, cars20[i].xpos, cars20[i].ypos, cars20[i].width, cars20[i].height, null);
        }

        for (int i = 0; i < polarbear.length; i++) {

            if (polarbear[i].isAlive) {
                g.drawImage(polarbear[i].pic, polarbear[i].xpos, polarbear[i].ypos, polarbear[i].width, polarbear[i].height, null);
            }
            if (polarbear2[i].isAlive) {
                g.drawImage(polarbear2[i].pic, polarbear2[i].xpos, polarbear2[i].ypos, polarbear2[i].width, polarbear2[i].height, null);
            }
        }

        for (int i = 0; i < coins.length; i++) {
            if (coins[i].isAlive)
                g.drawImage(coins[i].pic, coins[i].xpos, coins[i].ypos, coins[i].width, coins[i].height, null);
        }
        if(timecount < 5){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD,30));
            g.drawString("Use arrow keys to move",100,HEIGHT/2);
            g.drawString("Press 'I' to turn intersections off, and 'O' to turn them back on",100,HEIGHT/2+40);
            g.drawString("Press 'S' to show hitboxes, and 'D' to hide them",100,HEIGHT/2+80);
            g.drawString("Use '[' and ']' to make the map faster or slower",100,HEIGHT/2+120);
            g.drawString("avoid the obstacles and don't go off the top of the screen",100,HEIGHT/2+170);

        }
        g.drawImage(barnPic, barn.xpos, barn.ypos, barn.width, barn.height, null);



        if(hitboxCoutner == true){
            for (int i = 0; i < 5; i++) {
                g.setColor(Color.RED);
                g.drawRect(cars2[i].xpos, cars2[i].ypos, cars2[i].width, cars2[i].height);
                g.drawRect(cars[i].xpos, cars[i].ypos, cars[i].width, cars[i].height);
                g.drawRect(cars3[i].xpos, cars3[i].ypos, cars3[i].width, cars3[i].height);
                g.drawRect(cars4[i].xpos, cars4[i].ypos, cars4[i].width, cars4[i].height);
                g.drawRect(cars5[i].xpos, cars5[i].ypos, cars5[i].width, cars5[i].height);
                g.drawRect(cars6[i].xpos, cars6[i].ypos, cars6[i].width, cars6[i].height);
                g.drawRect(cars7[i].xpos, cars7[i].ypos, cars7[i].width, cars7[i].height);
                g.drawRect(cars8[i].xpos, cars8[i].ypos, cars8[i].width, cars8[i].height);
                g.drawRect(cars9[i].xpos, cars9[i].ypos, cars9[i].width, cars9[i].height);
                g.drawRect(cars10[i].xpos, cars10[i].ypos, cars10[i].width, cars10[i].height);
                g.drawRect(cars11[i].xpos, cars11[i].ypos, cars11[i].width, cars11[i].height);
                g.drawRect(cars12[i].xpos, cars12[i].ypos, cars12[i].width, cars12[i].height);
                g.drawRect(cars13[i].xpos, cars13[i].ypos, cars13[i].width, cars13[i].height);
                g.drawRect(cars14[i].xpos, cars14[i].ypos, cars14[i].width, cars14[i].height);
                g.drawRect(cars15[i].xpos, cars15[i].ypos, cars15[i].width, cars15[i].height);
                g.drawRect(cars16[i].xpos, cars16[i].ypos, cars16[i].width, cars16[i].height);
                g.drawRect(cars17[i].xpos, cars17[i].ypos, cars17[i].width, cars17[i].height);
                g.drawRect(cars18[i].xpos, cars18[i].ypos, cars18[i].width, cars18[i].height);
                g.drawRect(cars19[i].xpos, cars19[i].ypos, cars19[i].width, cars19[i].height);
                g.drawRect(cars20[i].xpos, cars20[i].ypos, cars20[i].width, cars20[i].height);

            }

            for (int i = 0; i < 3; i++) {
                g.drawRect(polarbear[i].xpos, polarbear[i].ypos, polarbear[i].width, polarbear[i].height);
                g.drawRect(polarbear2[i].xpos, polarbear2[i].ypos, polarbear2[i].width, polarbear2[i].height);
                g.drawRect(logs[i].xpos, logs[i].ypos, logs[i].width, logs[i].height/2);
                g.drawRect(logs2[i].xpos, logs2[i].ypos, logs2[i].width, logs2[i].height/2);
                g.drawRect(lavaRock[i].xpos, lavaRock[i].ypos, lavaRock[i].width, lavaRock[i].height);
                g.drawRect(lavaRock2[i].xpos, lavaRock2[i].ypos, lavaRock2[i].width, lavaRock2[i].height);
                g.drawRect(lavaRock3[i].xpos, lavaRock3[i].ypos, lavaRock3[i].width, lavaRock3[i].height);
                g.drawRect(lavaRock4[i].xpos, lavaRock4[i].ypos, lavaRock4[i].width, lavaRock4[i].height);
            }

            g.drawRect(1,1270+map.ypos,999,220);
            g.drawRect(log1.xpos,log1.ypos,log1.width,log1.height/2);
            g.drawRect(log2.xpos,log2.ypos,log2.width,log2.height/2);
            g.drawRect(chick.xpos, chick.ypos, chick.width, chick.height);
            g.drawRect(barn.xpos, barn.ypos, barn.width, barn.height);


            {
                g.drawString("100", 500, map.ypos + 100);
                g.drawString("200", 500, map.ypos + 200);
                g.drawString("300", 500, map.ypos + 300);
                g.drawString("400", 500, map.ypos + 400);
                g.drawString("500", 500, map.ypos + 500);
                g.drawString("600", 500, map.ypos + 600);
                g.drawString("700", 500, map.ypos + 700);
                g.drawString("800", 500, map.ypos + 800);
                g.drawString("900", 500, map.ypos + 900);
                g.drawString("1000", 500, map.ypos + 1000);
                g.drawString("1100", 500, map.ypos + 1100);
                g.drawString("1200", 500, map.ypos + 1200);
                g.drawString("1300", 500, map.ypos + 1300);
                g.drawString("1400", 500, map.ypos + 1400);
                g.drawString("1500", 500, map.ypos + 1500);
                g.drawString("1600", 500, map.ypos + 1600);
                g.drawString("1700", 500, map.ypos + 1700);
                g.drawString("1800", 500, map.ypos + 1800);
                g.drawString("1900", 500, map.ypos + 1900);
                g.drawString("2000", 500, map.ypos + 2000);
                g.drawString("2100", 500, map.ypos + 2100);
                g.drawString("2200", 500, map.ypos + 2200);
                g.drawString("2300", 500, map.ypos + 2300);
                g.drawString("2400", 500, map.ypos + 2400);
                g.drawString("2500", 500, map.ypos + 2500);
                g.drawString("2600", 500, map.ypos + 2600);
                g.drawString("2700", 500, map.ypos + 2700);
                g.drawString("2800", 500, map.ypos + 2800);
                g.drawString("2900", 500, map.ypos + 2900);
                g.drawString("3000", 500, map.ypos + 3000);
                g.drawString("3100", 500, map.ypos + 3100);
                g.drawString("3200", 500, map.ypos + 3200);
                g.drawString("3300", 500, map.ypos + 3300);
                g.drawString("3400", 500, map.ypos + 3400);
                g.drawString("3500", 500, map.ypos + 3500);
                g.drawString("3600", 500, map.ypos + 3600);
                g.drawString("3700", 500, map.ypos + 3700);
                g.drawString("3800", 500, map.ypos + 3800);
                g.drawString("3900", 500, map.ypos + 3900);
                g.drawString("4000", 500, map.ypos + 4000);
                g.drawString("4100", 500, map.ypos + 4100);
                g.drawString("4200", 500, map.ypos + 4200);
                g.drawString("4300", 500, map.ypos + 4300);
                g.drawString("4400", 500, map.ypos + 4400);
                g.drawString("4500", 500, map.ypos + 4500);
                g.drawString("4600", 500, map.ypos + 4600);
                g.drawString("4700", 500, map.ypos + 4700);
            }


        }

        g.setFont(new Font("Courier", Font.BOLD,12));
        g.setColor(Color.WHITE);
        g.fillRect(45,35,120,60);
        g.setColor(Color.BLUE);
        g.drawString("time since start: " +(int)timecount,50,50 );
        g.drawString("money: " + moneys,50,60);
        g.drawString("movements: " +movementCounter,50,70);
        g.drawString("map speed: " +mapSpeed,50,80);
        g.drawString("Intersections: " +Intersection,50,90);

        if (chick.isAlive == false) {
            map.dy = 0;
            g.clearRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD,75));

            g.drawString("You Died! :(", WIDTH /3, HEIGHT / 2);
            g.setColor(Color.cyan);
            g.drawString("Re-run to play again", WIDTH /5, (HEIGHT / 2)+100);

            hitboxCoutner = false;
        }
        if (victoryBool == true) {
            map.dy = 0;
            g.clearRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD,75));


            //MINIMUM MOVEMENTS: 462
            g.drawString("You Won!!!! :)", WIDTH /3, HEIGHT / 2);
            g.setColor(Color.GREEN);
            g.drawString("time: "+(int)(timecount), 400, HEIGHT / 2+100);

            int score = movementCounter-462-((int)timecount*2)+moneys;
            g.drawString("score: "+score, 400, HEIGHT / 2+200);
            //BEST TIME: 84
            //SCORE: 449

            //romero is more sheltered from the complex life that the others lead
            //bull fighting gives jake a sense of belonging to something meaningful
            //people do bullfighting just for fun, but people do it for pleasure, for fun
            //hemingway shows the negative side of something "beautiful" through the death of a person with bull fighting
            //also seen in brett, who "is beautiful", but there is a darker side.
            g.setColor(Color.cyan);
            g.drawString("Rerun to play again", WIDTH /5, (HEIGHT / 2)+300);

            hitboxCoutner = false;
        }

        g.dispose();

        bufferStrategy.show();


    }



    public void playSound(String name) {

        try {

            // Open an audio input stream.
            File soundFile = new File(name); //you could also get the sound file with a URL
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();   //start playing the sound
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key= e.getKeyCode();
        //System.out.println(e.getKeyCode());
        if(key==40){
            chick.ypos = chick.ypos + 10;
            movementCounter++;
        }
        if(key==37){
            chick.xpos = chick.xpos - 10;
            movementCounter++;
        }
        if(key==39){
            chick.xpos = chick.xpos + 10;
            movementCounter++;
        }
        if(key==38){
            chick.ypos = chick.ypos - 10;
            movementCounter++;
        }
        ///////////////////////
        if(key==91){
            mapSpeed--;
            map.dy++;
            chick.dy++;
            log1.dy++;
            log2.dy++;
            barn.dy++;
            for (int i = 0; i < 5; i++) {
                cars[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars2[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars3[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars4[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars5[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars6[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars7[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars8[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars9[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars10[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars11[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars12[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars13[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars14[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars15[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars16[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars17[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars18[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars19[i].dy++;
            }
            for (int i = 0; i < 5; i++) {
                cars20[i].dy++;
            }
            for (int i = 0; i < 3; i++) {
                polarbear[i].dy++;
                polarbear2[i].dy++;

            }
            for (int i = 0; i < 3; i++) {
                logs[i].dy++;
            }
            for (int i = 0; i < 3; i++) {
                logs2[i].dy++;
            }
            for (int i = 0; i < 3; i++) {
                lavaRock[i].dy++;
                lavaRock2[i].dy++;
                lavaRock3[i].dy++;
                lavaRock4[i].dy++;
            }

        }
        if(key==93){
            mapSpeed++;
            map.dy--;
            chick.dy--;
            log1.dy--;
            log2.dy--;
            barn.dy--;
            for (int i = 0; i < 5; i++) {
                cars[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars2[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars3[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars4[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars5[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars6[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars7[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars8[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars9[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars10[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars11[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars12[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars13[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars14[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars15[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars16[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars17[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars18[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars19[i].dy--;
            }
            for (int i = 0; i < 5; i++) {
                cars20[i].dy--;
            }
            for (int i = 0; i < 3; i++) {
                polarbear[i].dy--;
                polarbear2[i].dy--;

            }
            for (int i = 0; i < 3; i++) {
                logs[i].dy--;
            }
            for (int i = 0; i < 3; i++) {
                logs2[i].dy--;
                lavaRock[i].dy--;
                lavaRock2[i].dy--;
                lavaRock3[i].dy--;
                lavaRock4[i].dy--;
            }

        }
        if (key == 83 && hitboxCoutner == false) {
            hitboxCoutner = true;

        }
        if (key == 68 && hitboxCoutner == true) {
            hitboxCoutner = false;
        }
        if (key == 73) {
            Intersection = false;
        }
        if (key == 79) {
            Intersection = true;
        }
        if(key == 32){
            startBool = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + "," + e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
