package com.ejsjose.domain;

import com.ejsjose.dtos.PresbiterosDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity( name="tbl_presbiteros")
@Table(name="tbl_presbiteros")
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

    public Presbiteros() {}
    
    public Presbiteros( PresbiterosDTO data ) {
        this.name = data.Name();
    }
    
}
