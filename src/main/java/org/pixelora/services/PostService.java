package org.pixelora.services;

import org.pixelora.model.Post;
import org.pixelora.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    //Get individual element
    public Optional<Post> getById(Long id){
        return postRepository.findById(id);
    }

    //Get all element
    public List<Post> getAll(){
        return postRepository.findAll();
    }

    //Delete all element
    public void delete(Post post){
        postRepository.delete(post);
    }

    //Save all element
    public Post save(Post post){
        if(post.getId() == null){
            post.setCreatedAt(LocalDateTime.now());
        }
        return postRepository.save(post);
    }
}