package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.domain.Publisher;
import com.gustionusamba.bookcatalog.dto.PublisherCreateDTO;
import com.gustionusamba.bookcatalog.dto.PublisherListResponseDTO;
import com.gustionusamba.bookcatalog.dto.PublisherUpdateDTO;
import com.gustionusamba.bookcatalog.dto.ResultPageResponseDTO;

public interface PublisherService {

    void createPublisher(PublisherCreateDTO dto);

    void updatePublisher(String publisherId, PublisherUpdateDTO dto);

    ResultPageResponseDTO<PublisherListResponseDTO> getPublishers(Integer pages, Integer limit, String sortBy,
                                                                  String direction, String publisherName);

    Publisher findPublisher(String publisherId);
}
