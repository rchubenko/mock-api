package com.example.mockserver.service;

import com.example.mockserver.dto.MockDto;
import com.example.mockserver.model.MockEntity;
import com.example.mockserver.repository.MockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MockService {
    private final MockRepository mockRepository;

    public List<MockEntity> getAllMocks() {
        return mockRepository.findAll();
    }

    public Optional<MockEntity> getMockById(String id) {
        return mockRepository.findById(id);
    }

    public MockEntity createMock(MockDto mockDto) {
        MockEntity mockEntity = MockEntity.builder()
                .uri(mockDto.getUri())
                .method(mockDto.getMethod())
                .response(mockDto.getResponse())
                .statusCode(mockDto.getStatusCode())
                .build();
        return mockRepository.save(mockEntity);
    }

    public Optional<MockEntity> updateMock(String id, MockDto mockDto) {
        return mockRepository.findById(id).map(existingMock -> {
            existingMock.setUri(mockDto.getUri());
            existingMock.setMethod(mockDto.getMethod());
            existingMock.setResponse(mockDto.getResponse());
            existingMock.setStatusCode(mockDto.getStatusCode());
            return mockRepository.save(existingMock);
        });
    }

    public void deleteMock(String id) {
        mockRepository.deleteById(id);
    }
}
