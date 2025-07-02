package com.application.nearpharma.controller;

import com.application.nearpharma.model.Pharmacy;
import com.application.nearpharma.repository.PharmacyRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pharmacies")
@RequiredArgsConstructor
public class PharmacyController {

    private final PharmacyRepository repository;

    @PostMapping
    public ResponseEntity<Pharmacy> create(@Valid @RequestBody Pharmacy pharmacy) {
        return ResponseEntity.ok(repository.save(pharmacy));
    }

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacy> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePharmacy(@PathVariable Long id) {
        repository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Pharmacy deleted successfully");
        return ResponseEntity.ok(response);
    }

}
