package luisQuiroz.BE_W5_D3.payloads;

import java.util.UUID;

public record BlogPostsDTO(
        String categoria,
        String titolo,
        String contenuto,
        UUID authorId
) {
}
