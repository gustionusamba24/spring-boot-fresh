package com.gustionusamba.bookcatalog.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book extends AbstractBasedEntity {

    @Serial
    private static final long serialVersionUID = -4883238118080083787L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "id")
            })
    private List<Author> authors;

    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_code", referencedColumnName = "code")
            })
    private List<Category> categories;

}
