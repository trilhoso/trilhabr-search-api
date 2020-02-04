package br.com.trilhabr.api.model.trilhabr;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_local_photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String photoUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    private Local local;

    public Photo(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
