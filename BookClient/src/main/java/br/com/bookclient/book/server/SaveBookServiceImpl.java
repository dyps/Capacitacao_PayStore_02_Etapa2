package br.com.bookclient.book.server;

import org.springframework.stereotype.Service;

import br.com.bookclient.book.Book;
import br.com.bookclient.book.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaveBookServiceImpl implements SaveBookService {

    private final BookRepository bookRepository;

    @Override
    public void insert(Book book) {
        bookRepository.save(book);
    }
}
