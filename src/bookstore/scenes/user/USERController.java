/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.scenes.user;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Authors;
import models.Books;
import models.Customers;

/**
 * FXML Controller class
 *
 * @author jakub
 */
public class USERController implements Initializable {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookstorePU");
    EntityManager em = emf.createEntityManager();
    

    @FXML
    private Button btnOrder;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnMyOrders;
    @FXML
    private Label lblCartPrice;
    @FXML
    private Label lblHello;
    
    @FXML
    private TableView<Books> tableBooks;
    @FXML
    private TableColumn<Books, String> columnIsbn;
    @FXML
    private TableColumn<Books, String> columnTitle;
    @FXML
    private TableColumn<Books, String> columnAuthor;
    @FXML
    private TableColumn<Books, String> columnPublisher;
    @FXML
    private TableColumn<Books, String> columnType;
    @FXML
    private TableColumn<Books, String> columnRealaseDate;
    @FXML
    private TableColumn<Books, Integer> columnQuantity;
    @FXML
    private TableColumn<Books, Double> columnPrice;
    
    @FXML
    private TableView<?> tableCart;
    @FXML
    private TableColumn<?, ?> columnCartTitle;
    @FXML
    private TableColumn<?, ?> columnCartPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Customers> login = em.createNativeQuery("select * from customers where is_login", Customers.class).getResultList();
            
            LocalDate date = LocalDate.now();
            lblHello.setText("Cześć " + login.get(0).getName() + ", dzisiaj jest " + date);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        showDataBooks();
    }    

    private void showDataBooks() {
        List<Books> books = em.createNativeQuery("select * from books", Books.class).getResultList();
        ObservableList<Books> obsBooks = FXCollections.observableList(books);
        
        columnIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAuthor.setCellValueFactory((cell) -> {
            SimpleStringProperty name = new SimpleStringProperty(new SimpleStringProperty(cell.getValue().getAuthor().getName()).get() + " "
                    + new SimpleStringProperty(cell.getValue().getAuthor().getLastname()).get());
            return name;
        });
        columnPublisher.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPublisher().getName()));
        columnType.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getType().getName()));
        columnRealaseDate.setCellValueFactory(new PropertyValueFactory<>("release_date"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity_available"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableBooks.setItems(obsBooks);
    }
    
    @FXML
    private void handleBtnOrder(ActionEvent event) {
    }

    @FXML
    private void handleBtnDelete(ActionEvent event) {
    }

    @FXML
    private void handleBtnClear(ActionEvent event) {
    }

    @FXML
    private void handleBtnLogout(ActionEvent event) {
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.close();
        try{
            openScene("login");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    @FXML
    private void handleBtnMyOrders(ActionEvent event) {
    }
    
    private void openScene(String name) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("/bookstore/scenes/" + name + "/" + name.toUpperCase() + ".fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
