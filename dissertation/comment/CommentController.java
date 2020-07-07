package uk.ac.qub.njoy.dissertation.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    /**
     * Get all comments
     */
    @GetMapping("/comments")
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    /**
     * Get comments of forum post
     */
    @GetMapping("/comments/post/{postId}")
    public List<Comment> getCommentsOfPost(@PathVariable Long postId){
        return commentRepository.findByPostId(postId);
    }
}
