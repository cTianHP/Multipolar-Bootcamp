package com.multipolar.bootcamp.gateway.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountDTO implements Serializable {
    private String id;
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private AccountHolder accountHolder;
    private Double balance;
    private LocalDateTime openingDate = LocalDateTime.now();
    private LocalDate closingDate;
}
