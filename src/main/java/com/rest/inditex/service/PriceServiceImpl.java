package com.rest.inditex.service;

import com.rest.inditex.entity.Prices;
import com.rest.inditex.model.PriceRequest;
import com.rest.inditex.model.PriceResponse;
import com.rest.inditex.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<PriceResponse> getAll() {
        List<PriceResponse> priceResponseList = new ArrayList<>();
        for (Prices prices : priceRepository.findAll()) {
            priceResponseList.add(new PriceResponse(
                    prices.getProductId(),
                    prices.getBrandId(),
                    prices.getPriceList(),
                    prices.getStartDate(),
                    prices.getEndDate(),
                    prices.getPrice())
            );
        }
        return priceResponseList;
    }

    @Override
    public PriceResponse getPriceByApplicationDate(PriceRequest priceRequest) {
        try {
            List<Prices> pricesList = priceRepository.findByApplicationDateTime(priceRequest.getProductId(),
                    priceRequest.getBrandId(), priceRequest.getApplicationDate());

            Prices price;
            if (pricesList.size() > 1)
                price = pricesList.stream()
                        .max(Comparator.comparing(Prices::getPriority))
                        .orElseThrow(NoSuchElementException::new);
            else
                price = pricesList.get(0);

            return new PriceResponse(price.getProductId(), price.getBrandId(),
                    price.getPriceList(), price.getStartDate(), price.getEndDate(), price.getPrice());

        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "PriceService error: ", exc);
        }
    }
}