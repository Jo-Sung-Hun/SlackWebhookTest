package com.chain.chain.Domain.Entity.User;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPersonalCustomer is a Querydsl query type for PersonalCustomer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPersonalCustomer extends EntityPathBase<PersonalCustomer> {

    private static final long serialVersionUID = 1732464921L;

    public static final QPersonalCustomer personalCustomer = new QPersonalCustomer("personalCustomer");

    public final StringPath birth = createString("birth");

    public final StringPath email = createString("email");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final DateTimePath<java.time.LocalDateTime> signDay = createDateTime("signDay", java.time.LocalDateTime.class);

    public QPersonalCustomer(String variable) {
        super(PersonalCustomer.class, forVariable(variable));
    }

    public QPersonalCustomer(Path<? extends PersonalCustomer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersonalCustomer(PathMetadata metadata) {
        super(PersonalCustomer.class, metadata);
    }

}

