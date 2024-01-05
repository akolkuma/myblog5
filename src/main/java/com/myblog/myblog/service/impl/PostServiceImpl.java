package com.myblog.myblog.service.impl;

import com.myblog.myblog.entity.Post;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
 private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitel(postDto.getTitel());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
       Post SavePost  = postRepository.save(post);
        PostDto dto = new PostDto();
        dto.setTitel(SavePost.getTitel());
        dto.setDescription(SavePost.getDescription());
        dto.setContent(SavePost.getContent());
        return dto;
    }
}
