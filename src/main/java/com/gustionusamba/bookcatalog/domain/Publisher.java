package com.gustionusamba.bookcatalog.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.util.List;

@Data
@Entity
@Table(name = "publisher")
public class Publisher extends AbstractBasedEntity {

    @Serial
    private static final long serialVersionUID = -672114490629015344L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
