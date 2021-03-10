package br.com.clientclient.client.service;

import br.com.clientclient.client.Client;

@FunctionalInterface
public interface UpdateClientService {

	void update(Client client, Long id);

}
