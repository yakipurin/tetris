import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {

    public static void main(String[] args){
        Tetris frm = new Tetris();
        frm.setTitle("title");
        frm.setBounds(0,0,400,400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        MainPanel mpn = new MainPanel();
        frm.getContentPane().add(mpn);
        //MainP mpn = new MainP();
        //frm.getContentPane().add(mpn);
    }
}
