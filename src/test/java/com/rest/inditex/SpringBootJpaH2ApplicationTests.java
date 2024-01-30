package com.rest.inditex;

import com.rest.inditex.entity.Prices;
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
	public void testEntity() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-H.mm.ss");

		LocalDateTime start_date = LocalDateTime.parse("2020-06-14-00.00.00", formatter);
		LocalDateTime end_date = LocalDateTime.parse("2020-12-31-23.59.59", formatter);
		Prices testPrice = new Prices(1, 1, start_date, end_date, 1, "35455", 0, 35.50, "EUR");

		Assert.isTrue(testPrice.getBrandId() == 1, "brandID INCORRETO, ahora hay: " + testPrice.getBrandId());
		Assert.isTrue(testPrice.getStartDate() == start_date, "start_date INCORRETO, ahora hay: " + testPrice.getStartDate());
		Assert.isTrue(testPrice.getEndDate() == end_date, "end_date INCORRETO, ahora hay: " + testPrice.getEndDate());
		Assert.isTrue(testPrice.getPriceList() == 1, "Tarifa INCORRETA, ahora hay: " + testPrice.getPriceList());
		Assert.isTrue(testPrice.getProductId().equals("35455"), "productID INCORRETO, ahora hay: " + testPrice.getProductId());
		Assert.isTrue(testPrice.getPriority() == 0, "Prioridad INCORRETA, ahora hay: " + testPrice.getPriority());
		Assert.isTrue(testPrice.getPrice() == 35.50, "Precio INCORRETO, ahora hay: " + testPrice.getPrice());
		Assert.isTrue(testPrice.getCurr().equals("EUR"), "Moneda INCORRETA, ahora hay: " + testPrice.getCurr());
	}

	@Test
	public void testModel() {
		/*
		Aquí se harian los test unitarios para las clases PriceRequest y PriceResponse
		 */
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
		PriceResponse priceResponse1 = priceService.getPriceByApplicationDate(priceRequest1);
		Assert.isTrue(priceResponse1.getPrice() == 35.5,
				"Para rq1 " + priceRequest1.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponse1.getPrice());

		PriceRequest priceRequest2 = new PriceRequest(LocalDateTime.parse("2020-06-14-16.00.00", formatter), "35455", 1);
		PriceResponse priceResponse2 = priceService.getPriceByApplicationDate (priceRequest2);
		Assert.isTrue(priceResponse2.getPrice() == 25.45,
				"Para rq2 " + priceRequest2.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponse2.getPrice());

		PriceRequest priceRequest3 = new PriceRequest(LocalDateTime.parse("2020-06-14-21.00.00", formatter), "35455", 1);
		PriceResponse priceResponse3 = priceService.getPriceByApplicationDate (priceRequest3);
		Assert.isTrue(priceResponse3.getPrice() == 35.5,
				"Para rq3 " + priceRequest3.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponse3.getPrice());

		PriceRequest priceRequest4 = new PriceRequest(LocalDateTime.parse("2020-06-15-10.00.00", formatter), "35455", 1);
		PriceResponse priceResponse4 = priceService.getPriceByApplicationDate (priceRequest4);
		Assert.isTrue(priceResponse4.getPrice() == 30.5,
				"Para rq4 " + priceRequest4.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponse4.getPrice());

		PriceRequest priceRequest5 = new PriceRequest(LocalDateTime.parse("2020-06-16-21.00.00", formatter), "35455", 1);
		PriceResponse priceResponse5 = priceService.getPriceByApplicationDate (priceRequest5);
		Assert.isTrue(priceResponse5.getPrice() == 38.95,
				"Para rq5 " + priceRequest5.getApplicationDate() + " precio INCORRETO, ha encontrado: " + priceResponse5.getPrice());
	}
}
