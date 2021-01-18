package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authors.class)
public abstract class Authors_ {

	public static volatile ListAttribute<Authors, Books> books;
	public static volatile SingularAttribute<Authors, String> name;
	public static volatile SingularAttribute<Authors, Long> id_author;
	public static volatile SingularAttribute<Authors, String> lastname;

}

