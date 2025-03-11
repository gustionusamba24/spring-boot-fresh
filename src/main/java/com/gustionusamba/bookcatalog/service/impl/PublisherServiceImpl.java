package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Publisher;
import com.gustionusamba.bookcatalog.dto.PublisherCreateDTO;
import com.gustionusamba.bookcatalog.dto.PublisherListResponseDTO;
import com.gustionusamba.bookcatalog.dto.PublisherUpdateDTO;
import com.gustionusamba.bookcatalog.dto.ResultPageResponseDTO;
import com.gustionusamba.bookcatalog.exception.BadRequestException;
import com.gustionusamba.bookcatalog.repository.PublisherRepository;
import com.gustionusamba.bookcatalog.service.PublisherService;
import com.gustionusamba.bookcatalog.util.PaginationUtil;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public void createPublisher(PublisherCreateDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.getPublisherName());
        publisher.setCompanyName(dto.getCompanyName());
        publisher.setAddress(dto.getAddress());

        publisherRepository.save(publisher);
    }

    @Override
    public void updatePublisher(String publisherId, PublisherUpdateDTO dto) {
        Publisher publisher = publisherRepository.findBySecureId(publisherId)
                .orElseThrow(() -> new BadRequestException("Invalid publisher id"));

        publisher.setName(dto.getPublisherName() == null || dto.getPublisherName().isBlank() ? publisher.getName() : dto.getPublisherName());
        publisher.setCompanyName(dto.getCompanyName() == null || dto.getCompanyName().isBlank() ? publisher.getCompanyName() : dto.getCompanyName());
        publisher.setAddress(dto.getAddress());

        publisherRepository.save(publisher);
    }

    @Override
    public ResultPageResponseDTO<PublisherListResponseDTO> getPublishers(Integer pages, Integer limit, String sortBy,
                                                                         String direction, String publisherName) {
        publisherName = StringUtils.isBlank(publisherName) ? "%" : publisherName + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        Page<Publisher> pageResult = publisherRepository.findByNameLikeIgnoreCase(publisherName, pageable);
        List<PublisherListResponseDTO> dtos = pageResult.stream().map((p) -> {
            PublisherListResponseDTO dto = new PublisherListResponseDTO();
            dto.setPublisherId(p.getSecureId());
            dto.setPublisherName(p.getName());
            dto.setCompanyName(p.getCompanyName());
            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
    }

    @Override
    public Publisher findPublisher(String publisherId) {
        return publisherRepository.findBySecureId(publisherId)
                .orElseThrow(() -> new BadRequestException("Invalid publisher id"));
    }
}