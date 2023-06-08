package com.okvos.atmosphere.data.feed.repository;

import com.okvos.atmosphere.data.feed.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
