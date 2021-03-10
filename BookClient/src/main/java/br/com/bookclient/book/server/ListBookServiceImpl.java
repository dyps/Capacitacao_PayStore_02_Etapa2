package br.com.bookclient.book.server;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bookclient.book.Book;
import br.com.bookclient.book.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListBookServiceImpl implements ListBookService {

	private final BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

}
