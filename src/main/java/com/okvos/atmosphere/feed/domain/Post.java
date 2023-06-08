package com.okvos.atmosphere.feed.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class Post extends com.okvos.atmosphere.data.feed.entity.Post {
    @Getter
    @Setter
    private boolean isLiked;

    public Post(Optional<com.okvos.atmosphere.data.feed.entity.Post> dbPost) {
        if (dbPost.isPresent()) {
            this.setPost_id(dbPost.get().getPost_id());
            this.setUser_id(dbPost.get().getUser_id());
            this.setText(dbPost.get().getText());
            this.setDate(dbPost.get().getDate());
        }
    }
}
