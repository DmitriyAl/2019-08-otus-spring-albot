package otus.spring.albot.lesson14.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import otus.spring.albot.lesson14.entity.Note;
import otus.spring.albot.lesson14.repo.NoteRepo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class NoteServiceImplTest {
    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private NoteService noteService;

    @Test
    void removeNote() {
        List<Note> all = noteRepo.findAll();
        Note note = all.get(0);
        noteService.removeNote(note.getId());
        List<Note> allAfterDeletion = noteRepo.findAll();
        assertThat(allAfterDeletion).hasSize(all.size() - 1).doesNotContain(note);
        assertThat(all).containsAll(allAfterDeletion);
    }
}
