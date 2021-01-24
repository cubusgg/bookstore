/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jakub
 */
public class Bookstore extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/bookstore/scenes/login/LOGIN.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        // TWORZENIE BAZY DANYCH
        // By to zadziałało w pliku hibernate.cfg.xml właściwość hibernate.hbm2ddl.auto trzeba ustawić na create
        //CommDB database = new CommDB();
        //database.createDB();
        

        launch(args);
    }

}
