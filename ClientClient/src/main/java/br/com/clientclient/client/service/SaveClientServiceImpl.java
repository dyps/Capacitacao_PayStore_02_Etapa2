package br.com.clientclient.client.service;

import org.springframework.stereotype.Service;

import br.com.clientclient.client.Client;
import br.com.clientclient.client.ClientRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaveClientServiceImpl implements SaveClientService {

    private final ClientRepository clientRepository;

    @Override
    public void insert(Client client) {
        clientRepository.save(client);
    }
}
