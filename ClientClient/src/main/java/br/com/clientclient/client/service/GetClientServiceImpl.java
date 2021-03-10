package br.com.clientclient.client.service;

import org.springframework.stereotype.Service;

import br.com.clientclient.client.Client;
import br.com.clientclient.client.ClientRepository;
import br.com.clientclient.exceptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetClientServiceImpl implements GetClientService {

    private final ClientRepository clientRepository;

    public Client find(Long id) {
		return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

}
