package com.miantsebastien.crud.controller;

import com.miantsebastien.crud.model.Comment;
import com.miantsebastien.crud.repository.CommentRepository;
import com.miantsebastien.crud.repository.ProductRepository;
import com.miantsebastien.crud.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public CommentController(CommentRepository commentRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    /**
     * Create a new comment for a specific product.
     */
    @PostMapping("/product/{productId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable Long productId, @RequestBody Comment comment) {


        return productRepository.findById(productId).map(product -> {
            comment.setProduct(product);
            Comment savedComment = commentRepository.save(comment);
            return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
        }).orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + productId));
    }

    /**
     * Delete a specific comment by its ID.
     */
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        return commentRepository.findById(commentId).map(comment -> {
            commentRepository.delete(comment);
            return new ResponseEntity<>("Commentaire supprimé avec succès", HttpStatus.OK);
        }).orElseThrow(() -> new RuntimeException("Commentaire non trouvé avec l'id : " + commentId));
    }
}
