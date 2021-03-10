package br.com.purchaseclient.purchase.service;

import org.springframework.data.domain.Page;

import br.com.purchaseclient.purchase.Purchase;

@FunctionalInterface
public interface ListPagePurchaseService {

	Page<Purchase> findPage(Integer searchTerm, Integer page, Integer size);

}