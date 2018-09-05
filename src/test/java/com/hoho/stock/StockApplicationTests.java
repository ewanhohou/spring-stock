package com.hoho.stock;

import com.hoho.stock.entity.Stock;
import com.hoho.stock.repository.StockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockApplicationTests {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetStock() {
		Stock stock = new Stock();
		stock.setName("test1");
		stock.setSymbol("9999");
		stock = stockRepository.save(stock);

		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/v1/stock/{stockid}");
		Map<String, Object> uriParams = new HashMap<>();
		uriParams.put("stockid", stock.getStockid());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(
				builder.buildAndExpand(uriParams).toUri().toString(),
				HttpMethod.GET, entity, String.class);
		assertTrue("testGetStock Fail:\n" + response.getBody(),
				response.getStatusCode().is2xxSuccessful());
	}

}
