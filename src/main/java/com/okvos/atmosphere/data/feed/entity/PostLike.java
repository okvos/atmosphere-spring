package com.okvos.atmosphere.data.feed.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
        schema = "feed",
        name = "post_like",
        indexes = {
                @Index(columnList = "post_id, user_id", unique = true)
        }
)
public class PostLike {
    @EmbeddedId
    private PostLikeKey postLikeKey;

    private Integer post_id;
    private Integer user_id;
}
