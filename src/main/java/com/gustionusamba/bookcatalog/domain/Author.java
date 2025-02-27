package com.gustionusamba.bookcatalog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
//@DynamicUpdate
public class Author {

    // postgre -> bigserial
    // mysql -> autoincrement
    // strategy -> identity -> cons: batch insert is disabled
    // strategy -> sequence -> pros: batch insert is enabled

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq")
    private Long id;

    @Column(name = "author_name", nullable = false, columnDefinition = "varchar(300)")
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted;
}
