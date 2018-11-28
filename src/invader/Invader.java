/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invader;

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.Shape;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.geometry.Rectangle2D;
import javax.swing.text.html.CSS;


public class Invader extends Application {

    
boolean derecha = false;
boolean izquierda=false;
int x=40;
int y=500;

  Image image = new Image(getClass().getResource("rsz_juegoavion.png").toExternalForm());
  Image marcianoVerde = new Image(getClass().getResource("rsz_marcianitoverde.png").toExternalForm());
  
  Image vida = new Image(getClass().getResource("rsz_vida.png").toExternalForm());


    
  
 public void agregarMarcianos(ArrayList<Marciano> marcianos){
        marcianos.add(new Marciano(70, 150, marcianoVerde));
        marcianos.add(new Marciano(250, 150, marcianoVerde));
        marcianos.add(new Marciano(150, 150, marcianoVerde));
        
        
        marcianos.add(new Marciano(70,  200, marcianoVerde));
        marcianos.add(new Marciano(250, 200, marcianoVerde));
        marcianos.add(new Marciano(150, 200, marcianoVerde));
        
        
        marcianos.add(new Marciano(70, 250, marcianoVerde));
        marcianos.add(new Marciano(250, 250, marcianoVerde));
        marcianos.add(new Marciano(150, 250, marcianoVerde));
        
        
        marcianos.add(new Marciano(70,  300, marcianoVerde));
        marcianos.add(new Marciano(250, 300, marcianoVerde));
        marcianos.add(new Marciano(150, 300, marcianoVerde));
        
        
        marcianos.add(new Marciano(70,  350, marcianoVerde));
        marcianos.add(new Marciano(250, 350, marcianoVerde));
        marcianos.add(new Marciano(150, 350, marcianoVerde));   
}
    
    @Override
    public void start(Stage primaryStage) {
      
        Group root = new Group();
        
        Canvas canvas = new Canvas(700,600);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        canvas.setOpacity(1);
      
        ArrayList<Marciano> marcianos = new ArrayList<>();
                agregarMarcianos(marcianos);
   
            ArrayList<Vida> vidas = new ArrayList<>();
            vidas.add(new Vida(200, 50, vida));
             vidas.add(new Vida(350, 50, vida));
              vidas.add(new Vida(300, 50, vida));
               vidas.add(new Vida(250, 50, vida));
                
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
        
        
        ArrayList<Bala> balas = nave.balas;
        
        Bala balapointer;
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
             
                  
                
                for(Marciano marciano:marcianos){
                    gc.drawImage(marciano.image,marciano.posX,marciano.posY);
                }
                       
                 for (Bala bala : balas) {
                     if (bala.valid) {     
                     bala.dibujarBala(gc);
                     bala.moverBala();
                         System.out.println(balas.size());
                     }else{
                         balas.remove(bala);
                     System.out.println(balas.size());

                     }
                     
                 }
                 
                 gc.strokeText("Score", 100, 70);
                 for (Vida vida : vidas) {
                    gc.drawImage(vida.image, vida.posX, vida.posY);
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

class Vida{
    int posX;
    int posY;
    
    Image image;

    public Vida(int posX, int posY, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.image = image;
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
    static int width;
   static int height;
    Image image;

    public Marciano(int x, int y,Image image) {
       posX=x;
       posY=y;
        this.image=image;
    }
    
    
    public Rectangle getBordes(){
         return new Rectangle(posX, posY, width, height);
     }

}


class Bala{

    int posX;
    int posY;
    static int width =10;
    int speed =3;
   static int height =15;
    boolean valid =true;

    public Bala(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    
    
    public  void dibujarBala(GraphicsContext gc){
        gc.setFill(Color.BLUE);
        gc.fillRect(posX, posY, width, height);
        
    }
    
    public void moverBala(){
        if (posY>10) {
            this.posY-=speed;
           
        }else{
            valid =false;
        }
        
       
    }
    
   // public Rectangle getBordes(){
     //    return new Rectangle(posX, posY, width, height);
     //}
    
}