package com.okvos.atmosphere.data.feed.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    private Integer post_id;

    @Getter
    @Setter
    private Integer user_id;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private Integer date;
}
