package br.com.bookclient.book.server;

import org.springframework.data.domain.Page;

import br.com.bookclient.book.Book;

@FunctionalInterface
public interface ListPageBookService {

	Page<Book> findPage(String searchTerm, Integer page, Integer size);

}
