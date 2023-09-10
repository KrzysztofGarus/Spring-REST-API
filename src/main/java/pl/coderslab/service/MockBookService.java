package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService{
    private List<Book> books;
    private static Long nextId;
    private List<Long> idList;
    public MockBookService() {
        books = new ArrayList<>(0);
        idList = new ArrayList<>(0);
        for (int i = 1; i< 11; i++){
            idList.add((long) i);
        }
        nextId = 11L;
        books.add(new Book(1L, "1234567890", "Book 1", "Author 1", "Publisher 1", "Type 1"));
        books.add(new Book(2L, "2345678901", "Book 2", "Author 2", "Publisher 2", "Type 2"));
        books.add(new Book(3L, "3456789012", "Book 3", "Author 3", "Publisher 3", "Type 3"));
        books.add(new Book(4L, "4567890123", "Book 4", "Author 4", "Publisher 4", "Type 4"));
        books.add(new Book(5L, "5678901234", "Book 5", "Author 5", "Publisher 5", "Type 5"));
        books.add(new Book(6L, "6789012345", "Book 6", "Author 6", "Publisher 6", "Type 6"));
        books.add(new Book(7L, "7890123456", "Book 7", "Author 7", "Publisher 7", "Type 7"));
        books.add(new Book(8L, "8901234567", "Book 8", "Author 8", "Publisher 8", "Type 8"));
        books.add(new Book(9L, "9012345678", "Book 9", "Author 9", "Publisher 9", "Type 9"));
        books.add(new Book(10L, "0123456789", "Book 10", "Author 10", "Publisher 10", "Type 10"));
    }
    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Book book) {

    }
}
