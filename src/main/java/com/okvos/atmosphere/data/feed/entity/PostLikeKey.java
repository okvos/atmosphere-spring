package com.okvos.atmosphere.data.feed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PostLikeKey implements Serializable {
    @Column
    Integer postId;
    @Column
    Integer userId;
}
