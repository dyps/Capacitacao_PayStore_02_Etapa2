package br.com.clientclient.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.clientclient.client.Client;
import br.com.clientclient.client.ClientRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListClientServiceImpl implements ListClientService {

	private final ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

}
