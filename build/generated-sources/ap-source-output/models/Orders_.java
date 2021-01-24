package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orders.class)
public abstract class Orders_ {

	public static volatile SingularAttribute<Orders, String> order_date;
	public static volatile SingularAttribute<Orders, Long> id_order;
	public static volatile ListAttribute<Orders, Books> books;
	public static volatile SingularAttribute<Orders, String> implementation_stage;
	public static volatile SingularAttribute<Orders, Customers> customer;

}

