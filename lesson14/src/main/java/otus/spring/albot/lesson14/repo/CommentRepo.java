package otus.spring.albot.lesson14.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.lesson14.entity.Note;

public interface CommentRepo extends JpaRepository<Note, Long> {
}
