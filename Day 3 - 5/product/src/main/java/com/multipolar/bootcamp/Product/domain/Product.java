package com.multipolar.bootcamp.Product.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class Product implements Serializable {
    @Id
    private String id;
    private String productName;
    private ProductType productType;
    private Double interestRate;
    private Double minimumBalance;
    private Double maximumLoanAmount;
    private String termsAndConditions;
    private LocalDateTime dateOfCreation = LocalDateTime.now();
}
