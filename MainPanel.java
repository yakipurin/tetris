import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainPanel extends JPanel implements KeyListener,ActionListener{

public final int WIDTH =  100;
public final int HEIGHT = 300;
private final int DELAY = 10;
//private ArrayList<boolean> touchList;

private Stage stage;
public ArrayList<Puyo> puyoList;
private boolean exist;//ぷよがいるかいないか
private int j = 0;
private int countJ;
private int random;
private int waitcount;

//コンストラクタ
    public MainPanel(){
        setFocusable(true);
        addKeyListener(this);
        setBounds(100,0,WIDTH,HEIGHT);
        this.stage = new Stage();//ステージ生成
        this.puyoList = new ArrayList<Puyo>();
        this.random = (int)(Math.random() * 7 + 1);
        //System.out.println(random);
        this.puyoList.add(new Puyo(random,1));
        this.puyoList.add(new Puyo(random,2));
        this.puyoList.add(new Puyo(random,3));
        this.puyoList.add(new Puyo(random,4));
        new Timer(DELAY, this).start();
        revalidate();
    }


//描画処理
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);                 //背景描画
        this.stage.draw(g);                           //Stage描画
        for(int i = 0;i < this.puyoList.size();i++){ //puyo描画
            this.puyoList.get(i).draw(g);
        }
//キーの受付をこのパネルにフォーカスさせる
        requestFocusInWindow();
    }

//キーイベント処理
    public void keyPressed(KeyEvent evt){

        if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
//右に壁かぷよがないときだけ右に移動する
            boolean touchR = false;
            if(this.puyoList.get(this.j).judgeTouch(new Rectangle(99,0,1,300))
            || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(99,0,1,300))
            || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(99,0,1,300))
            || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(99,0,1,300))){
                touchR = true;
            }
            for(int k = 0; k < this.j;k++){
                if(this.puyoList.get(this.j).judgeTouch(new Rectangle(puyoList.get(k).getX() - 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(puyoList.get(k).getX() - 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(puyoList.get(k).getX() - 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(puyoList.get(k).getX() - 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))){
                    touchR = true;
                }
            }
            if(!touchR){
                this.puyoList.get(this.j).setX(this.puyoList.get(j).getX() + 10);
                this.puyoList.get(this.j + 1).setX(this.puyoList.get(this.j + 1).getX() + 10);
                this.puyoList.get(this.j + 2).setX(this.puyoList.get(this.j + 2).getX() + 10);
                this.puyoList.get(this.j + 3).setX(this.puyoList.get(this.j + 3).getX() + 10);
                System.out.println("右");
            }
        }else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
//左に壁かぷよがない時だけ左に移動する。
            boolean touchL = false;
            if(this.puyoList.get(this.j).judgeTouch(new Rectangle(0,0,1,300))
            || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(0,0,1,300))
            || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(0,0,1,300))
            || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(0,0,1,300))){
                touchL = true;
            }
            for(int k = 0; k < this.j;k++){
                if(this.puyoList.get(this.j).judgeTouch(new Rectangle(puyoList.get(k).getX() + 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(puyoList.get(k).getX() + 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(puyoList.get(k).getX() + 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(puyoList.get(k).getX() + 1,puyoList.get(k).getY(),puyoList.get(k).getW(),puyoList.get(k).getH()))){
                  touchL = true;
                }
            }
            if(!touchL){
                this.puyoList.get(this.j).setX(this.puyoList.get(this.j).getX() - 10);
                this.puyoList.get(this.j + 1).setX(this.puyoList.get(this.j + 1).getX() - 10);
                this.puyoList.get(this.j + 2).setX(this.puyoList.get(this.j + 2).getX() - 10);
                this.puyoList.get(this.j + 3).setX(this.puyoList.get(this.j + 3).getX() - 10);
                System.out.println("左");
            }
        }else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
//下に床かぷよがない時だけ下に高速移動する
            boolean touchU = false;
            if(this.puyoList.get(this.j).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 11,this.stage.getW(),this.stage.getH()))
            || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 11,this.stage.getW(),this.stage.getH()))
            || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 11,this.stage.getW(),this.stage.getH()))
            || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 11,this.stage.getW(),this.stage.getH()))){
                touchU = true;
            }
            for(int k = 0; k < this.j;k++){
                if(this.puyoList.get(this.j).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 11,puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 11,puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 11,puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 11,puyoList.get(k).getW(),puyoList.get(k).getH()))){
                    touchU = true;
                }
            }
            if(!touchU){
                this.puyoList.get(this.j).setY(this.puyoList.get(this.j).getYplus() + 10);
                this.puyoList.get(this.j + 1).setY(this.puyoList.get(this.j + 1).getYplus() + 10);
                this.puyoList.get(this.j + 2).setY(this.puyoList.get(this.j + 2).getYplus() + 10);
                this.puyoList.get(this.j + 3).setY(this.puyoList.get(this.j + 3).getYplus() + 10);
                System.out.println("下高速移動");
            }
        }else if(evt.getKeyCode() == KeyEvent.VK_SPACE){
//回転処理
        Kururi k = new Kururi();
        k.kururin(this.puyoList,this.j);

        }//回転処理終わり
        repaint();

    }//keyPressed end

    public void keyReleased(KeyEvent evte){
    }
    public void keyTyped(KeyEvent evter){
    }


