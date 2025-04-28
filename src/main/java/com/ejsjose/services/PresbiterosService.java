package com.ejsjose.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejsjose.domain.Presbiteros;
import com.ejsjose.dtos.PresbiterosDTO;
import com.ejsjose.repositories.PresbiterosRepository;

@Service
public class PresbiterosService {

    @Autowired
    private PresbiterosRepository repository;

    public Presbiteros createPresbitero( PresbiterosDTO data ) {
        Presbiteros newPresbitero = new Presbiteros( data );
        System.out.println("chegou aqui no createPresbitero");
        this.savePresbitero(newPresbitero);
        return newPresbitero;
    }

    public List<Presbiteros> getAllPresbiteros() {
        return this.repository.findAll();
    }
    
    public Presbiteros findPresbiterosbyId( Long id ) throws Exception {
        return this.repository.findPresbiterosById(id).orElseThrow(() -> new Exception("Presbitero não encontrado"));
    }

    public void validate( Presbiteros padre ) throws Exception {
        if( padre.getName().isEmpty() ) {
            throw new Exception("Padre desconhecido");
        }
    }

    public void savePresbitero( Presbiteros prebitero ){
        this.repository.save(prebitero);
    }

}