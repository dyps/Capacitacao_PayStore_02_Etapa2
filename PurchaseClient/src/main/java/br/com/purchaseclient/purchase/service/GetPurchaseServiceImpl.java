package br.com.purchaseclient.purchase.service;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.exceptions.PurchaseNotFoundException;
import br.com.purchaseclient.purchase.Purchase;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetPurchaseServiceImpl implements GetPurchaseService {

    private final PurchaseRepository purchaseRepository;

    public Purchase find(Long id) {
		return purchaseRepository.findById(id).orElseThrow(PurchaseNotFoundException::new);
    }

}
