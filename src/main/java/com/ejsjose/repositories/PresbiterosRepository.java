package main.java.com.ejsjose.repositories;

import main.java.com.ejsjose.domain.presbiteros.Presbiteros;

public interface PresbiterosRepository extends JpaRepository< Presbiteros, Long> {

    Optional<Presbiteros> findPresbiterosByName(String name);

    Optional<Presbiteros> findPresbiterosById(Long id);

}
