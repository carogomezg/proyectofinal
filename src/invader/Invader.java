/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invader;

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.Shape;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javax.swing.text.html.CSS;


public class Invader extends Application {

    static int n=0;
boolean derecha = false;
boolean izquierda=false;
int x=40;
int y=500;
  
  
  Image avion = new Image(getClass().getResource("rsz_avion.png").toExternalForm());
  Image marcianoAmarillo = new Image(getClass().getResource("rsz_marcianitoamarillo.png").toExternalForm());
  Image marcianoRosa = new Image(getClass().getResource("rsz_marcianitorosa.png").toExternalForm());
  Image marcianoAzul = new Image(getClass().getResource("rsz_marcianitoazul.png").toExternalForm());
  Image marcianoRojo = new Image(getClass().getResource("rsz_marcianitorojo.png").toExternalForm());
  Image marcianoVerde = new Image(getClass().getResource("rsz_marcianitoverde.png").toExternalForm());
  Image vida = new Image(getClass().getResource("rsz_vida.png").toExternalForm());
  

 public void agregarMarcianos(ArrayList<Marciano> marcianos){
     
        marcianos.add(new Marciano(72, 150, marcianoAmarillo));
        marcianos.add(new Marciano(104, 150, marcianoAmarillo));
        marcianos.add(new Marciano(140, 150, marcianoAmarillo));
        marcianos.add(new Marciano(72, 186, marcianoAmarillo));
        marcianos.add(new Marciano(104, 186, marcianoAmarillo));
        marcianos.add(new Marciano(140, 186, marcianoAmarillo));
        marcianos.add(new Marciano(72, 222, marcianoAmarillo));
        marcianos.add(new Marciano(104, 222, marcianoAmarillo));
        marcianos.add(new Marciano(140, 222, marcianoAmarillo));
        marcianos.add(new Marciano(72, 258, marcianoAmarillo));
        marcianos.add(new Marciano(104, 258, marcianoAmarillo));
        marcianos.add(new Marciano(140, 258, marcianoAmarillo));
        marcianos.add(new Marciano(72, 294, marcianoAmarillo));
        marcianos.add(new Marciano(104, 294, marcianoAmarillo));
        marcianos.add(new Marciano(140, 294, marcianoAmarillo));
        marcianos.add(new Marciano(72, 330, marcianoAmarillo));
        marcianos.add(new Marciano(104, 330, marcianoAmarillo));
        marcianos.add(new Marciano(140, 330, marcianoAmarillo));
        marcianos.add(new Marciano(72, 366, marcianoAmarillo));
        marcianos.add(new Marciano(104, 366, marcianoAmarillo));
        marcianos.add(new Marciano(140, 366, marcianoAmarillo));
        
        
        marcianos.add(new Marciano(220, 150, marcianoRosa));
        marcianos.add(new Marciano(252, 150, marcianoRosa));
        marcianos.add(new Marciano(283, 150, marcianoRosa));
        marcianos.add(new Marciano(220, 186, marcianoRosa));
        marcianos.add(new Marciano(252, 186, marcianoRosa));
        marcianos.add(new Marciano(283, 186, marcianoRosa));
        marcianos.add(new Marciano(220, 222, marcianoRosa));
        marcianos.add(new Marciano(252, 222, marcianoRosa));
        marcianos.add(new Marciano(283, 222, marcianoRosa));
        marcianos.add(new Marciano(220, 258, marcianoRosa));
        marcianos.add(new Marciano(252, 258, marcianoRosa));
        marcianos.add(new Marciano(283, 258, marcianoRosa));
        marcianos.add(new Marciano(220, 294, marcianoRosa));
        marcianos.add(new Marciano(252, 294, marcianoRosa));
        marcianos.add(new Marciano(283, 294, marcianoRosa));
        marcianos.add(new Marciano(220, 330, marcianoRosa));
        marcianos.add(new Marciano(252, 330, marcianoRosa));
        marcianos.add(new Marciano(283, 330, marcianoRosa));
        marcianos.add(new Marciano(220, 366, marcianoRosa));
        marcianos.add(new Marciano(252, 366, marcianoRosa));
        marcianos.add(new Marciano(283, 366, marcianoRosa));
        
        
        marcianos.add(new Marciano(359, 150, marcianoAzul));
        marcianos.add(new Marciano(395, 150, marcianoAzul));
        marcianos.add(new Marciano(431, 150, marcianoAzul));
        marcianos.add(new Marciano(359, 186, marcianoAzul));
        marcianos.add(new Marciano(395, 186, marcianoAzul));
        marcianos.add(new Marciano(431, 186, marcianoAzul));
        marcianos.add(new Marciano(359, 222, marcianoAzul));
        marcianos.add(new Marciano(395, 222, marcianoAzul));
        marcianos.add(new Marciano(431, 222, marcianoAzul));
        marcianos.add(new Marciano(359, 258, marcianoAzul));
        marcianos.add(new Marciano(395, 258, marcianoAzul));
        marcianos.add(new Marciano(431, 258, marcianoAzul));
        marcianos.add(new Marciano(359, 294, marcianoAzul));
        marcianos.add(new Marciano(395, 294, marcianoAzul));
        marcianos.add(new Marciano(431, 294, marcianoAzul));
        marcianos.add(new Marciano(359, 330, marcianoAzul));
        marcianos.add(new Marciano(395, 330, marcianoAzul));
        marcianos.add(new Marciano(431, 330, marcianoAzul));
        marcianos.add(new Marciano(359, 366, marcianoAzul));
        marcianos.add(new Marciano(395, 366, marcianoAzul));
        marcianos.add(new Marciano(431, 366, marcianoAzul));
        
        
        marcianos.add(new Marciano(513, 150, marcianoRojo));
        marcianos.add(new Marciano(549, 150, marcianoRojo));
        marcianos.add(new Marciano(585, 150, marcianoRojo));
        marcianos.add(new Marciano(513, 186, marcianoRojo));
        marcianos.add(new Marciano(549, 186, marcianoRojo));
        marcianos.add(new Marciano(585, 186, marcianoRojo));
        marcianos.add(new Marciano(513, 222, marcianoRojo));
        marcianos.add(new Marciano(549, 222, marcianoRojo));
        marcianos.add(new Marciano(585, 222, marcianoRojo));
        marcianos.add(new Marciano(513, 258, marcianoRojo));
        marcianos.add(new Marciano(549, 258, marcianoRojo));
        marcianos.add(new Marciano(585, 258, marcianoRojo));
        marcianos.add(new Marciano(513, 294, marcianoRojo));
        marcianos.add(new Marciano(549, 294, marcianoRojo));
        marcianos.add(new Marciano(585, 294, marcianoRojo));
        marcianos.add(new Marciano(513, 330, marcianoRojo));
        marcianos.add(new Marciano(549, 330, marcianoRojo));
        marcianos.add(new Marciano(585, 330, marcianoRojo));
        marcianos.add(new Marciano(513, 366, marcianoRojo));
        marcianos.add(new Marciano(549, 366, marcianoRojo));
        marcianos.add(new Marciano(585, 366, marcianoRojo));
       
        
        marcianos.add(new Marciano(665, 150, marcianoVerde));
        marcianos.add(new Marciano(701, 150, marcianoVerde));
        marcianos.add(new Marciano(737, 150, marcianoVerde));
        marcianos.add(new Marciano(665, 186, marcianoVerde));
        marcianos.add(new Marciano(701, 186, marcianoVerde));
        marcianos.add(new Marciano(737, 186, marcianoVerde));
        marcianos.add(new Marciano(665, 222, marcianoVerde));
        marcianos.add(new Marciano(701, 222, marcianoVerde));
        marcianos.add(new Marciano(737, 222, marcianoVerde));
        marcianos.add(new Marciano(665, 258, marcianoVerde));
        marcianos.add(new Marciano(701, 258, marcianoVerde));
        marcianos.add(new Marciano(737, 258, marcianoVerde));
        marcianos.add(new Marciano(665, 294, marcianoVerde));
        marcianos.add(new Marciano(701, 294, marcianoVerde));
        marcianos.add(new Marciano(737, 294, marcianoVerde));
        marcianos.add(new Marciano(665, 330, marcianoVerde));
        marcianos.add(new Marciano(701, 330, marcianoVerde));
        marcianos.add(new Marciano(737, 330, marcianoVerde));
        marcianos.add(new Marciano(665, 366, marcianoVerde));
        marcianos.add(new Marciano(701, 366, marcianoVerde));
        marcianos.add(new Marciano(737, 366, marcianoVerde));
        
        
}
 public void NuevoJuego(Stage stage){
     
        StackPane root = new StackPane();
        root.setId("pane"); 
        
 
        Canvas canvas = new Canvas(800,600);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        canvas.setOpacity(1);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        root.getChildren().add(grid);
        //grid.setId("pane");
        
        Label score = new Label("SCORE:");
        score.setId("score");
        grid.add(score, 0, 0);
        score.setFont(Font.font("Sitka Small", FontWeight.BOLD, 24));
        
        Label lifes = new Label("LIFES:");
        lifes.setId("lifes");
        grid.add(lifes, 38, 0);
        lifes.setFont(Font.font("Sitka Small", FontWeight.BOLD, 24));
        
      
        ArrayList<Marciano> marcianos = new ArrayList<>();
                agregarMarcianos(marcianos);
   
            ArrayList<Vida> vidas = new ArrayList<>();
            vidas.add(new Vida(590, 23, vida));
             vidas.add(new Vida(620, 23, vida));
              vidas.add(new Vida(650, 23, vida));
               vidas.add(new Vida(680, 23, vida));
                vidas.add(new Vida(710, 23, vida));
     
    
                
        Nave nave = new Nave(400, 500, avion); 
        scene.setOnKeyPressed(e->{
        switch(e.getCode()){
            //case SPACE: disparar();
            case LEFT: izquierda=true; break;
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
        
        //System.out.println(image.isError());
        
        
       
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 900, 700);
                
                
                nave.dibujarNave(gc);
                 if (derecha) {
                    
                    nave.moverDerecha(gc);
                }
                 if (izquierda) {
                    nave.moverIzquierda(gc);
                }
             
                  
                
                for(Marciano marciano:marcianos){
                    gc.drawImage(marciano.image,marciano.posX,marciano.posY);
                    marciano.moverMarciano(n);
                }
                n++;
                  ArrayList<Bala> balas = nave.balas;      
                 
                  for (Bala bala : balas) {
                     if (bala.valid) {     
                     bala.dibujarBala(gc);
                     bala.moverBala();
                     
                     }else{
                         balas.remove(bala);
                     System.out.println(balas.size());
                     }                    
                 }
                 for (Bala bala : balas) {
                     for (Marciano marciano : marcianos) {
                         if (marciano.getBordes().contains(bala.posX,bala.posY)) {
                             balas.remove(bala);
                             marcianos.remove(marciano);
                             System.out.println("collision");
                         }
                     }
                }
               
                 
                 gc.strokeText("Score", 100, 70);
                 for (Vida vida : vidas) {
                    gc.drawImage(vida.image, vida.posX, vida.posY);
                }
     

            }
        }.start();
        
        scene.getStylesheets().add(Invader.class.getResource("fondo.css").toExternalForm());
        stage.setScene(scene); //agregacion al escenario
        stage.show(); //mostrar
 }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(400);
        
