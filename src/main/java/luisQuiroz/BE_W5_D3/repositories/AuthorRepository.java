package luisQuiroz.BE_W5_D3.repositories;

import lombok.extern.slf4j.Slf4j;
import luisQuiroz.BE_W5_D3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    boolean existsByEmail(String email);
}
