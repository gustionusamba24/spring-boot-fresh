package com.gustionusamba.bookcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BookCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCatalogApplication.class, args);
    }
}
