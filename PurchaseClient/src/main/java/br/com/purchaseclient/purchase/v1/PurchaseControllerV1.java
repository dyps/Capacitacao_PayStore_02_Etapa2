package br.com.purchaseclient.purchase.v1;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.purchaseclient.purchase.BookDTO;
import br.com.purchaseclient.purchase.Purchase;
import br.com.purchaseclient.purchase.PurchaseDTO;
import br.com.purchaseclient.purchase.service.DeletePurchaseService;
import br.com.purchaseclient.purchase.service.GetBookService;
import br.com.purchaseclient.purchase.service.GetClientService;
import br.com.purchaseclient.purchase.service.GetPurchaseService;
import br.com.purchaseclient.purchase.service.ListPagePurchaseService;
import br.com.purchaseclient.purchase.service.ListPurchaseService;
import br.com.purchaseclient.purchase.service.SavePurchaseService;
import br.com.purchaseclient.purchase.service.UpdatePurchaseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api/purchase")
@EnableFeignClients(basePackages = "br.com.purchaseclient.purchase.service")
public class PurchaseControllerV1 {

	private final GetPurchaseService getPurchaseService;
	private final ListPurchaseService listPurchaseService;
	private final ListPagePurchaseService listPagePurchaseService;
	private final SavePurchaseService savePurchaseService;
	private final UpdatePurchaseService updatePurchaseService;
	private final DeletePurchaseService deletePurchaseService;
	private final GetClientService getClientService;
	private final GetBookService getBookService;

	@GetMapping(value = "/{id}")
	public PurchaseDTO find(@PathVariable("id") Long id) {
		PurchaseDTO compra = PurchaseDTO.from(getPurchaseService.find(id));
		buscarClienteELivros(compra);
		return compra;
	}

	@GetMapping
	public List<PurchaseDTO> findAll() {
		List<PurchaseDTO> lista = PurchaseDTO.fromAll(listPurchaseService.findAll());
		for (PurchaseDTO compra : lista) 
			buscarClienteELivros(compra);
		return lista;
	}

	private void buscarClienteELivros(PurchaseDTO compra) {
		compra.setClient(getClientService.find(compra.getClient().getId()));
		List<BookDTO> listalivros = new ArrayList<BookDTO>();
		for (BookDTO book : compra.getBooks())
			listalivros.add(getBookService.find(book.getId()));
		compra.setBooks(listalivros);
	}

	@GetMapping("/search")
	public Page<PurchaseDTO> search(@RequestParam(value = "cliente_id", required = false) Integer searchTerm,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		Page<PurchaseDTO> paginas = PurchaseDTO.fromPage(listPagePurchaseService.findPage(searchTerm, page, size));
		
		for(PurchaseDTO compra : paginas.getContent()) 
			buscarClienteELivros(compra);
		
		return  paginas ;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping // adiciona um novo Purchase
	public void insert(@Valid @RequestBody PurchaseDTO purchaseDTO) {
		buscarClienteELivros(purchaseDTO);
		savePurchaseService.insert(Purchase.to(purchaseDTO));
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@PutMapping(value = "/{id}") // atualizar um Purchase
	public void update(@Valid @RequestBody PurchaseDTO purchaseDTO, @PathVariable Long id) {
		buscarClienteELivros(purchaseDTO);
		updatePurchaseService.update(Purchase.to(purchaseDTO), id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}") // Deleta Purchase
	public void delete(@PathVariable Long id) {
		deletePurchaseService.delete(id);
	}

}
