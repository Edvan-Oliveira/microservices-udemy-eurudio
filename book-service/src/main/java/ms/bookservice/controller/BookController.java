package ms.bookservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ms.bookservice.BookRepository;
import ms.bookservice.model.Book;
import ms.bookservice.proxy.CambioProxy;
import ms.bookservice.response.Cambio;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name = "Book endpoint")
@RequiredArgsConstructor
@RestController
@RequestMapping("book-service")
public class BookController {

    private final BookRepository repository;
    private final CambioProxy proxy;
    private final Environment environment;

    @Operation(summary = "Find a specific book by its ID")
    @ApiResponse(responseCode = "200", description = "Book found successfully")
    @GetMapping("/{id}/{currency}")
    public Book findBook(@PathVariable Long id, @PathVariable String currency) {

        Optional<Book> optionalBook = repository.findById(id);

        if (optionalBook.isEmpty()) throw new RuntimeException("Book Not Found");

        var port = environment.getProperty("local.server.port");

        Book book = optionalBook.get();

        Cambio cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        if (cambio != null) {
            book.setPrice(cambio.getConvertedValue());
            book.setCurrency(cambio.getTo());
            book.setEnvironment(String.format("book-service (%s) | cambio-servie (%s)", port, cambio.getEnvironment()));
        }

        return book;
    }
}
