package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customers.class)
public abstract class Customers_ {

	public static volatile SingularAttribute<Customers, String> zipcode;
	public static volatile SingularAttribute<Customers, String> password;
	public static volatile SingularAttribute<Customers, String> phone;
	public static volatile SingularAttribute<Customers, String> city;
	public static volatile SingularAttribute<Customers, Long> id_customer;
	public static volatile SingularAttribute<Customers, String> street;
	public static volatile SingularAttribute<Customers, String> name;
	public static volatile SingularAttribute<Customers, String> house_number;
	public static volatile SingularAttribute<Customers, String> voivodeship;
	public static volatile ListAttribute<Customers, Orders> orders;
	public static volatile SingularAttribute<Customers, String> email;
	public static volatile SingularAttribute<Customers, String> lastname;

}

