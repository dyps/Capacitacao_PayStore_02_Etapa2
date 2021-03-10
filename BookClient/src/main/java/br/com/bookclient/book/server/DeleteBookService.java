package br.com.bookclient.book.server;

@FunctionalInterface
public interface DeleteBookService {

	void delete(Long id);

}
