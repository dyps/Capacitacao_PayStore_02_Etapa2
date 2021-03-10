package br.com.clientclient.client.service;

import java.util.List;

import br.com.clientclient.client.Client;

@FunctionalInterface
public interface ListClientService {

	List<Client> findAll();

}
