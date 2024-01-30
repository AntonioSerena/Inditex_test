package com.rest.inditex.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
public class Prices {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "BRAND_ID")
  private long brandId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "START_DATE")
  private LocalDateTime startDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "END_DATE")
  private LocalDateTime endDate;

  @Column(name = "PRICE_LIST")
  private int priceList;

  @Column(name = "PRODUCT_ID")
  private String productId;

  @Column(name = "PRIORITY")
  private int priority;

  @Column(name = "PRICE")
  private double price;

  @Column(name = "CURR")
  private String curr;

  public Prices() {
  }

  public Prices(long id, long brandId, LocalDateTime startDate, LocalDateTime endDate, int priceList, String productId, int priority, double price, String curr) {
    this.id = id;
    this.brandId = brandId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.priceList = priceList;
    this.productId = productId;
    this.priority = priority;
    this.price = price;
    this.curr = curr;
  }

  public long getId() {
    return id;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public long getBrandId() {
    return brandId;
  }

  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }

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

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCurr() {
    return curr;
  }

  public void setCurr(String curr) {
    this.curr = curr;
  }

  @Override
  public String toString() {
    return "Prices{" +
            "Id=" + id +
            ", brandId=" + brandId +
            ", start_date=" + startDate +
            ", end_date=" + endDate +
            ", price_list=" + priceList +
            ", product_id=" + productId +
            ", priority=" + priority +
            ", price=" + price +
            ", curr='" + curr + '\'' +
            '}';
  }
}