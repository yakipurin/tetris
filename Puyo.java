import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class Puyo extends JPanel implements ActionListener{

    private int puyoX = 0;
    private int puyoY = 0;
    private int puyoYplus = 0;
    private int puyoW = 10;
    private int puyoH = 10;
    private int puyoType;
    private int sec = 0;
    private final int DELAY = 500;
    private Timer timer;
    private int countKururi = 1;
    private int kururiPattern = 0;
    private int puyoNum;

    public Puyo(){
        this.timer = new Timer(500, this);
        timer.start();
        revalidate();
    }

    public Puyo(int puyoType,int puyoNum){
        this.puyoType = puyoType;
        switch(puyoType){
        case 1:
            switch(puyoNum){
                case 1:
                    this.puyoX = 40;
                    this.puyoYplus = 0;
                    break;
                case 2:
                    this.puyoX = 50;
                    this.puyoYplus = 0;
                    break;
                case 3:
                    this.puyoX = 40;
                    this.puyoYplus = 10;
                    break;
                case 4:
                    this.puyoX = 50;
                    this.puyoYplus = 10;
                    break;
            }
            break;
        case 2:
            switch(puyoNum){
                case 1:
                    this.puyoX = 40;
                    this.puyoYplus = 0;
                    this.kururiPattern = 1;
                    break;
                case 2:
                    this.puyoX = 50;
                    this.puyoYplus = 0;
                    break;
                case 3:
                    this.puyoX = 60;
                    this.puyoYplus = 0;
                    this.countKururi = 3;
                    this.kururiPattern = 1;

                    break;
                case 4:
                    this.puyoX = 50;
                    this.puyoYplus = 10;
                    this.countKururi = 4;
                    this.kururiPattern = 1;

                    break;
            }
            break;
        case 3:
            switch(puyoNum){
                case 1:
                    this.puyoX = 40;
                    this.puyoYplus = 0;
                    this.kururiPattern = 1;
                    break;
                case 2:
                    this.puyoX = 50;
                    this.puyoYplus = 0;
                    break;
                case 3:
                    this.puyoX = 60;
                    this.puyoYplus = 0;
                    this.countKururi = 3;
                    this.kururiPattern = 1;
                    break;
                case 4:
                    this.puyoX = 60;
                    this.puyoYplus = 10;
                    this.countKururi = 4;
                    this.kururiPattern = 2;
                    break;
            }
            break;
        case 4:
            switch(puyoNum){
                case 1:
                    this.puyoX = 40;
                    this.puyoYplus = 0;
                    this.kururiPattern = 1;
                    break;
                case 2:
                    this.puyoX = 50;
                    this.puyoYplus = 0;
                    break;
                case 3:
                    this.puyoX = 60;
                    this.puyoYplus = 0;
                    this.countKururi = 3;
                    this.kururiPattern = 1;
                    break;
                case 4:
                    this.puyoX = 40;
                    this.puyoYplus = 10;
                    this.kururiPattern = 2;
                    break;
            }
            break;
        case 5:
            switch(puyoNum){
                case 1:
                    this.puyoX = 40;
                    this.puyoYplus = 0;
                    this.kururiPattern = 5;
                    break;
                case 2:
                    this.puyoX = 50;
                    this.puyoYplus = 0;
                    break;
                case 3:
                    this.puyoX = 50;
                    this.puyoYplus = 10;
                    break;
                case 4:
                    this.puyoX = 60;
                    this.puyoYplus = 10;
                    this.countKururi = 1;
                    this.kururiPattern = 4;
                    break;
            }
            break;
        case 6:
            switch(puyoNum){
                case 1:
                    this.puyoX = 50;
                    this.puyoYplus = 0;
                    break;
                case 2:
                    this.puyoX = 60;
                    this.puyoYplus = 0;
                    this.kururiPattern = 4;
                    this.countKururi = 2;
                    break;
                case 3:
                    this.puyoX = 40;
                    this.puyoYplus = 10;
                    this.kururiPattern = 6;
                    break;
                case 4:
                    this.puyoX = 50;
                    this.puyoYplus = 10;
                    break;
            }
            break;
        case 7:
            switch(puyoNum){
                case 1:
                    this.puyoX = 40;
                    this.puyoYplus = 0;
                    this.kururiPattern = 1;
                    break;
                case 2:
                    this.puyoX = 50;
                    this.puyoYplus = 0;
                    break;
                case 3:
                    this.puyoX = 60;
                    this.puyoYplus = 0;
                    this.countKururi = 3;
                    this.kururiPattern = 1;
                    break;
                case 4:
                    this.puyoX = 70;
                    this.puyoYplus = 0;
                    this.kururiPattern = 3;
                    this.countKururi = 3;
                    break;
            }
            break;
        }

    this.timer = new Timer(DELAY, this);
    timer.start();
    revalidate();
    }

    public void draw(Graphics g){
        this.puyoY = sec * 10 + puyoYplus;
        switch(this.puyoType){
            case 1:
            g.setColor(Color.RED);
            break;
            case 2:
            g.setColor(Color.BLUE);
            break;
            case 3:
            g.setColor(Color.YELLOW);
            break;
            case 4:
            g.setColor(Color.PINK);
            break;
            case 5:
            g.setColor(Color.ORANGE);
            break;
            case 6:
            g.setColor(Color.WHITE);
            break;
            case 7:
            g.setColor(Color.GRAY);
            break;
        }
        g.drawRect(puyoX,puyoY,puyoW,puyoH);
    }

    public void actionPerformed(ActionEvent evt) {
        sec++;
        System.out.println("時間下移動");
    }

    public boolean judgeTouch(Rectangle r){
        Rectangle puyoRec = new Rectangle(puyoX,puyoY,puyoW,puyoH);
        if(puyoRec.intersects(r)){
            return true;
        }else{
            return false;
        }
    }

//横長の薄い長方形とぷよの交差をみて、MainPanelが新しいぷよを創るのを止める
    public boolean judgeGameOver(){
        Rectangle gameOver = new Rectangle(1,1,300,1);
        Rectangle puyoRec = new Rectangle(this.puyoX,this.puyoY,this.puyoW,this.puyoH);
        if(puyoRec.intersects(gameOver)){
            return true;
        }else{
            return false;
        }
    }

    public Timer getTimer(){
        return this.timer;
    }
    public int getX(){
        return this.puyoX;
    }
    public int getY(){
        return this.puyoY;
    }
    public int getYplus(){
        return this.puyoYplus;
    }
    public int getW(){
        return this.puyoW;
    }
    public int getH(){
        return this.puyoH;
    }
    public int getPuyoType(){
        return this.puyoType;
    }
    public int getPuyoNum(){
        return this.puyoNum;
    }
    public int getCountKururi(){
        return this.countKururi;
    }
    public int getKururiPattern(){
        return this.kururiPattern;
    }

    public void setCountKururi(int countKururi){
        this.countKururi = countKururi;
    }
    public void setX(int puyoX){
        this.puyoX = puyoX;
    }
    public void setY(int puyoYplus){
        this.puyoYplus = puyoYplus;
    }

}
