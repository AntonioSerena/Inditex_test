package com.rest.inditex.model;

import java.time.LocalDateTime;

public class PriceResponse {

  private String productId;
  private long brandId;
  private int priceList;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private double price;

  public PriceResponse() {
  }

  public PriceResponse(String productId, long brandId, int priceList, LocalDateTime startDate, LocalDateTime endDate, double price) {
    this.productId = productId;
    this.brandId = brandId;
    this.priceList = priceList;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
  }


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public long getBrandId() { return brandId; }

  public void setBrandId(long brandId) { this.brandId = brandId; }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public int getPriceList() {
    return priceList;
  }

  public void setPriceList(int priceList) {
    this.priceList = priceList;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Prices{" +
            ", product_id=" + productId +
            ", brandId=" + brandId +
            ", price_list=" + priceList +
            ", start_date=" + startDate +
            ", end_date=" + endDate +
            ", price=" + price + '\'' +
            '}';
  }
}