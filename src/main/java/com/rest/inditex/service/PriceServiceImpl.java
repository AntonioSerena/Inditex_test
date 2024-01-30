package com.rest.inditex.service;

import com.rest.inditex.entity.Prices;
import com.rest.inditex.model.PriceRequest;
import com.rest.inditex.model.PriceResponse;
import com.rest.inditex.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

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
            Prices price = pricesList.get(0);
            return new PriceResponse(price.getProductId(), price.getBrandId(),
                    price.getPriceList(), price.getStartDate(), price.getEndDate(), price.getPrice());
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "PriceService error: ", exc);
        }
    }
}