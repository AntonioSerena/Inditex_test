package com.rest.inditex;

import com.rest.inditex.model.Prices;
import com.rest.inditex.repository.PriceRepository;
import com.rest.inditex.model.PriceRequest;
import com.rest.inditex.model.PriceResponse;
import com.rest.inditex.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class SpringBootJpaH2ApplicationTests {

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private PriceService priceService;

	@Test
	void contextLoad() {
		Assert.notNull(priceRepository, "Repository is null");
		Assert.notNull(priceService, "Service is null");
	}

	@Test
	public void testPriceRepository() {

		if (priceRepository.findAll().size() > 0) priceRepository.deleteAll();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-H.mm.ss");

		LocalDateTime start_date = LocalDateTime.parse("2020-06-14-00.00.00", formatter);
		LocalDateTime end_date = LocalDateTime.parse("2020-12-31-23.59.59", formatter);
		Prices prices1 = new Prices(1, 1, start_date, end_date, 1, "35455", 0, 35.50, "EUR");
		priceRepository.save(prices1);

		start_date = LocalDateTime.parse("2020-06-14-15.00.00", formatter);
		end_date = LocalDateTime.parse("2020-06-14-18.30.00", formatter);
		Prices prices2 = new Prices(2, 1, start_date, end_date, 2, "35456", 0, 25.45, "EUR");
		priceRepository.save(prices2);

		start_date = LocalDateTime.parse("2020-06-15-00.00.00", formatter);
		end_date = LocalDateTime.parse("2020-06-15-11.00.00", formatter);
		Prices prices3 = new Prices(3, 1, start_date, end_date, 3, "35455", 0, 30.50, "EUR");
		priceRepository.save(prices3);

		start_date = LocalDateTime.parse("2020-06-15-16.00.00", formatter);
		end_date = LocalDateTime.parse("2020-12-31-23.59.59", formatter);
		Prices prices4 = new Prices(4, 1, start_date, end_date, 4, "35456", 0, 38.95, "EUR");
		priceRepository.save(prices4);

		List<Prices> prices = priceRepository.findAll();
		Assert.notNull(prices1, "No se ha creado el precio");
		Assert.notEmpty (prices, "No se han guardado precios");
		Assert.isTrue(prices.size() == 4, "No sean guardado los precios que se han creado, ahora hay: " + prices.size());
	}

	@Test
	public void testPriceService() {
		Assert.notEmpty(priceService.getAll(), "   PRICES empty");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-H.mm.ss");

		PriceRequest priceRequest1 = new PriceRequest(LocalDateTime.parse("2020-06-14-10.00.00", formatter), "35455", 1);
		List <PriceResponse> priceResponseList1 = priceService.getPriceByApplicationDate (priceRequest1);
		Assert.isTrue(priceResponseList1.get(0).getPrice() == 35.5,
				"Para " + priceRequest1.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponseList1.get(0).getPrice());

		PriceRequest priceRequest2 = new PriceRequest(LocalDateTime.parse("2020-06-14-16.00.00", formatter), "35455", 1);
		List <PriceResponse> priceResponseList2 = priceService.getPriceByApplicationDate (priceRequest2);
		Assert.isTrue(priceResponseList2.get(0).getPrice() == 35.5,
				"Para " + priceRequest2.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponseList2.get(0).getPrice());

		PriceRequest priceRequest3 = new PriceRequest(LocalDateTime.parse("2020-06-14-21.00.00", formatter), "35455", 1);
		List <PriceResponse> priceResponseList3 = priceService.getPriceByApplicationDate (priceRequest3);
		Assert.isTrue(priceResponseList3.get(0).getPrice() == 35.5,
				"Para " + priceRequest3.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponseList3.get(0).getPrice());

		PriceRequest priceRequest4 = new PriceRequest(LocalDateTime.parse("2020-06-15-10.00.00", formatter), "35455", 1);
		List <PriceResponse> priceResponseList4 = priceService.getPriceByApplicationDate (priceRequest4);
		Assert.isTrue(priceResponseList4.size() == 2,
		"Para " + priceRequest4.getApplicationDate() + " ha encontrado " + priceResponseList4.size() + " precios\n" + priceResponseList4  );

		PriceRequest priceRequest5 = new PriceRequest(LocalDateTime.parse("2020-06-16-21.00.00", formatter), "35455", 1);
		List <PriceResponse> priceResponseList5 = priceService.getPriceByApplicationDate (priceRequest5);
		Assert.isTrue(priceResponseList5.get(0).getPrice() == 35.5,
				"Para " + priceRequest5.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponseList5.get(0).getPrice());
	}
}
