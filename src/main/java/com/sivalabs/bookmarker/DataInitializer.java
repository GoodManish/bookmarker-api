package com.sivalabs.bookmarker;

import com.sivalabs.bookmarker.domain.Bookmark;
import com.sivalabs.bookmarker.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;
    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "Sivalabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Quarkus", "https://quarkus.io", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Micronaut", "https://micronaut.io", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "JOOQ", "https://www.jooq.org", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "VladMihalcea", "https://VladMihalcea.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Thoughts on java", "https://thorben-janssen.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "DZone", "https://dzone.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "DevOpsBookmarks", "https://devopsbookmarks.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kubernetes dos", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Expressjs", "https://expressjs.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Macrobehler", "https://macrobehler.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Bealdung", "https://bealdung.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "devglan", "https://devglan.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "linuxize", "https://linuxsize.com", Instant.now()));
    }
}