        StackPane root = new StackPane();
        root.setId("pane2"); 
        
        Scene scene = new Scene(root);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setPadding(new Insets(15, 15, 15, 15));
        root.getChildren().add(grid);
        
        Label title = new Label();
        Image imagen = new Image(new FileInputStream("C:\\Users\\carog\\Downloads\\rsz_fondo.png"));
        grid.add(title, 0, 0);
        title.setGraphic(new ImageView(imagen));
       
        Button playgame = new Button();
        playgame.setPadding(Insets.EMPTY);
        Image imagen3 = new Image(new FileInputStream("C:\\Users\\carog\\Downloads\\rsz_pg.png"));
        grid.add(playgame, 0, 2);
        playgame.setGraphic(new ImageView(imagen3));
        playgame.setId("pg");
        playgame.setOnAction(action->{NuevoJuego(primaryStage);});
        
        Button score = new Button();
        score.setPadding(Insets.EMPTY);
        Image imagen4 = new Image(new FileInputStream("C:\\Users\\carog\\Downloads\\rsz_hs4.png"));
        grid.add(score, 0, 3);
        score.setGraphic(new ImageView(imagen4));
        score.setId("pg");
        
        Label marcianitos = new Label();
        Image imagen5 = new Image(new FileInputStream("C:\\Users\\carog\\Downloads\\rsz_jiji2.png"));
        grid.add(marcianitos, 0, 4);
        marcianitos.setGraphic(new ImageView(imagen5));
        
