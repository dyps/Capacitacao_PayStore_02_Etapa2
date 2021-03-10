package br.com.bookclient.book.server;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.bookclient.book.Book;
import br.com.bookclient.book.BookRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ListPageBookServiceImpl implements ListPageBookService{
	
	private final BookRepository bookRepository;
	

	 public Page<Book> findPage(String searchTerm, Integer page, Integer size) {
		 
		 PageRequest pageRequest = PageRequest.of(
	                page,
	                size,
	                Sort.Direction.ASC,
	                "title");
		 return bookRepository.findAll(
	                searchTerm.toLowerCase(),
	                pageRequest);
	}
	

}
