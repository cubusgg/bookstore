package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Publishers.class)
public abstract class Publishers_ {

	public static volatile SingularAttribute<Publishers, Long> id_publisher;
	public static volatile ListAttribute<Publishers, Books> books;
	public static volatile SingularAttribute<Publishers, String> name;

}

