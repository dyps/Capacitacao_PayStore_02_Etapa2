package br.com.bookclient.book.server;

import br.com.bookclient.book.Book;

@FunctionalInterface
public interface UpdateBookService {

	void update(Book newBook, Long id);

}
