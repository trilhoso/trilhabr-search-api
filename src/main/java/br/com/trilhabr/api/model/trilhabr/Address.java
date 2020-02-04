package br.com.trilhabr.api.model.trilhabr;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String street;
    private String neighborhood;
    private String city;
    private String postCode;
    private String state;
    private String country;
}
