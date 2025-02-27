package com.gustionusamba.bookcatalog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
//@Table(indexes = {
//        @Index(name = "uk_secure_id", columnList = "secure_id")
//})
public abstract class AbstractBasedEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7073673358802225221L;

    @Column(name = "secure_id", nullable = false, unique = true)
    private String secureId = UUID.randomUUID().toString();

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted;
}
