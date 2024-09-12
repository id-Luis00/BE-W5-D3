package luisQuiroz.BE_W5_D3.repositories;


import luisQuiroz.BE_W5_D3.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogPostsRepository extends JpaRepository<BlogPost, UUID> {
    boolean existsByTitolo(String titolo);

}
