package br.com.purchaseclient.purchase.service;

import org.springframework.stereotype.Service;

import br.com.purchaseclient.purchase.Purchase;
import br.com.purchaseclient.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SavePurchaseServiceImpl implements SavePurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public void insert(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