        Media media = new Media(getClass().getResource("musica.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        
        scene.getStylesheets().add(MenuInvader.class.getResource("fondo.css").toExternalForm());
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
        if (posX!=740) {
               this.posX+=4;
        gc.drawImage(Sprite, posX, posY);
        
        }
     
    }
    
     public void moverIzquierda(GraphicsContext gc){
         if (posX!=0) {
                 this.posX-=4;
        gc.drawImage(Sprite, posX, posY);
         }
    
        
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
    double speed=1;
    int posX;
    int posY;
    static int width =30;
   static int height=30;
    Image image;
    
    public void moverMarciano(int n){
          
           if (n%50==0) {//cambia el 125 por si quieres cambiar los limites
             speed= -speed;
             this.posY+=3; 
         
              
           }
           this.posX+=speed;
  
            }

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
    static int width =4;
    int speed =3;
    static int height =10;
    boolean valid =true;

   
    public Bala(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    
    
    public  void dibujarBala(GraphicsContext gc){
        gc.setFill(Color.ORANGE);
        gc.fillRect(posX, posY, width, height);
        
    }
    
    public void moverBala(){
        if (posY>10) {
            this.posY-=speed;
           
        }else{
            valid =false;
        }
    }
    
    
    
    public Rectangle getBordes(){
         return new Rectangle(posX, posY, width, height);
     }
    
}