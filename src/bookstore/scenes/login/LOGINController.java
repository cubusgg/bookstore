package bookstore.scenes.login;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Customers;

/**
 * FXML Controller class
 *
 * @author jakub
 */
public class LOGINController implements Initializable {
    
    // ENTITY MANAGER
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookstorePU");
    EntityManager em = emf.createEntityManager();
    
    @FXML
    private Label lblError;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private TextField inputLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * Zmienianie wartości isLogin na false. W jednym momencie może być zalogowany tylko jeden użytkownik.
         */
        try {
            List<Customers> email = em.createNativeQuery("select * from customers", Customers.class).getResultList();
        
            email.forEach((o) -> {
                em.getTransaction().begin();
                o.setIsLogin(false);
                em.getTransaction().commit();
            });
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }    
    
    @FXML
    private void handleBtnLogin(ActionEvent event) {
        /**
         * Logowanie
         */
        try {
            List<Customers> email = em.createNativeQuery("select * from customers where email = :email", Customers.class).setParameter("email", inputLogin.getText()).getResultList();
            
            if(email.get(0).getPassword().equals(inputPassword.getText())) {
                
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.close();

                if(email.get(0).isAdmin()){
                    em.getTransaction().begin();
                    email.get(0).setIsLogin(true);
                    em.getTransaction().commit();
                    
                    openScene("admin");
                } else {
                    em.getTransaction().begin();
                    email.get(0).setIsLogin(true);
                    em.getTransaction().commit();
                    
                    openScene("user");
                }
            } else {
                lblError.setText("Nieprawidłowy login i/lub hasło.");
            }
        } catch (Exception e){
            lblError.setText("Nieprawidłowy login i/lub hasło.");
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
