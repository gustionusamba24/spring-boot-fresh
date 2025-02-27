package com.gustionusamba.bookcatalog.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "book_detail")
public class BookDetail implements Serializable {


    @Serial
    private static final long serialVersionUID = -8529158973860216949L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "settings")
    private String settings;

    @Column(name = "thumbnail")
    private String thumbnail;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
