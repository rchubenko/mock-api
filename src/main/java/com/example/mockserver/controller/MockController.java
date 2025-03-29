package com.example.mockserver.controller;

import com.example.mockserver.dto.MockDto;
import com.example.mockserver.model.MockEntity;
import com.example.mockserver.service.MockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mocks")
@RequiredArgsConstructor
public class MockController {
    private final MockService mockService;

    @GetMapping
    public ResponseEntity<List<MockEntity>> getAllMocks() {
        return ResponseEntity.ok(mockService.getAllMocks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MockEntity> getMockById(@PathVariable String id) {
        return mockService.getMockById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MockEntity> createMock(@RequestBody MockDto mockDto) {
        return ResponseEntity.ok(mockService.createMock(mockDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MockEntity> updateMock(@PathVariable String id, @RequestBody MockDto mockDto) {
        return mockService.updateMock(id, mockDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMock(@PathVariable String id) {
        mockService.deleteMock(id);
        return ResponseEntity.noContent().build();
    }
}
