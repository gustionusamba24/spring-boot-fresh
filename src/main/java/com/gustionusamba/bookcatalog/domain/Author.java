package com.gustionusamba.bookcatalog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
//@DynamicUpdate
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false")
public class Author extends AbstractBasedEntity {

    // postgre -> bigserial
    // mysql -> autoincrement
    // strategy -> identity -> cons: batch insert is disabled
    // strategy -> sequence -> pros: batch insert is enabled
    @Serial
    private static final long serialVersionUID = -4897877435841949133L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq")
    private Long id;

    @Column(name = "author_name", nullable = false, columnDefinition = "varchar(300)")
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "author", cascade = CascadeType.MERGE)
    private List<Address> addresses;
}
