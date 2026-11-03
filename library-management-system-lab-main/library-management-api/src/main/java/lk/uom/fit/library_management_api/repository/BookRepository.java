package lk.uom.fit.library_management_api.repository;

import lk.uom.fit.library_management_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
