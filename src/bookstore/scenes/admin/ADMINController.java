package bookstore.scenes.admin;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    
    // ENTITY MANAGER
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookstorePU");
    EntityManager em;
    
    // -------- MENU --------
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
    
    // -------- KLIENT --------
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
    private TextField inputIdCustomer;
    @FXML
    private TextField inputEmailCustomer;
    @FXML
    private TextField inputPasswordCustomer;
    @FXML
    private TextField inputNameCustomer;
    @FXML
    private TextField inputLastnameCustomer;
    @FXML
    private TextField inputPhoneCustomer;
    @FXML
    private TextField inputCityCustomer;
    @FXML
    private TextField inputStreetCustomer;
    @FXML
    private TextField inputHouseNumberCustomer;
    @FXML
    private TextField inputZipcodeCustomer;
    @FXML
    private TextField inputVoivodeshipCustomer;
    @FXML
    private ComboBox<Boolean> comoboxAdminCustomer;
    @FXML
    private Button btnUpdateCusotmer;
    @FXML
    private Button btnDeleteCustomer;
    @FXML
    private Button btnAddCustomer;
    
    // -------- ZAMÓWIENIA --------
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
    private TableColumn<Orders, String> ColumnIsbnOrder;
    @FXML
    private TextField inputIdOrder;
    @FXML
    private TextField inputDateOrder;
    @FXML
    private ComboBox<String> comboboxImplementationStageOrder;
    @FXML
    private ComboBox<String> comboboxCustomerOrder;
    @FXML
    private ComboBox<String> combboxIsbnOrder;
    @FXML
    private Button btnAddOrder;
    @FXML
    private Button btnDeleteOrder;
    @FXML
    private Button btnUpdateOrder;
    
    // -------- KSIĄŻKI --------
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
    private TextField inputIsbnBook;
    @FXML
    private TextField inputTitleBook;
    @FXML
    private TextField inputReleaseDateBook;
    @FXML
    private TextField inputQuantityBook;
    @FXML
    private TextField inputPriceBook;
    @FXML
    private ComboBox<String> comboboxAuthorBook;
    @FXML
    private ComboBox<String> comboboxPublisherBook;
    @FXML
    private ComboBox<String> comboboxTypeBook;
    @FXML
    private Button btnAddBook;
    @FXML
    private Button btnDeleteBook;
    @FXML
    private Button btnUpdateBook;
    
    // -------- AUTORZY --------
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
    private TextField inputIdAuthor;
    @FXML
    private TextField inputNameAuthor;
    @FXML
    private TextField inputLastnameAuthor;
    @FXML
    private Button btnAddAuthor;
    @FXML
    private Button btnDeleteAuthor;
    @FXML
    private Button btnUpdateAuthor;
    
    // -------- WYDAWNICTWA --------
    @FXML
    private Pane panePublishers;
    @FXML
    private TableView<Publishers> tablePublishers;
    @FXML
    private TableColumn<Publishers, String> columnIdPublisher;
    @FXML
    private TableColumn<Publishers, String> columnPublisherName;
    @FXML
    private TextField inputIdPublisher;
    @FXML
    private TextField inputNamePublisher;
    @FXML
    private Button btnAddPublisher;
    @FXML
    private Button btnDeletePublisher;
    @FXML
    private Button btnUpdatePublisher;
    
    // -------- GATUNKI --------
    @FXML
    private Pane paneTypes;
    @FXML
    private TableView<Types> tableTypes;
    @FXML
    private TableColumn<Types, String> columnIdType;
    @FXML
    private TableColumn<Types, String> columnTypeName;
    @FXML
    private TextField inputIdType;
    @FXML
    private TextField inputNameType;
    @FXML
    private Button btnAddType;
    @FXML
    private Button btnDeleteType;
    @FXML
    private Button btnUpdateType;

    // -------- METODY OGÓLNE --------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * Wyłapywanie zalogowanego użytkowika i załadownie powitania oraz załadowanie danych
         */
        em = emf.createEntityManager();
        try {
            List<Customers> login = em.createNativeQuery("select * from customers where is_login", Customers.class).getResultList();
            LocalDate date = LocalDate.now();
            lblHello.setText("Cześć " + login.get(0).getName() + ", dzisiaj jest " + date);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        em.close();
        showDataCustomers();
    }
    public void turnOffPane() {
        /**
         * Metoda wyłączająca wszytkie Pane
         */
        paneCustomers.setVisible(false);
        paneOrders.setVisible(false);
        paneBooks.setVisible(false);
        paneAuthors.setVisible(false);
        panePublishers.setVisible(false);
        paneTypes.setVisible(false);
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
    
    // -------- REDEROWANIE DANYCH --------
    private void showDataCustomers() {
        /**
         * Rederowanie danych dla klientów
         */
        em = emf.createEntityManager();
        
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
        
        ObservableList<Boolean> combo = FXCollections.observableArrayList(true, false);
        comoboxAdminCustomer.setItems(combo);
        
        em.close();
    }
    private void showDataOrders() {
        /**
         * Rederowanie danych dla zamówień
         */
        em = emf.createEntityManager();
        
        List<Orders> list = em.createNativeQuery("select * from orders", Orders.class).getResultList();
        ObservableList<Orders> obs = FXCollections.observableList(list);
        
        
        columnIdOrder.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_order())));
        columnImplementationStage.setCellValueFactory(new PropertyValueFactory<>("implementation_stage"));
        columnOrderDate.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        columnCustomerOrder.setCellValueFactory((cell) -> {
            SimpleStringProperty name = new SimpleStringProperty(new SimpleStringProperty(cell.getValue().getCustomer().getName()).get() + " "
                    + new SimpleStringProperty(cell.getValue().getCustomer().getLastname()).get());
            return name;
        });
        ColumnIsbnOrder.setCellValueFactory((cell) -> {
            return new SimpleStringProperty(cell.getValue().getBook().get(0).getTitle());
        });
        
        tableOrders.setItems(obs);
        
        ObservableList<String> combo = FXCollections.observableArrayList("Zamówienie opłacone", "Paczka zapakowana",
                "Odebrane przez kuriera", "Podczas doręczania", "Zamówienie dostarczone");
        comboboxImplementationStageOrder.setItems(combo);
        
        List<String> isbn = em.createNativeQuery("select isbn from books").getResultList();
        ObservableList<String> combo2 = FXCollections.observableList(isbn);
        combboxIsbnOrder.setItems(combo2);
        
        List<String> cusotmer = em.createNativeQuery("select concat(id_customer, '. ', name, ' ', lastname) from customers").getResultList();
        ObservableList<String> combo3 = FXCollections.observableList(cusotmer);
        comboboxCustomerOrder.setItems(combo3);

        em.close();
    }
    private void showDataBooks() {
        /**
         * Rederowanie danych dla książek
         */
        em = emf.createEntityManager();
        
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
        
        List<String> authorsList = em.createNativeQuery("select concat(id_author, '. ', name, ' ', lastname) from authors").getResultList();
        ObservableList<String> combo = FXCollections.observableList(authorsList);
        comboboxAuthorBook.setItems(combo);
        
        List<String> publishersList = em.createNativeQuery("select concat(id_publisher, '. ', name) from publishers").getResultList();
        ObservableList<String> combo2 = FXCollections.observableList(publishersList);
        comboboxPublisherBook.setItems(combo2);
        
        List<String> typesList = em.createNativeQuery("select concat(id_type, '. ', name) from types").getResultList();
        ObservableList<String> combo3 = FXCollections.observableList(typesList);
        comboboxTypeBook.setItems(combo3);
        
        em.close();
    }
    private void showDataAuthors() {
        /**
         * Rederowanie danych dla autorów
         */
        em = emf.createEntityManager();
        
        List<Authors> list = em.createNativeQuery("select * from authors", Authors.class).getResultList();
        ObservableList<Authors> obs = FXCollections.observableList(list);
        
        columnIdAuthor.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_author())));
        columnAuthorName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAuthorLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        
        tableAuthors.setItems(obs);
        
        em.close();
    }
    private void showDataPublishers() {
        /**
         * Rederowanie danych dla wydawców
         */
        em = emf.createEntityManager();
        
        List<Publishers> list = em.createNativeQuery("select * from publishers", Publishers.class).getResultList();
        ObservableList<Publishers> obs = FXCollections.observableList(list);
        
        columnIdPublisher.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_publisher())));
        columnPublisherName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        tablePublishers.setItems(obs);
        
        em.close();
    }
    private void showDataTypes() {
        /**
         * Rederowanie danych dla gatunków
         */
        em = emf.createEntityManager();
        
        List<Types> list = em.createNativeQuery("select * from types", Types.class).getResultList();
        ObservableList<Types> obs = FXCollections.observableList(list);
        
        columnIdType.setCellValueFactory(cell -> new SimpleStringProperty(Long.toString(cell.getValue().getId_type())));
        columnTypeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        tableTypes.setItems(obs);
        
        em.close();
    }

    // -------- PRZYCISKI MENU --------
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
    
    // -------- KLIENT -> DODAJ USUŃ AKTUALIZUJ --------
    @FXML
    private void handleBtnAddCustomer(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Customers customer = new Customers();
            
            if (!(("").equals(inputEmailCustomer.getText()) || ("").equals(inputPasswordCustomer.getText()) || 
                    ("").equals(inputNameCustomer.getText()) || ("").equals(inputLastnameCustomer.getText()) || 
                    ("").equals(inputPhoneCustomer.getText()) || ("").equals(inputCityCustomer.getText()) || 
                    ("").equals(inputStreetCustomer.getText()) || ("").equals(inputHouseNumberCustomer.getText()) || 
                    ("").equals(inputZipcodeCustomer.getText()) || ("").equals(inputVoivodeshipCustomer.getText()) || 
                    comoboxAdminCustomer.getValue() == null)){
                
                customer.setEmail(inputEmailCustomer.getText());
                customer.setPassword(inputPasswordCustomer.getText());
                customer.setName(inputNameCustomer.getText());
                customer.setLastname(inputLastnameCustomer.getText());
                customer.setPhone(inputPhoneCustomer.getText());
                customer.setCity(inputCityCustomer.getText());
                customer.setStreet(inputStreetCustomer.getText());
                customer.setHouse_number(inputHouseNumberCustomer.getText());
                customer.setZipcode(inputZipcodeCustomer.getText());
                customer.setVoivodeship(inputVoivodeshipCustomer.getText());
                customer.setAdmin(comoboxAdminCustomer.getValue());
                
                em.getTransaction().begin();
                em.persist(customer);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }

        showDataCustomers();
    }
    @FXML
    private void handleBtnDeleteCustomer(ActionEvent event) {
        
        try {
            em = emf.createEntityManager();
            Customers customer = em.find(Customers.class, Long.valueOf(inputIdCustomer.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            em.remove(customer);
            em.getTransaction().commit(); 
            em.close();
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataCustomers();
            
    }
    @FXML
    private void handleBtnUpdateCustomer(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Customers customer = em.find(Customers.class, Long.valueOf(inputIdCustomer.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            if (!(("").equals(inputEmailCustomer.getText()) || ("").equals(inputPasswordCustomer.getText()) || 
                    ("").equals(inputNameCustomer.getText()) || ("").equals(inputLastnameCustomer.getText()) || 
                    ("").equals(inputPhoneCustomer.getText()) || ("").equals(inputCityCustomer.getText()) || 
                    ("").equals(inputStreetCustomer.getText()) || ("").equals(inputHouseNumberCustomer.getText()) || 
                    ("").equals(inputZipcodeCustomer.getText()) || ("").equals(inputVoivodeshipCustomer.getText()) || 
                    comoboxAdminCustomer.getValue() == null)){
                
                customer.setEmail(inputEmailCustomer.getText());
                customer.setPassword(inputPasswordCustomer.getText());
                customer.setName(inputNameCustomer.getText());
                customer.setLastname(inputLastnameCustomer.getText());
                customer.setPhone(inputPhoneCustomer.getText());
                customer.setCity(inputCityCustomer.getText());
                customer.setStreet(inputStreetCustomer.getText());
                customer.setHouse_number(inputHouseNumberCustomer.getText());
                customer.setZipcode(inputZipcodeCustomer.getText());
                customer.setVoivodeship(inputVoivodeshipCustomer.getText());
                customer.setAdmin(comoboxAdminCustomer.getValue());
                
                em.merge(customer);
                em.getTransaction().commit();
                em.close();
                
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataCustomers();

    }

    // -------- ZAMÓWIENIA -> DODAJ USUŃ AKTUALIZUJ --------
    @FXML
    private void handleBtnAddOrder(ActionEvent event) { 
        try {
            em = emf.createEntityManager();
            Orders order = new Orders();
            
            if (!(comboboxImplementationStageOrder.getValue() == null || ("").equals(inputDateOrder.getText()) || 
                    comboboxCustomerOrder.getValue() == null || combboxIsbnOrder.getValue() == null)){
                
                order.setImplementation_stage(comboboxImplementationStageOrder.getValue());
                order.setOrder_date(inputDateOrder.getText());
                
                String n = "";
                for (char ch : comboboxCustomerOrder.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n += Character.toString(ch);
                }
                order.setCustomer((Customers) em.find(Customers.class, Long.valueOf(n)));
                order.addBook((Books) em.find(Books.class, combboxIsbnOrder.getValue()));
                
                em.getTransaction().begin();
                em.persist(order);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataOrders();
        
    }
    @FXML
    private void handleBtnDeleteOrder(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Orders order = em.find(Orders.class, Long.valueOf(inputIdOrder.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            order.removeBook((Books) order.getBook().get(0));
            em.remove(order);
            em.getTransaction().commit();  
            em.close();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        
        showDataOrders(); 
    }
    @FXML
    private void handleBtnUpdateOrder(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Orders order = em.find(Orders.class, Long.valueOf(inputIdOrder.getText()));
            
            if (!(comboboxImplementationStageOrder.getValue() == null || ("").equals(inputDateOrder.getText()) || 
                    comboboxCustomerOrder.getValue() == null || combboxIsbnOrder.getValue() == null)){
                
                order.setImplementation_stage(comboboxImplementationStageOrder.getValue());
                order.setOrder_date(inputDateOrder.getText());
                
                String n = "";
                for (char ch : comboboxCustomerOrder.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n += Character.toString(ch);
                }
                order.setCustomer((Customers) em.find(Customers.class, Long.valueOf(n)));
                
                order.removeBook((Books) order.getBook().get(0));
                order.addBook((Books) em.find(Books.class, combboxIsbnOrder.getValue()));
                
                em.getTransaction().begin();
                em.persist(order);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataOrders();
    }
    
    // -------- KSIĄŻKI -> DODAJ USUŃ AKTUALIZUJ --------
    @FXML
    private void handleBtnAddBook(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Books book = new Books();
            
            if (!(("").equals(inputTitleBook.getText()) || comboboxAuthorBook.getValue() == null || 
                    comboboxPublisherBook.getValue() == null || comboboxTypeBook.getValue() == null || 
                    ("").equals(inputReleaseDateBook.getText()) || ("").equals(inputQuantityBook.getText()) || 
                    ("").equals(inputPriceBook.getText()) || ("").equals(inputIsbnBook.getText()))){

                String n = "";
                for (char ch : comboboxAuthorBook.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n += Character.toString(ch);
                }
                book.setAuthor((Authors) em.find(Authors.class, Long.valueOf(n)));
                
                String n1 = "";
                for (char ch : comboboxPublisherBook.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n1 += Character.toString(ch);
                }
                book.setPublisher((Publishers) em.find(Publishers.class, Long.valueOf(n1)));
                
                String n2 = "";
                for (char ch : comboboxTypeBook.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n2 += Character.toString(ch);
                }
                book.setType((Types) em.find(Types.class, Long.valueOf(n2)));
                
                book.setIsbn(inputIsbnBook.getText());
                book.setTitle(inputTitleBook.getText());
                book.setRelease_date(inputReleaseDateBook.getText());
                book.setQuantity_available(Integer.parseInt(inputQuantityBook.getText()));
                book.setPrice(Double.parseDouble(inputPriceBook.getText()));
                
                em.getTransaction().begin();
                em.persist(book);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        
        showDataBooks();
    }
    @FXML
    private void handleBtnDeleteBook(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Books book = em.find(Books.class,(String) inputIsbnBook.getText());
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            em.remove(book);
            em.getTransaction().commit();  
            em.close();
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataBooks(); 
    }
    @FXML
    private void handleBtnUpdateBook(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Books book = em.find(Books.class, inputIsbnBook.getText());
            
            
            if (!(("").equals(inputTitleBook.getText()) || comboboxAuthorBook.getValue() == null || 
                    comboboxPublisherBook.getValue() == null || comboboxTypeBook.getValue() == null || 
                    ("").equals(inputReleaseDateBook.getText()) || ("").equals(inputQuantityBook.getText()) || 
                    ("").equals(inputPriceBook.getText()))){
                
                
                String n = "";
                for (char ch : comboboxAuthorBook.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n += Character.toString(ch);
                }
                book.setAuthor((Authors) em.find(Authors.class, Long.valueOf(n)));
                
                String n1 = "";
                for (char ch : comboboxPublisherBook.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n1 += Character.toString(ch);
                }
                book.setPublisher((Publishers) em.find(Publishers.class, Long.valueOf(n1)));
                
                String n2 = "";
                for (char ch : comboboxTypeBook.getValue().toCharArray()){
                    if((".").equals(Character.toString(ch)))
                       break;
                    n2 += Character.toString(ch);
                }
                book.setType((Types) em.find(Types.class, Long.valueOf(n2)));
                book.setTitle(inputTitleBook.getText());
                book.setRelease_date(inputReleaseDateBook.getText());
                book.setQuantity_available(Integer.parseInt(inputQuantityBook.getText()));
                book.setPrice(Double.parseDouble(inputPriceBook.getText()));
                
                em.getTransaction().begin();
                em.merge(book);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataBooks();
    }
    
    // -------- AUTOR -> DODAJ USUŃ AKTUALIZUJ --------
    @FXML
    private void handleBtnAddAuthor(ActionEvent event) {
        try{
            em = emf.createEntityManager();
            Authors author = new Authors();
            
            if (!(("").equals(inputNameAuthor.getText()) || ("").equals(inputLastnameAuthor.getText()))){
                author.setName(inputNameAuthor.getText());
                author.setLastname(inputLastnameAuthor.getText());
                em.getTransaction().begin();
                em.persist(author);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataAuthors();
    }
    @FXML
    private void handleBtnDeleteAuthor(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Authors author = em.find(Authors.class, Long.valueOf(inputIdAuthor.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            em.remove(author);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        showDataAuthors(); 
    }
    @FXML
    private void handleBtnUpdateAuthor(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Authors author = em.find(Authors.class, Long.valueOf(inputIdAuthor.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }

            author.setName(inputNameAuthor.getText());
            author.setLastname(inputLastnameAuthor.getText());
            em.merge(author);
            em.getTransaction().commit();   
            em.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        showDataAuthors();
    }
    
    // -------- WYDAWNICTWO -> DODAJ USUŃ AKTUALIZUJ --------
    @FXML
    private void handleBtnAddPublisher(ActionEvent event) {
        try{
            em = emf.createEntityManager();
            Publishers publisher = new Publishers();
            
            if (!("").equals(inputNamePublisher.getText())){
                publisher.setName(inputNamePublisher.getText());
                em.getTransaction().begin();
                em.persist(publisher);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }

        showDataPublishers();
         
    }
    @FXML
    private void handleBtnDeletePublisher(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Publishers publisher = em.find(Publishers.class, Long.valueOf(inputIdPublisher.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            em.remove(publisher);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        showDataPublishers();
    }
    @FXML
    private void handleBtnUpdatePublisher(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Publishers publisher = em.find(Publishers.class, Long.valueOf(inputIdPublisher.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            if (!("").equals(inputNamePublisher.getText())){
                publisher.setName(inputNamePublisher.getText());
                em.merge(publisher);
                em.getTransaction().commit();  
                em.close();
            }
  
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        showDataPublishers();
    }

    // -------- GATUNEK -> DODAJ USUŃ AKTUALIZUJ --------
    @FXML
    private void handleBtnAddType(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Types type = new Types();
            if (!("").equals(inputNameType.getText())){
                type.setName(inputNameType.getText());
                em.getTransaction().begin();
                em.persist(type);
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e ){
            System.out.println("Error: " + e);
        }
        
        showDataTypes();
    }
    @FXML
    private void handleBtnDeleteType(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Types type = em.find(Types.class, Long.valueOf(inputIdType.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            em.remove(type);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        showDataTypes();
    }
    @FXML
    private void handleBtnUpdateType(ActionEvent event) {
        try {
            em = emf.createEntityManager();
            Types type = em.find(Types.class, Long.valueOf(inputIdType.getText()));
            
            try {
                em.getTransaction().begin();
            } catch (Exception e){
                System.out.println("Error: " + e);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            
            if (!("").equals(inputNameType.getText())){
                type.setName(inputNameType.getText());
                em.merge(type);
                em.getTransaction().commit(); 
                em.close();
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        showDataTypes();
    }

    // -------- Table View --------
    @FXML
    private void handleTableViewCustomers(MouseEvent event) {
        try {
            Customers customer = tableCustomers.getSelectionModel().getSelectedItem();
            inputIdCustomer.setText(Long.toString(customer.getId_customer()));
            inputEmailCustomer.setText(customer.getEmail());
            inputPasswordCustomer.setText(customer.getPassword());
            inputNameCustomer.setText(customer.getName());
            inputLastnameCustomer.setText(customer.getLastname());
            inputPhoneCustomer.setText(customer.getPhone());
            inputCityCustomer.setText(customer.getCity());
            inputStreetCustomer.setText(customer.getStreet());
            inputHouseNumberCustomer.setText(customer.getHouse_number());
            inputZipcodeCustomer.setText(customer.getZipcode());
            inputVoivodeshipCustomer.setText(customer.getVoivodeship());
            comoboxAdminCustomer.getSelectionModel().select(customer.isAdmin());
            
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }
    @FXML
    private void handleTableViewOrders(MouseEvent event) {
        try {
            Orders orders = tableOrders.getSelectionModel().getSelectedItem();
            inputIdOrder.setText(Long.toString(orders.getId_order()));
            comboboxImplementationStageOrder.getSelectionModel().select(orders.getImplementation_stage());
            inputDateOrder.setText(orders.getOrder_date());
            comboboxCustomerOrder.getSelectionModel().select(orders.getCustomer().getId_customer() + ". " 
                    + orders.getCustomer().getName() + " " + orders.getCustomer().getLastname());
            combboxIsbnOrder.getSelectionModel().select(orders.getBook().get(0).getIsbn());

        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }
    @FXML
    private void handleTableViewBooks(MouseEvent event) {
        try {
            Books book = tableBooks.getSelectionModel().getSelectedItem();
            inputIsbnBook.setText(book.getIsbn());
            inputTitleBook.setText(book.getTitle());
            inputReleaseDateBook.setText(book.getRelease_date());
            inputQuantityBook.setText("" + book.getQuantity_available());
            inputPriceBook.setText("" + book.getPrice());
            comboboxAuthorBook.getSelectionModel().select(book.getAuthor().getId_author() + ". " +book.getAuthor().getName() + " " + book.getAuthor().getLastname());
            comboboxPublisherBook.getSelectionModel().select(book.getPublisher().getId_publisher() + ". " +book.getPublisher().getName());
            comboboxTypeBook.getSelectionModel().select(book.getType().getId_type() + ". " +book.getType().getName());
            
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }
    @FXML
    private void handleTableViewAuthors(MouseEvent event) {
        try {
            Authors author = tableAuthors.getSelectionModel().getSelectedItem();
            inputIdAuthor.setText(Long.toString(author.getId_author()));
            inputNameAuthor.setText(author.getName());
            inputLastnameAuthor.setText(author.getLastname());
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }
    @FXML
    private void handleTableViewPublishers(MouseEvent event) {
        try {
            Publishers pub = tablePublishers.getSelectionModel().getSelectedItem();
            inputIdPublisher.setText(Long.toString(pub.getId_publisher()));
            inputNamePublisher.setText(pub.getName());
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }
    @FXML
    private void handleTableViewTypes(MouseEvent event) {
        try {
            Types type = tableTypes.getSelectionModel().getSelectedItem();
            inputIdType.setText(Long.toString(type.getId_type()));
            inputNameType.setText(type.getName());
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }
}
