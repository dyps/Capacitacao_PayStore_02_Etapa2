package br.com.purchaseclient.purchase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.purchase.Purchase;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListPurchaseServiceImpl implements ListPurchaseService {

	private final PurchaseRepository purchaseRepository;

	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}

}
