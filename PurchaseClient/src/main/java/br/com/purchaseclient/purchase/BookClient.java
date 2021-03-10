package br.com.purchaseclient.purchase;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service")
public interface BookClient {

	@GetMapping("/v1/api/book/")
	List listProducts();

}
