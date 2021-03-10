package br.com.bookclient.book.server;

import org.springframework.stereotype.Service;

import br.com.bookclient.book.Book;
import br.com.bookclient.book.BookRepository;
import br.com.bookclient.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetBookServiceImpl implements GetBookService {

    private final BookRepository bookRepository;

    @Override
    public Book find(Long id) {
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

}
