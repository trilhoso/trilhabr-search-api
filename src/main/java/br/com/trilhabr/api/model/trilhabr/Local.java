package br.com.trilhabr.api.model.trilhabr;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String idFourSquare;
    private String idTripAdvisor;
    private String name;
    private String latitude;
    private String longitude;
    private String rating;
    private String price;
    private String priceLevel;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String phoneNumber;
    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
    private List<Photo> photoList;



}
