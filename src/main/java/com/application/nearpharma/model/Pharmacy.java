package com.application.nearpharma.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pharmacies")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pharmacy name is mandatory")
    @Size(max = 100, message = "Pharmacy name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address cannot exceed 200 characters")
    private String address;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90.0")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90.0")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be >= -180.0")
    @DecimalMax(value = "180.0", message = "Longitude must be <= 180.0")
    private Double longitude;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^(\\+\\d{1,3}\\s)?\\d{7,15}$", message = "Invalid phone number format")
    private String phone;

    @NotBlank(message = "Chain name is required")
    @Size(max = 50, message = "Chain name cannot exceed 50 characters")
    private String chain;

    @NotBlank(message = "Pincode is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be exactly 6 digits")
    private String pincode;

    @Size(max = 50, message = "City name cannot exceed 50 characters")
    private String city = "Ahmedabad";

    @Size(max = 50, message = "State name cannot exceed 50 characters")
    private String state = "Gujarat";

    @Column(name = "is_24x7")
    private Boolean is24x7 = false;
}

