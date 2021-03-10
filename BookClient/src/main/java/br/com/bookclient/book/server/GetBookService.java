
package br.com.bookclient.book.server;

import br.com.bookclient.book.Book;

@FunctionalInterface
public interface GetBookService {

	Book find(Long id);

}
