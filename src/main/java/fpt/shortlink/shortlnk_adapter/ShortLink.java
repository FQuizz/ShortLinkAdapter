package fpt.shortlink.shortlnk_adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "shortlinks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortLink {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    @Indexed(unique = true)
    private String shortCode;
    private String originalUrl;
    @CreatedDate
    @Builder.Default
    private LocalDateTime createAt = LocalDateTime.now();
    @CreatedBy
    private String createBy;
    @Builder.Default
    private Long clickCount = 0L;
    @Builder.Default
    private Boolean isActive = Boolean.TRUE;
}
