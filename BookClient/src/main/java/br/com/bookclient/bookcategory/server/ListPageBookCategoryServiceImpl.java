package br.com.bookclient.bookcategory.server;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.bookclient.bookcategory.BookCategory;
import br.com.bookclient.bookcategory.BookCategoryRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ListPageBookCategoryServiceImpl implements ListPageBookCategoryService{
	
	private final BookCategoryRepository bookcategoryRepository;
	

	@Override
	 public Page<BookCategory> findPage(String searchTerm, int page, int size) {
		 
		 PageRequest pageRequest = PageRequest.of(
	                page,
	                size,
	                Sort.Direction.ASC,
	                "name");
		 return bookcategoryRepository.findAll(
	                searchTerm.toLowerCase(),
	                pageRequest);
	}


}
