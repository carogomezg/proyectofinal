/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invader;

import com.sun.javafx.geom.Rectangle;
import com.sun.org.apache.xpath.internal.operations.Gt;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class Invader extends Application {

    
boolean derecha = false;
boolean izquierda=false;
int x=40;
int y=500;

    
    @Override
    public void start(Stage primaryStage) {
      
        Group root = new Group();
        
        Canvas canvas = new Canvas(700,600);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        Image image = new Image(getClass().getResource("rsz_juegoavion.png").toExternalForm());
        Image marcianoVerde = new Image(getClass().getResource("rsz_marcianitoverde.png").toExternalForm());
        
        ArrayList<Marciano> marcianos = new ArrayList<>();
        marcianos.add(new Marciano(40, 50, marcianoVerde));
        
        
        Nave nave = new Nave(x, y, image); 
        scene.setOnKeyPressed(e->{
        switch(e.getCode()){
            //case SPACE: disparar();
            case LEFT: izquierda=true;   break;
            case RIGHT: derecha=true; break;
            case SPACE: nave.disparar(); break;
        }
        });
        
          scene.setOnKeyReleased(e->{
        switch(e.getCode()){
            //case SPACE: disparar();
            case LEFT: izquierda=false;   break;
            case RIGHT: derecha=false; break;
        }
          });
        
        
        GraphicsContext gc = canvas.getGraphicsContext2D();

        System.out.println(image.isError());
        
       
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 700, 600);
                nave.dibujarNave(gc);
                 if (derecha) {
                    nave.moverDerecha(gc);
                }
                 if (izquierda) {
                    nave.moverIzquierda(gc);
                }
             
                ArrayList<Bala> balas = nave.balas;
                   System.out.println(balas.size());
                for(Bala bala : balas){
                    bala.dibujarBala(gc);
                    bala.moverBala();
                    if (bala.posY>600) {
                        balas.remove(bala);
                    }
                }
                
                for(Marciano marciano:marcianos){
                    gc.drawImage(marciano.image,marciano.posX,marciano.posY);
                }
                
               

            }
        }.start();
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

class Nave {
    
    int width;
    int height;
    int posX;
    int posY;
    Image Sprite;
    
   static ArrayList<Bala> balas = new ArrayList<>();

    public Nave(int posX, int posY, Image Sprite) {
        this.posX=posX;
        this.posY = posY;
        this.Sprite = Sprite;
    }
    
    public void moverDerecha(GraphicsContext gc){
        this.posX+=4;
        gc.drawImage(Sprite, posX, posY);
        
    }
    
     public void moverIzquierda(GraphicsContext gc){
        this.posX-=4;
        gc.drawImage(Sprite, posX, posY);
        
    }
     
     public void  dibujarNave(GraphicsContext gc){
         gc.drawImage(Sprite, posX, posY);
     }
     
     public void disparar(){
         balas.add(new Bala(posX,posY));
     }
    
    public ArrayList<Bala> getBalas(){
        return balas; 
    }
    
    
}

class Marciano{
    
    int posX;
    int posY;
    int width;
    int height;
    Image image;
    
    public Marciano(int X, int Y,Image image) {
        this.posX = X;
        this.posY = Y;
        this.image =image;
        height= (int)image.getHeight();
        width= (int)image.getWidth();
    }
    
    public Rectangle getBordes(){
         return new Rectangle(posX, posY, width, height);
     }

}


class Bala{

    int posX;
    int posY;
    int width =10;
    int speed =3;
    int height =15;
    
    
    public Bala(int x, int y) {
        this.posX=x;
        this.posY =y+3;
      
    }
    
    public  void dibujarBala(GraphicsContext gc){
        gc.setFill(Color.BLUE);
        gc.fillRect(posX, posY, width, height);
        
    }
    
    public void moverBala(){
        if (posY< 600) {
            this.posY-=speed;
           
        }
        
       
    }
    
    public Rectangle getBordes(){
         return new Rectangle(posX, posY, width, height);
     }
    
}