package com.application.nearpharma.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.application.nearpharma.model.Pharmacy;
import com.application.nearpharma.repository.PharmacyRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final PharmacyRepository repository;

    @PostConstruct
    public void seed() {
        if (repository.count() == 0) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                InputStream is = getClass().getResourceAsStream("/pharmacies-dataset.json");
                List<Pharmacy> pharmacies = mapper.readValue(is, new TypeReference<List<Pharmacy>>() {});
                repository.saveAll(pharmacies);
                System.out.println("Sample pharmacies seeded.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
