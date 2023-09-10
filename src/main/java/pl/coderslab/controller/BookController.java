package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private BookController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getAllBooks(){
       return bookService.getBooks();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable Long id){
        return this.bookService.get(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Book not found"
        ));
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book){
        bookService.update(book);
    }

}
