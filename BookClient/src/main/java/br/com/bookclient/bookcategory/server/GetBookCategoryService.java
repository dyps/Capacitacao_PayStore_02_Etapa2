package br.com.bookclient.bookcategory.server;

import br.com.bookclient.bookcategory.BookCategory;

@FunctionalInterface
public interface GetBookCategoryService {

	BookCategory find(Long id);

}

