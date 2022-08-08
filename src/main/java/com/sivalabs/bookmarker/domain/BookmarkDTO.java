package com.sivalabs.bookmarker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkDTO {

    private Long id;
    private String title;
    private String url;
    private Instant createdAt;

    public BookmarkDTO(String title, String url, Instant createdAt) {
        this.title = title;
        this.url = url;
        this.createdAt = createdAt;
    }
}
