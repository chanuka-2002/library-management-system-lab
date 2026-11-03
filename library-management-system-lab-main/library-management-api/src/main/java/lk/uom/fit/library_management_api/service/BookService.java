package lk.uom.fit.library_management_api.service;

import java.util.List;
import java.util.Optional;

import lk.uom.fit.library_management_api.model.Book;
import lk.uom.fit.library_management_api.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service 
public class BookService {
    
private final BookRepository bookRepository;
public BookService(BookRepository bookRepository) {
this.bookRepository = bookRepository;
}
public List<Book> getAllBooks() {
return bookRepository.findAll();
}
public Optional<Book> getBookById(Long id) {
return bookRepository.findById(id);
}
public Book createBook(Book book) {
return bookRepository.save(book);
}
public Optional<Book> updateBook(Long id, Book details) {
return bookRepository.findById(id).map(book -> {
book.setTitle(details.getTitle());
book.setAuthor(details.getAuthor());
book.setIsbn(details.getIsbn());
book.setPrice(details.getPrice());
return bookRepository.save(book);
});}
public boolean deleteBook(Long id) {
if (!bookRepository.existsById(id)) {
return false;
}
bookRepository.deleteById(id);
return true;
}

}
