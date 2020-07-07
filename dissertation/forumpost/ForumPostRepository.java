package uk.ac.qub.njoy.dissertation.forumpost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {

    Optional<ForumPost> findById(Long id);
}
