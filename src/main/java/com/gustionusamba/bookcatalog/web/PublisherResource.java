package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.annotation.LogThisMethod;
import com.gustionusamba.bookcatalog.dto.PublisherCreateDTO;
import com.gustionusamba.bookcatalog.dto.PublisherListResponseDTO;
import com.gustionusamba.bookcatalog.dto.PublisherUpdateDTO;
import com.gustionusamba.bookcatalog.dto.ResultPageResponseDTO;
import com.gustionusamba.bookcatalog.service.PublisherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@Validated
public class PublisherResource {

    private final PublisherService publisherService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/publisher")
    public ResponseEntity<Void> updatePublisher(@RequestBody @Valid PublisherCreateDTO dto) {
        publisherService.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisher")).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Void> updatePublisher(@PathVariable("publisherId") @Size(max = 36, min = 36, message = "publisher.id.not.uuid") String publisherId,
                                                @RequestBody @Valid PublisherUpdateDTO dto) {
        publisherService.updatePublisher(publisherId, dto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @LogThisMethod
    @GetMapping("/v1/publisher")
    public ResponseEntity<ResultPageResponseDTO<PublisherListResponseDTO>> getPublishers(@RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
                                                                                         @RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
                                                                                         @RequestParam(name = "sortBy", required = true, defaultValue = "name") String sortBy,
                                                                                         @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
                                                                                         @RequestParam(name = "publisherName", required = false) String publisherName) {
        return ResponseEntity.ok().body(publisherService.getPublishers(pages, limit, sortBy, direction, publisherName));
    }
}
