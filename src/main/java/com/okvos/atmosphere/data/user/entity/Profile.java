package com.okvos.atmosphere.data.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profile {
    @Id
    private Integer user_id;
    private String username;
    private String bio;
    private String header_image_url;
    private Integer following_count;
    private Integer follower_count;

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }
    public void setHeader_image_url(String header_image_url) {
        this.header_image_url = header_image_url;
    }

    public Integer getFollowing_count() {
        return following_count;
    }
    public void setFollowing_count(Integer following_count) {
        this.following_count = following_count;
    }

    public Integer getFollower_count() {
        return follower_count;
    }
    public void setFollower_count(Integer follower_count) {
        this.follower_count = follower_count;
    }
}
