package bookstore.scenes.user;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Orders;
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
    private Button btnLogout;
    @FXML
    private Label lblHello;
    @FXML
    private TableView<Orders> tableOrders;
    @FXML
    private TableColumn<Orders, String> columnId;
    @FXML
    private TableColumn<Orders, String> columnOrderStatus;
    @FXML
    private TableColumn<Orders, String> columnOrderDate;
    @FXML
    private TableColumn<Orders, String> columnOrderBook;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * Wyłapywanie zalogowanego użytkowika i załadownie powitania oraz załadowanie danych
         */
        try {
            List<Customers> login = em.createNativeQuery("select * from customers where is_login", Customers.class).getResultList();
            
            LocalDate date = LocalDate.now();
            lblHello.setText("Cześć " + login.get(0).getName() + ", dzisiaj jest " + date);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        showDataOrders();
    }    

    private void showDataOrders() {
        /**
         * Rederowanie danych zamówien tylko zalogowanego użytkownika
         */
        List<Customers> login = em.createNativeQuery("select * from customers where is_login", Customers.class).getResultList();
        List<Orders> orders = em.createNativeQuery("select * from orders where id_customer=:id", Orders.class).setParameter("id", login.get(0).getId_customer()).getResultList();
        ObservableList<Orders> obsOrders = FXCollections.observableList(orders);
        
        columnId.setCellValueFactory(new PropertyValueFactory<>("id_order"));
        columnOrderStatus.setCellValueFactory(new PropertyValueFactory<>("implementation_stage"));
        columnOrderDate.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        columnOrderBook.setCellValueFactory((cell) -> {
            return new SimpleStringProperty(cell.getValue().getBook().get(0).getTitle());
        });

        tableOrders.setItems(obsOrders);
    }
    // -------- PRZYCISK WYGOLOWANIA --------
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
        /**
         * Metoda otwierajaca scene
         */
        Parent loader = FXMLLoader.load(getClass().getResource("/bookstore/scenes/" + name + "/" + name.toUpperCase() + ".fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
