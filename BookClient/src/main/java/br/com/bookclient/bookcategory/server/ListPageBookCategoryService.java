package br.com.bookclient.bookcategory.server;

import org.springframework.data.domain.Page;

import br.com.bookclient.bookcategory.BookCategory;

@FunctionalInterface
public interface ListPageBookCategoryService {

	Page<BookCategory> findPage(String nome, int page, int size);


}
