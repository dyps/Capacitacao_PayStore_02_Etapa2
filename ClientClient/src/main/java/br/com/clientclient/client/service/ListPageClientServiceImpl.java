package br.com.clientclient.client.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.clientclient.client.Client;
import br.com.clientclient.client.ClientRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ListPageClientServiceImpl implements ListPageClientService{
	
	private final ClientRepository clientRepository;
	

	 public Page<Client> findPage(String searchTerm, Integer page, Integer size) {
		 
		 PageRequest pageRequest = PageRequest.of(
	                page,
	                size,
	                Sort.Direction.ASC,
	                "name");
		 return clientRepository.findAll(
	                searchTerm.toLowerCase(),
	                pageRequest);
	}
	

}
