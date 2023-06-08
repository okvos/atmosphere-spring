package com.okvos.atmosphere.data.feed.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Embeddable
@Table(
        indexes = {
                @Index(columnList = "post_id, user_id", unique = true)
        }
)
public class PostLike {
    private Integer post_id;
    private Integer user_id;
}
