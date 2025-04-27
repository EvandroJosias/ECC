package main.java.com.ejsjose.domain.presbiteros;

import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

@Entity( name="tbl_presbiteros")
@Table(name="tbl_presbiteros")
@Getter
@Setter
@AllArgsContructor
@EqualsAndHashCode(of="id")
public class Presbiteros {
    
    @id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Colunm( unique=true )
    private String Name;
    
}
