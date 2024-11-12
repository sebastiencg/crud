package com.miantsebastien.crud.repository;

import com.miantsebastien.crud.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
