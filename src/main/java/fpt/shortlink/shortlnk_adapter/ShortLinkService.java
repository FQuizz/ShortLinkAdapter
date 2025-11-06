package fpt.shortlink.shortlnk_adapter;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface ShortLinkService {
    @GetMapping("get-short-link/{shortCode}")
    Optional<ShortLink> getShortLink(@PathVariable String shortCode);
    @PostMapping("create-short-link")
    Optional<ShortLink> createShortLink(@RequestBody ShortLink shortLink);
    @PutMapping("update-short-link/{shortCode}")
    void updateShortLink(@PathVariable String shortCode, @RequestBody ShortLink shortLink);
    @DeleteMapping("delete-short-link/{shortCode}")
    void deleteShortLink(@PathVariable String shortCode);
}
