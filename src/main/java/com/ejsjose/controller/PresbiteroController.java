package com.ejsjose.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ejsjose.domain.Presbiteros;
import com.ejsjose.dtos.PresbiterosDTO;
import com.ejsjose.services.PresbiterosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController()
@RequestMapping("/presbiteros")
public class PresbiteroController {
 
    @Autowired
    private PresbiterosService presbiteroService;

    @PostMapping
    public ResponseEntity <Presbiteros> createPresbitero( PresbiterosDTO presbitero ) {
        Presbiteros newPresbitero = presbiteroService.createPresbitero( presbitero );
        return new ResponseEntity<>(newPresbitero, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Presbiteros>> getAllPresbiteros(){
        List<Presbiteros> presbiteros = this.presbiteroService.getAllPresbiteros();
        return new ResponseEntity<>(presbiteros, HttpStatus.OK);
    }
}
