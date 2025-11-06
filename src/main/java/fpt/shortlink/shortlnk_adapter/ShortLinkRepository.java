package fpt.shortlink.shortlnk_adapter;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShortLinkRepository extends MongoRepository<ShortLink, UUID> {
    Optional<ShortLink> findByShortCode(String shortCode);

    void deleteByShortCode(String shortCode);
}
