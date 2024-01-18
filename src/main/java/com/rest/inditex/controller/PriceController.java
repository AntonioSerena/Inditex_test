package com.rest.inditex.controller;

import com.rest.inditex.entity.Prices;
import com.rest.inditex.model.PriceRequest;
import com.rest.inditex.model.PriceResponse;
import com.rest.inditex.service.PriceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceController {

  private final PriceServiceImpl PriceServiceImpl;

  public PriceController(PriceServiceImpl priceServiceImpl) {
    this.PriceServiceImpl = priceServiceImpl;
  }

  @RequestMapping()
  public @ResponseBody String runningOk() {
        return "Test API ok";
  }

  @GetMapping("/allPrices")
  public ResponseEntity<List<PriceResponse>> getAllPrices() {
      List<PriceResponse> pricesList = PriceServiceImpl.getAll();
      return new ResponseEntity<>(pricesList, HttpStatus.OK);
  }

  @GetMapping("/price")
  public ResponseEntity<List<PriceResponse>>getPrice(@RequestBody PriceRequest priceRequest) {
    try {

      List<PriceResponse> priceResponseList = PriceServiceImpl.getPriceByApplicationDate(priceRequest);

      return new ResponseEntity<>(priceResponseList, HttpStatus.OK);

    } catch (Exception exc) {
      throw new ResponseStatusException(
              HttpStatus.SERVICE_UNAVAILABLE, "PriceController error: ", exc);
    }
  }
}