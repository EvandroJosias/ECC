package main.java.com.ecc.domain.entity;

import java.lang.annotation.Inherited;

@Entity( name = "tbl_presbiteros")
@Table( name = "tbl_presbiteros")
@Getter
@Setter
public class PresbiterosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique = true )
    private String nome;

}
