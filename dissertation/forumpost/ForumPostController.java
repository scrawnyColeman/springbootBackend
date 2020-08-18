package uk.ac.qub.njoy.dissertation.forumpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
public class ForumPostController {

    @Autowired
    ForumPostRepository forumPostRepo;

    /**
     * get all forum posts
     */
    @GetMapping(value = "/forum_posts")
    public List<ForumPost> getAllPosts(){
        return forumPostRepo.findAll();
    }
    /**
     * get all forum posts
     * @return
     */
    @GetMapping(value = "/forum_posts/{id}")
    public ForumPost getPostById(@PathVariable Long id){
        return forumPostRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("ForumPost","id",id));
    }

    /**
     * get forum post by lesson
     * @return
     */
    @GetMapping(value = "/forum_posts/lesson/{id}")
    public ForumPost getPostByLessonId(@PathVariable Long id){
        return forumPostRepo.findByLessonId(id);
    }

    /**
     * create new forum post [HELP]
     */
    @PostMapping(value = "/forum_posts")
    public ForumPost createHelpPost(@Validated @RequestBody ForumPost post){

        ForumPost newPost = new ForumPost(post.getTitle(), post.getQuestion());
        return forumPostRepo.save(newPost);
    }
}
