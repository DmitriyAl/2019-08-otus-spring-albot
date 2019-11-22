package otus.spring.albot.lesson14.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import otus.spring.albot.lesson14.entity.Note;
import otus.spring.albot.lesson14.entity.Product;
import otus.spring.albot.lesson14.repo.NoteRepo;
import otus.spring.albot.lesson14.repo.ProductRepo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ProductServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private ProductRepo productRepo;

    @Test
    void deleteProduct() {
        List<Product> all = productRepo.findAll();
        Product product = all.get(0);
        List<Note> productNotes = product.getNotes();
        List<Note> allNotes = noteRepo.findAll();
        productService.deleteProduct(product.getId());
        List<Product> allAfterDeletion = productRepo.findAll();
        assertThat(allAfterDeletion).doesNotContain(product).hasSize(all.size() - 1);
        List<Note> notesAfterDeletion = noteRepo.findAll();
        assertThat(notesAfterDeletion).doesNotContain(productNotes.toArray(new Note[0])).hasSize(allNotes.size() - productNotes.size());
    }
}
