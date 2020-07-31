package uk.ac.qub.njoy.dissertation.comment;

import uk.ac.qub.njoy.dissertation.forumpost.ForumPost;
import uk.ac.qub.njoy.dissertation.user.User;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "parent_comment_id")
    private Long parentId;

    @Column(name = "nesting_value")
    private String nestingValue;

    @ManyToOne
    private User author;

    @ManyToOne
    private ForumPost post;

    public Comment(Long id) {
        this.id = id;
    }

    public Comment(String comment, Long parentId, String nestingValue, Long authorId, Long postId) {
        this.comment = comment;
        this.parentId = parentId;
        this.nestingValue = nestingValue;
        author = new User(authorId);
        post = new ForumPost(postId);
    }

    public Comment (String comment, Long parentId, String nestingValue, Long authorId, ForumPost post){
        this.comment = comment;
        this.parentId = parentId;
        this.nestingValue = nestingValue;
        author = new User(authorId);
        post = new ForumPost(post.getId());
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getNestingValue() {
        return nestingValue;
    }

    public void setNestingValue(String nestingValue) {
        this.nestingValue = nestingValue;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public ForumPost getPost() {
        return post;
    }

    public void setPost(ForumPost post) {
        this.post = post;
    }
}
