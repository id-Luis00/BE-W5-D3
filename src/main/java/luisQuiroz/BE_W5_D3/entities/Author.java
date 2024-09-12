package luisQuiroz.BE_W5_D3.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "autori")
public class Author {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String email;
    private String urlAvatar;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BlogPost> listBlogs;



}
