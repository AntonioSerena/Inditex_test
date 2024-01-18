package com.rest.inditex.service;

import com.rest.inditex.model.PriceRequest;
import com.rest.inditex.model.PriceResponse;
import com.rest.inditex.entity.Prices;

import java.util.List;

public interface PriceService {
    List<PriceResponse> getAll ();
    PriceResponse getPriceByApplicationDate (PriceRequest priceRequest);
}