package com.rest.inditex.service;

import com.rest.inditex.model.PriceRequest;
import com.rest.inditex.model.PriceResponse;

import java.util.List;

public interface PriceService {
    List<PriceResponse> getAll ();
    PriceResponse getPriceByApplicationDate (PriceRequest priceRequest);
}