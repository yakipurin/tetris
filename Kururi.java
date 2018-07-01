import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Kururi{
    private ArrayList<Puyo> puyoList;
    private int j;
    private int i;
    private int touchCount = 0;
    private Stage stage;
    private Rectangle puyoRectangle;


    public void kururin(ArrayList<Puyo> puyoList, int j){
        this.puyoList = puyoList;
        this.j = j;
        stage = new Stage();


        for(int count = 0;count < 4;this.j++,count++){
            switch(this.puyoList.get(this.j).getKururiPattern()){
                case 1:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() + 10,this.puyoList.get(this.j).getY() - 10,10,10);
                        break;
                    case 2:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() + 10,this.puyoList.get(this.j).getY() + 10,10,10);
                        break;
                    case 3:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() - 10,this.puyoList.get(this.j).getY() + 10,10,10);
                        break;
                    case 4:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() - 10,this.puyoList.get(this.j).getY() - 10,10,10);
                        break;
                }
                break;
                case 2:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX(),this.puyoList.get(this.j).getY() - 20,10,10);
                        break;
                    case 2:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() + 20,this.puyoList.get(this.j).getY(),10,10);
                        break;
                    case 3:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX(),this.puyoList.get(this.j).getY() + 20,10,10);
                        break;
                    case 4:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() - 20,this.puyoList.get(this.j).getY(),10,10);
                        break;
                }
                break;
                case 3:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() + 20,this.puyoList.get(this.j).getY() - 20,10,10);
                        break;
                    case 2:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() + 20,this.puyoList.get(this.j).getY() + 20,10,10);
                        break;
                    case 3:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() - 20,this.puyoList.get(this.j).getY() + 20,10,10);
                        break;
                    case 4:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() - 20,this.puyoList.get(this.j).getY() - 20,10,10);
                        break;
                }
                break;
                case 4:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX(),this.puyoList.get(this.j).getY() - 10,10,10);
                        break;
                    case 2:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX(),this.puyoList.get(this.j).getY() + 10,10,10);
                        break;
                }
                break;
                case 5:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() + 20,this.puyoList.get(this.j).getY() - 10,10,10);
                        break;
                    case 2:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() - 20,this.puyoList.get(this.j).getY() + 10,10,10);
                        break;
                }
                break;
                case 6:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() + 20,this.puyoList.get(this.j).getY() + 10,10,10);
                        break;
                    case 2:
                        puyoRectangle = new Rectangle(this.puyoList.get(this.j).getX() - 20,this.puyoList.get(this.j).getY() - 10,10,10);
                        break;
                }
                break;
                default:puyoRectangle = new Rectangle(0,0,0,0);
            }
            //回転先の場所になにかあったらカウント＋
            for(this.i = 0;this.i < this.j - count;this.i++){
      //        System.out.println(this.puyoList.get(this.i).judgeTouch(puyoRectangle));
      //        System.out.println(this.puyoList.get(this.i).getX());
      //        System.out.println(this.puyoList.get(this.i).getY());
      //        System.out.println(puyoRectangle.getX());
      //        System.out.println(puyoRectangle.getY());


                if(this.puyoList.get(this.i).judgeTouch(puyoRectangle)){
                    touchCount++;
                }
          //      System.out.println("i=" + this.i);
            }
            if(new Rectangle(-1,0,1,300).intersects(puyoRectangle)){
                touchCount++;
            }
            if(new Rectangle(101,0,1,300).intersects(puyoRectangle)){
                touchCount++;
            }
            if(new Rectangle(this.stage.getX(),this.stage.getY(),this.stage.getW(),this.stage.getH()).intersects(puyoRectangle)){
                touchCount++;
            }

        }

        this.j -= 4;
//System.out.println("---------------------touchCount:" + touchCount);

    if(touchCount == 0){
//回転実行
      //  System.out.println("実行時のj" + this.j);
        for(int count = 0;count < 4;this.j++,count++){
            switch(this.puyoList.get(this.j).getKururiPattern()){
                case 1:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() + 10);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                         break;
                    case 2:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() + 10);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 3:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 10);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 4:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 10);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() - 3);
                        break;
                }
                break;
                case 2:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 2:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() + 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 3:
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 4:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() - 3);
                        break;
                }
                break;
                case 3:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() + 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 2:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() + 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 3:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 4:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 20);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() - 3);
                        break;
                }
                break;
                case 4:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 2:
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() - 1);
                        break;
                }
                break;
                case 5:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() + 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 2:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() - 1);
                        break;
                }
                break;
                case 6:
                switch(this.puyoList.get(this.j).getCountKururi()){
                    case 1:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() + 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() + 1);
                        break;
                    case 2:
                        this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 20);
                        this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() - 10);
                        this.puyoList.get(this.j).setCountKururi(this.puyoList.get(this.j).getCountKururi() - 1);
                        break;
                }
                break;
            }
        }
    }
    }
}
