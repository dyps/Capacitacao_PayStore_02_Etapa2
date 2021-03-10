package br.com.bookclient.bookcategory.server;

import br.com.bookclient.bookcategory.BookCategory;

@FunctionalInterface
public interface UpdateBookCategoryService {

	void update(BookCategory cliente, Long id);

}