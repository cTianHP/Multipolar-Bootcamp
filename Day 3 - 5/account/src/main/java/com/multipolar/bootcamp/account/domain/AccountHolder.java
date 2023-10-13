package com.multipolar.bootcamp.account.domain;

import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountHolder{
    private String nik;
    private String name;
    private String address;
}
