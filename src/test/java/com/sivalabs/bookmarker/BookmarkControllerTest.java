package com.sivalabs.bookmarker;

import com.sivalabs.bookmarker.domain.Bookmark;
import com.sivalabs.bookmarker.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        properties = {
                "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
        }
)
class BookmarkControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp(){
        bookmarkRepository.deleteAllInBatch();

        bookmarks = new ArrayList<>();
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


    @Test
    void should_get_bookmarks() throws  Exception{
        mvc.perform(get("/api/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(15)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(2)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(1)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(false)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(false)))
                ;

    }

}
