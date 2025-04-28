package com.ejsjose.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejsjose.domain.Presbiteros;

public interface PresbiterosRepository extends JpaRepository< Presbiteros, Long> {

    Optional<Presbiteros> findPresbiterosByName(String fdl_name);

    Optional<Presbiteros> findPresbiterosById(Long fdl_id);

}
