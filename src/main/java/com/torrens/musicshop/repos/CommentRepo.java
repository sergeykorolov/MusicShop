package com.torrens.musicshop.repos;

import com.torrens.musicshop.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Long> {
}
