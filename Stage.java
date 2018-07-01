import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class Stage extends JPanel{

private final int stageX = 0;
private final int stageY = 280;
private final int stageW = 100;
private final int stageH = 20;


    public Stage(){
        revalidate();
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(stageX,stageY,stageW,stageH);
    }

    public int getX(){
        return stageX;
    }
    public int getY(){
        return stageY;
    }
    public int getW(){
        return stageW;
    }
    public int getH(){
        return stageH;
    }
}
