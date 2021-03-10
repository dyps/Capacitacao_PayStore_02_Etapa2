package br.com.clientclient.client.service;

import org.springframework.stereotype.Service;

import br.com.clientclient.client.ClientRepository;
import br.com.clientclient.exceptions.ClientNotDeletedException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteClientServiceImpl implements DeleteClientService {

    private final ClientRepository clientRepository;

    @Override
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotDeletedException();
        }
        clientRepository.deleteById(id);
    }
}
