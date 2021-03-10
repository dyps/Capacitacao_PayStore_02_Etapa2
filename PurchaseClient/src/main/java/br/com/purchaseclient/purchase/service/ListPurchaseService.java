package br.com.purchaseclient.purchase.service;

import java.util.List;

import br.com.purchaseclient.purchase.Purchase;

@FunctionalInterface
public interface ListPurchaseService {

	List<Purchase> findAll();

}
