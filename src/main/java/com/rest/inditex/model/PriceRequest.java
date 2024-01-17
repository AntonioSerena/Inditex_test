package com.rest.inditex.model;

import java.time.LocalDateTime;

public class PriceRequest {

  private LocalDateTime applicationDate;
  private String productId;
  private long brandId;

  public PriceRequest() {
  }

  public PriceRequest(LocalDateTime applicationDate,  String productId, long brandId) {
    this.applicationDate = applicationDate;
    this.productId = productId;
    this.brandId = brandId;
  }

  public LocalDateTime getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(LocalDateTime applicationDate) {
    this.applicationDate = applicationDate;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public long getBrandId() {
    return brandId;
  }

  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }

  @Override
  public String toString() {
    return "Prices{" +
            ", applicationDate=" + applicationDate +
            ", product_id=" + productId + '\'' +
            ", brandId=" + brandId +
            '}';
  }
}