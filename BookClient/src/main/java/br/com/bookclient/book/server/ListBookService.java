package br.com.bookclient.book.server;

import java.util.List;

import br.com.bookclient.book.Book;

@FunctionalInterface
public interface ListBookService {

	List<Book> findAll();

}