//タイマーで30msごとに床とぷよの接触をチェック
//    public void actionPerformed(ActionEvent e){
//    }
    public void actionPerformed(ActionEvent e){

//ぷよがゆかに触ったら今のぷよタイマーをとめて新ぷよ作成
        if(this.puyoList.get(this.j).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 1,this.stage.getW(),this.stage.getH()))
        || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 1,this.stage.getW(),this.stage.getH()))
        || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 1,this.stage.getW(),this.stage.getH()))
        || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(this.stage.getX(),this.stage.getY() - 1,this.stage.getW(),this.stage.getH()))){

          if(waitcount < 15){
              waitcount++;
          }else{
            this.puyoList.get(this.j).getTimer().stop();
            this.puyoList.get(this.j + 1).getTimer().stop();
            this.puyoList.get(this.j + 2).getTimer().stop();
            this.puyoList.get(this.j + 3).getTimer().stop();

            this.random = (int)(Math.random() * 7 + 1);

            this.puyoList.add(new Puyo(random,1));
            this.puyoList.add(new Puyo(random,2));
            this.puyoList.add(new Puyo(random,3));
            this.puyoList.add(new Puyo(random,4));
            this.j += 4;
//ぷよ消去チェック
            int count = 0;
                for(int i = 0;i < 29;i++,count = 0){
                    for(int l = 0;l < this.puyoList.size();l++){
                        if(this.puyoList.get(l).judgeTouch(new Rectangle(0,i * 10,100,1))){
                            count++;
                            if(count == 10){                 //10個ぷよが同じラインにいたらそれらのぷよを消して現在のぷよのリスト番号を10下げる
                                for(l = 0;l < this.puyoList.size();l++){
                                    if(this.puyoList.get(l).judgeTouch(new Rectangle(0,i * 10,100,1))){
                                        puyoList.remove(l);
                                        l--;
                                    }
                                    else if(this.puyoList.get(l).getY() < i * 10){
                                          this.puyoList.get(l).setY(this.puyoList.get(l).getYplus() + 10);
                                    }
                                }
                                this.j -= 10;
                            }
                        }
                    }
                }
            System.out.println("床に接触");
          waitcount = 0;
          }
        }else{
//ぷよがぷよに落ちたときの停止処理
            for(int k = 0; k < this.j;k++){
//ぷよがぷよに接触したら今のぷよのタイマーを止めて新ぷよを生成し、ぷよリストに入れる。
                if(this.puyoList.get(this.j).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 1,puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 1).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 1,puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 2).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 1,puyoList.get(k).getW(),puyoList.get(k).getH()))
                || this.puyoList.get(this.j + 3).judgeTouch(new Rectangle(puyoList.get(k).getX(),puyoList.get(k).getY() - 1,puyoList.get(k).getW(),puyoList.get(k).getH()))){
                  if(waitcount < 15){
                      waitcount++;
                  }else{
                    this.puyoList.get(this.j).getTimer().stop();
                    this.puyoList.get(this.j + 1).getTimer().stop();
                    this.puyoList.get(this.j + 2).getTimer().stop();
                    this.puyoList.get(this.j + 3).getTimer().stop();
                    if(!this.puyoList.get(this.j).judgeGameOver()){  //ぷよが一番上にあるときは新ぷよを生成しない

                      this.random = (int)(Math.random() * 7 + 1);

                      this.puyoList.add(new Puyo(random,1));
                      this.puyoList.add(new Puyo(random,2));
                      this.puyoList.add(new Puyo(random,3));
                      this.puyoList.add(new Puyo(random,4));

                        this.j += 4;
                        System.out.println("ぷよどうしの接触");
//ぷよ消去チェック
                            int count = 0;
                            for(int i = 0;i < 28;i++,count = 0){
                                for(int l = 0;l < this.puyoList.size();l++){
                                    if(this.puyoList.get(l).judgeTouch(new Rectangle(0,i * 10,100,1))){
                                        count++;
                                        if(count == 10){                 //10個ぷよが同じラインにいたらそれらのぷよを消して現在のぷよのリスト番号を10下げる
                                            for(l = 0;l < this.puyoList.size();l++){
                                                if(this.puyoList.get(l).judgeTouch(new Rectangle(0,i * 10,100,1))){
                                                    puyoList.remove(l);
                                                    l--;
                                                }else if(this.puyoList.get(l).getY() < i * 10){
                                                    this.puyoList.get(l).setY(this.puyoList.get(l).getYplus() + 10);
                                                }
                                            }
                                            this.j -= 10;
                                        }
                                    }
                                }
                            }
                        }
                        waitcount = 0;
                    }
                }
            }
        }
        //消去に関する処理
        repaint();
    }
}
