package com.torrens.musicshop.repos;

import com.torrens.musicshop.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

    List<Comment> findByInstrumentId(Integer instrumentId);
}