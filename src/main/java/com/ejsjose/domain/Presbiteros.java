package com.ejsjose.domain;

import java.util.Date;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="presbiteros")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Presbiteros {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( unique=true )
    private String name;

    private String telefone;

    @Temporal(TemporalType.DATE) // Apenas a data (sem hora)
    private Date ordenacao;

    @Temporal(TemporalType.DATE) // Apenas a data (sem hora)
    private Date natalidade;
    
}
