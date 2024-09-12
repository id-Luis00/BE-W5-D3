package luisQuiroz.BE_W5_D3.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Random;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "blogposts")
public class BlogPost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String categoria;
    private String titolo;
    private String urlCover;
    private String contenuto;
    private int tempoDiLettura;


    public BlogPost(String categoria, String titolo, String contenuto) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        final Random random = new Random();
        this.tempoDiLettura = random.nextInt(1, 300);
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}
