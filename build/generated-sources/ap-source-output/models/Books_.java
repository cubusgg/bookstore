package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Books.class)
public abstract class Books_ {

	public static volatile SingularAttribute<Books, String> release_date;
	public static volatile SingularAttribute<Books, Double> price;
	public static volatile SingularAttribute<Books, Authors> author;
	public static volatile SingularAttribute<Books, String> isbn;
	public static volatile SingularAttribute<Books, Publishers> publisher;
	public static volatile ListAttribute<Books, Orders> orders;
	public static volatile SingularAttribute<Books, String> title;
	public static volatile SingularAttribute<Books, Types> type;
	public static volatile SingularAttribute<Books, Integer> quantity_available;

}

