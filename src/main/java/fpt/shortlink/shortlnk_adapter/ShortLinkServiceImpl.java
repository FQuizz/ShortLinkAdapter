package fpt.shortlink.shortlnk_adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ShortLinkServiceImpl implements ShortLinkService{
    private final ShortLinkRepository shortLinkRepository;
    @Override
    public Optional<ShortLink> getShortLink(String shortCode) {
        return shortLinkRepository.findByShortCode(shortCode);
    }

    @Override
    public Optional<ShortLink> createShortLink(ShortLink shortLink) {
        return Optional.of(shortLinkRepository.save(shortLink));
    }

    @Override
    public void updateShortLink(String shortCode, ShortLink shortLink) {
        ShortLink _shortLink = shortLinkRepository.findByShortCode(shortCode)
            .orElseThrow(() -> new RuntimeException(""));
        Optional.ofNullable(shortLink.getOriginalUrl()).ifPresent(_shortLink::setOriginalUrl);
        Optional.ofNullable(shortLink.getIsActive()).ifPresent(_shortLink::setIsActive);
        shortLinkRepository.save(_shortLink);
    }

    @Override
    public void deleteShortLink(String shortCode) {
        shortLinkRepository.deleteByShortCode(shortCode);
    }
}
