package com.okvos.atmosphere.feed;

import com.okvos.atmosphere.data.feed.repository.PostRepository;
import com.okvos.atmosphere.feed.domain.Post;
import com.okvos.atmosphere.feed.exceptions.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable Integer postId) throws PostNotFoundException {
        Optional<com.okvos.atmosphere.data.feed.entity.Post> dbPost = postRepository.findById(postId);
        System.out.println(dbPost);
        if (dbPost.isEmpty()) {
            throw new PostNotFoundException("Post not found");
        }
        Post postResponse = new Post(dbPost);
        postResponse.setLiked(true);
        return postResponse;
    }


}
