package uk.ac.qub.njoy.dissertation.forumpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Optional<ForumPost> getPostById(@PathVariable Long id){
        return forumPostRepo.findById(id);
    }
}
