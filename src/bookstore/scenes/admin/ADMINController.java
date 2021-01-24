/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.scenes.admin;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleLongProperty;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.*;

/**
 * FXML Controller class
 *
 * @author jakub
 */
public class ADMINController implements Initializable {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookstorePU");
    EntityManager em = emf.createEntityManager();

    @FXML
    private Button btnCustomers;
    @FXML
    private Label lblHello;
    @FXML
    private Label labelHeader;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnBooks;
    @FXML
    private Button btnAuthors;
    @FXML
    private Button btnPublishers;
    @FXML
    private Button btnTypes;
    @FXML
    private Button btnLogout;
    
    
    @FXML
    private Pane paneCustomers;
    @FXML
    private TableView<Customers> tableCustomers;
    @FXML
    private TableColumn<Customers, String> columnIdCustomer;
    @FXML
    private TableColumn<Customers, String> columnEmail;
    @FXML
    private TableColumn<Customers, String> columnPassword;
    @FXML
    private TableColumn<Customers, String> columnName;
    @FXML
    private TableColumn<Customers, String> columnLastname;
    @FXML
    private TableColumn<Customers, String> columnPhone;
    @FXML
    private TableColumn<Customers, String> columnCity;
    @FXML
    private TableColumn<Customers, String> columnStreet;
    @FXML
    private TableColumn<Customers, String> columnHouseNumber;
    @FXML
    private TableColumn<Customers, String> columnZipcode;
    @FXML
    private TableColumn<Customers, String> columnVoivodeship;
    @FXML
    private TableColumn<Customers, Boolean> columnAdmin;
    @FXML
    private TableColumn<Customers, Boolean> columnIsLogin;
    
    @FXML
    private Pane paneOrders;
    @FXML
    private TableView<Orders> tableOrders;
    @FXML
    private TableColumn<Orders, String> columnIdOrder;
    @FXML
    private TableColumn<Orders, String> columnImplementationStage;
    @FXML
    private TableColumn<Orders, String> columnOrderDate;
    @FXML
    private TableColumn<Orders, String> columnCustomerOrder;
    
    @FXML
    private Pane paneBooks;
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
    private TableColumn<Books, String> columnQuantity;
    @FXML
    private TableColumn<Books, String> columnPrice;
    
    @FXML
    private Pane paneAuthors;
    @FXML
    private TableView<Authors> tableAuthors;
    @FXML
    private TableColumn<Authors, String> columnIdAuthor;
    @FXML
    private TableColumn<Authors, String> columnAuthorName;
    @FXML
    private TableColumn<Authors, String> columnAuthorLastname;
    
    @FXML
    private Pane panePublishers;
    @FXML
    private TableView<Publishers> tablePublishers;
    @FXML
    private TableColumn<Publishers, String> columnIdPublisher;
    @FXML
    private TableColumn<Publishers, String> columnPublisherName;
    
    @FXML
    private Pane paneTypes;
    @FXML
    private TableView<Types> tableTypes;
    @FXML
    private TableColumn<Types, String> columnIdType;
    @FXML
    private TableColumn<Types, String> columnTypeName;
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Customers> login = em.createNativeQuery("select * from customers where is_login", Customers.class).getResultList();
            LocalDate date = LocalDate.now();
            lblHello.setText("Cześć " + login.get(0).getName() + ", dzisiaj jest " + date);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        showDataCustomers();
    }
    
    
    private void showDataCustomers() {
        List<Customers> list = em.createNativeQuery("select * from customers", Customers.class).getResultList();
        ObservableList<Customers> obs = FXCollections.observableList(list);
        
        columnIdCustomer.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_customer())));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        columnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        columnStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
        columnHouseNumber.setCellValueFactory(new PropertyValueFactory<>("house_number"));
        columnZipcode.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        columnVoivodeship.setCellValueFactory(new PropertyValueFactory<>("voivodeship"));
        columnIsLogin.setCellValueFactory(new PropertyValueFactory<>("isLogin"));
        columnAdmin.setCellValueFactory(new PropertyValueFactory<>("admin"));
        
        tableCustomers.setItems(obs);
    }
    
    private void showDataOrders() {
        List<Orders> list = em.createNativeQuery("select * from orders", Orders.class).getResultList();
        ObservableList<Orders> obs = FXCollections.observableList(list);
        
        columnIdOrder.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_order())));
        columnImplementationStage.setCellValueFactory(new PropertyValueFactory<>("implementation_stage"));
        columnOrderDate.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        // NIE WYŚWIETLA W QUERY DANYCH ODNOŚNIE KLIENTA
        /*
        columnIdCustomerOrder.setCellValueFactory((cell) -> {
            SimpleStringProperty name = new SimpleStringProperty(new SimpleStringProperty(cell.getValue().getCustomer().getName()).get() + " "
                    + new SimpleStringProperty(cell.getValue().getCustomer().getLastname()).get());
            return name;
        })*/
        
        tableOrders.setItems(obs);
    }
    
    private void showDataBooks() {
        List<Books> list = em.createNativeQuery("select * from books", Books.class).getResultList();
        ObservableList<Books> obs = FXCollections.observableList(list);
        
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

        tableBooks.setItems(obs);
    }
    
    private void showDataAuthors() {
        List<Authors> list = em.createNativeQuery("select * from authors", Authors.class).getResultList();
        ObservableList<Authors> obs = FXCollections.observableList(list);
        
        columnIdAuthor.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_author())));
        columnAuthorName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAuthorLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        
        tableAuthors.setItems(obs);
    }
    
    private void showDataPublishers() {
        List<Publishers> list = em.createNativeQuery("select * from publishers", Publishers.class).getResultList();
        ObservableList<Publishers> obs = FXCollections.observableList(list);
        
        columnIdPublisher.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_publisher())));
        columnPublisherName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        tablePublishers.setItems(obs);
    }
    
    private void showDataTypes() {
        List<Types> list = em.createNativeQuery("select * from types", Types.class).getResultList();
        ObservableList<Types> obs = FXCollections.observableList(list);
        
        columnIdType.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_type())));
        columnTypeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        tableTypes.setItems(obs);
    }
    
    
    
    public void turnOffPane() {
        paneCustomers.setVisible(false);
        paneOrders.setVisible(false);
        paneBooks.setVisible(false);
        paneAuthors.setVisible(false);
        panePublishers.setVisible(false);
        paneTypes.setVisible(false);
    }
    

    @FXML
    private void handleBtnCustomers(ActionEvent event) {
        turnOffPane();
        showDataCustomers();
        paneCustomers.setVisible(true);
    }

    @FXML
    private void handleBtnOrders(ActionEvent event) {
        turnOffPane();
        showDataOrders();
        paneOrders.setVisible(true);
    }

    @FXML
    private void handleBtnBooks(ActionEvent event) {
        turnOffPane();
        showDataBooks();
        paneBooks.setVisible(true);
    }

    @FXML
    private void handleBtnAuthors(ActionEvent event) {
        turnOffPane();
        showDataAuthors();
        paneAuthors.setVisible(true);
    }

    @FXML
    private void handleBtnPublishers(ActionEvent event) {
        turnOffPane();
        showDataPublishers();
        panePublishers.setVisible(true);

    }

    @FXML
    private void handleBtnTypes(ActionEvent event) {
        turnOffPane();
        showDataTypes();
        paneTypes.setVisible(true);
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
    
    
    private void openScene(String name) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("/bookstore/scenes/" + name + "/" + name.toUpperCase() + ".fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
