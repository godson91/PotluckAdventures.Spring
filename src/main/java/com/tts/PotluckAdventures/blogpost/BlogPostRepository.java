package com.tts.PotluckAdventures.blogpost;

import org.springframework.data.repository.CrudRepository;

import com.tts.PotluckAdventures.BlogPost;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

}
