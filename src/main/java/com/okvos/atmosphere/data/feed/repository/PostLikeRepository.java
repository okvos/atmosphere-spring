package com.okvos.atmosphere.data.feed.repository;

import com.okvos.atmosphere.data.feed.entity.PostLike;
import com.okvos.atmosphere.data.feed.entity.PostLikeKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends CrudRepository<PostLike, PostLikeKey> {
    @Query("select case when count(p)> 0 then true else false end from PostLike p where p.user_id = :user_id and p.post_id = :post_id")
    boolean userIdLikedPostId(Integer user_id, Integer post_id);
}
