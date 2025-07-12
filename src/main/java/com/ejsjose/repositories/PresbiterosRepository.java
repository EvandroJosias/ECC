package com.ejsjose.repositories;

import com.ejsjose.domain.Presbiteros;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PresbiterosRepository extends JpaRepository< Presbiteros, Long> {

    Optional<Presbiteros> findPresbiterosByFdl_name(String fdl_name);

    Optional<Presbiteros> findPresbiterosByFdlId(Long fdlId);

}
