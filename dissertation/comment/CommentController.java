package uk.ac.qub.njoy.dissertation.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.exceptions.ResourceNotFoundException;
import uk.ac.qub.njoy.dissertation.forumpost.ForumPost;
import uk.ac.qub.njoy.dissertation.forumpost.ForumPostRepository;
import uk.ac.qub.njoy.dissertation.user.User;
import uk.ac.qub.njoy.dissertation.user.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepo;
    @Autowired
    ForumPostRepository forumPostRepository;

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

    /**
     * create new comment on forum post
     */
    @PostMapping(value = "/comments/{userId}/{postId}")
    public Comment createHelpPost(@PathVariable Long userId,
                                  @PathVariable Long postId,
                                  @Validated @RequestBody Comment bodyComment){
        ForumPost post = forumPostRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));

        Comment newComment = new Comment(
                bodyComment.getComment(),
                bodyComment.getParentId(),
                bodyComment.getNestingValue(),
                userId,
                postId);


        return commentRepository.save(newComment);
    }

    @PutMapping(value="/comments/edit/{commentId}")
    public Comment editComment(@PathVariable Long commentId,
                               @Validated @RequestBody Comment comment){

        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));

        existingComment.setComment(comment.getComment());

        return commentRepository.save(existingComment);
    }
    @PutMapping(value="/comments/delete/{commentId}")
    public Comment deleteComment(@PathVariable Long commentId){

        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));

        User anonUser = userRepo.findById(9999L)
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", 9999L));
                ;

        existingComment.setAuthor(anonUser);
        existingComment.setComment("This comment has been deleted.");

        return commentRepository.save(existingComment);
    }

}
