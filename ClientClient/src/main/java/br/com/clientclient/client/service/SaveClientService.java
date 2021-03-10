package br.com.clientclient.client.service;

import br.com.clientclient.client.Client;

@FunctionalInterface
public interface SaveClientService {

	void insert(Client client);

}
