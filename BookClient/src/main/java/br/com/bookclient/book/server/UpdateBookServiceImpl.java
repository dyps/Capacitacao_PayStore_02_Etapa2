package br.com.bookclient.book.server;

import org.springframework.stereotype.Service;

import br.com.bookclient.book.Book;
import br.com.bookclient.book.BookRepository;
import br.com.bookclient.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateBookServiceImpl implements UpdateBookService {

	private final BookRepository bookRepository;

	@Override
	public void update(Book newBook, Long id) {
		Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		book.setTitle(newBook.getTitle());
		book.setSynopsis(newBook.getSynopsis());
		book.setIsbn(newBook.getIsbn());
		book.setAuthor(newBook.getAuthor());
		book.setYearPublication(newBook.getYearPublication());
		book.setPriceSale(newBook.getPriceSale());
		book.setAvailableQuantity(newBook.getAvailableQuantity());
		book.setBookCategories(newBook.getBookCategories());
		bookRepository.save(book);
	}
}
