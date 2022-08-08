package com.sivalabs.bookmarker.domain;

import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {

    public BookmarkDTO toDTO(Bookmark bookmark){
        BookmarkDTO bookmarkDTO = new BookmarkDTO();
        bookmarkDTO.setId(bookmark.getId());
        bookmarkDTO.setTitle(bookmarkDTO.getTitle());
        bookmarkDTO.setUrl(bookmarkDTO.getUrl());
        bookmarkDTO.setCreatedAt(bookmark.getCreatedAt());
        return bookmarkDTO;
    }

}
