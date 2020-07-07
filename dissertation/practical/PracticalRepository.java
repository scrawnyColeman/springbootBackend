package uk.ac.qub.njoy.dissertation.practical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticalRepository extends JpaRepository<Practical, Long> {
}
