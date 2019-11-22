package otus.spring.albot.lesson20.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.lesson20.entity.Note;

public interface NoteRepo extends JpaRepository<Note, Long> {
}
