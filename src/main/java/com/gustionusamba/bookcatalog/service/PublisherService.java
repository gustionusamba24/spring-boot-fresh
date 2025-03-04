package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.PublisherCreateDTO;
import com.gustionusamba.bookcatalog.dto.PublisherUpdateDTO;

public interface PublisherService {

    void createPublisher(PublisherCreateDTO dto);

    void updatePublisher(String publisherId, PublisherUpdateDTO dto);
}
