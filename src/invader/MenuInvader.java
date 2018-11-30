/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Caro
 */
public class MenuInvader extends Application {
    
    Image vida = new Image(getClass().getResource("rsz_vida.png").toExternalForm());
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        primaryStage.setTitle("Forma de Pago");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(400);
        
        StackPane root = new StackPane();
        root.setId("pane2"); 
        
        Scene scene = new Scene(root);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setPadding(new Insets(15, 15, 15, 5));
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
