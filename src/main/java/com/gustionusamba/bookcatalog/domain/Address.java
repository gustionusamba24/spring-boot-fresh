package com.gustionusamba.bookcatalog.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
