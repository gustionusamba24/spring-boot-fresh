package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Address;
import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorQueryDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.dto.AuthorUpdateDTO;
import com.gustionusamba.bookcatalog.exception.BadRequestException;
import com.gustionusamba.bookcatalog.exception.ResourceNotFoundException;
import com.gustionusamba.bookcatalog.repository.AuthorRepository;
import com.gustionusamba.bookcatalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(String id) {
        // TODO:
        // 1. fetch data from database
        Author author = authorRepository.findBySecureId(id).orElseThrow(() -> new ResourceNotFoundException("Invalid author ID"));
        // 2. map the data to AuthorResponseDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }

    @Override
    public void createNewAuthor(List<AuthorCreateDTO> dtos) {

        List<Author> authors = dtos.stream().map((dto) -> {
            Author author = new Author();
            author.setName(dto.getAuthorName());
            author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
            List<Address> addresses = dto.getAddresses().stream().map(a -> {
                Address address = new Address();
                address.setStreetName(a.getStreetName());
                address.setCityName(a.getCityName());
                address.setZipCode(a.getZipCode());
                address.setAuthor(author);
                return address;
            }).collect(Collectors.toList());
            author.setAddresses(addresses);
            return author;
        }).collect(Collectors.toList());

        authorRepository.saveAll(authors);
    }

    @Override
    public void updateAuthor(String authorId, AuthorUpdateDTO dto) {
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestException("Invalid author ID"));
        Map<Long, Address> addressMap = author.getAddresses().stream()
                .collect(Collectors.toMap(Address::getId, Function.identity()));
        List<Address> addresses = dto.getAddresses().stream().map(a -> {
            Address address = addressMap.get(a.getAddressId());
            address.setStreetName(a.getStreetName());
            address.setCityName(a.getCityName());
            address.setZipCode(a.getZipCode());
            return address;
        }).collect(Collectors.toList());
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        author.setBirthDate(
                dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
        author.setAddresses(addresses);
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(String authorId) {
//        authorRepository.deleteById(authorId);
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestException("Invalid author ID"));
        authorRepository.delete(author);

        // soft delete
//        Author author = authorRepository.findByIdAndDeletedFalse(authorId).orElseThrow(() -> new BadRequestException("Invalid author id"));
//        author.setDeleted(Boolean.TRUE);
//        authorRepository.save(author);
    }

    @Override
    public List<Author> findAuthors(List<String> authorIdList) {
        List<Author> authors = authorRepository.findBySecureIdIn(authorIdList);
        if (authors.isEmpty()) throw new BadRequestException("author can not be empty");
        return authors;
    }

    @Override
    public List<AuthorResponseDTO> constructDTO(List<Author> authors) {
        return authors.stream().map((a) -> {
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setAuthorName(a.getName());
            dto.setBirthDate(a.getBirthDate().toEpochDay());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Map<Long, List<String>> findAuthorMaps(List<Long> bookIdList) {
        List<AuthorQueryDTO> queryList = authorRepository.findAuthorByBookIdList(bookIdList);
        Map<Long, List<String>> authorMap = new HashMap<>();
        List<String> authorList;
        for (AuthorQueryDTO q : queryList) {
            if (!authorMap.containsKey(q.getBookId())) {
                authorList = new ArrayList<>();
            } else {
                authorList = authorMap.get(q.getBookId());
            }
            authorList.add(q.getAuthorName());
            authorMap.put(q.getBookId(), authorList);
        }
        return authorMap;
    }
}
