package com.okvos.atmosphere.feed;

import com.okvos.atmosphere.data.feed.repository.PostLikeRepository;
import com.okvos.atmosphere.data.feed.repository.PostRepository;
import com.okvos.atmosphere.feed.domain.Post;
import com.okvos.atmosphere.feed.exceptions.PostNotFoundException;
import com.okvos.atmosphere.security.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private PostLikeRepository postLikeRepository;


    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable Integer postId) throws PostNotFoundException {

        Optional<com.okvos.atmosphere.data.feed.entity.Post> dbPost = postRepository.findById(postId);
        if (dbPost.isEmpty()) {
            throw new PostNotFoundException("Post not found");
        }
        Post postResponse = new Post(dbPost);
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user instanceof User) {
            boolean isLiked = postLikeRepository.userIdLikedPostId(
                    ((User) user).getUserId(),
                    dbPost.get().getPost_id()
            );
            postResponse.setLiked(isLiked);
        }

        return postResponse;
    }


}
