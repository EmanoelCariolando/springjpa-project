package com.web.aulaproject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.aulaproject.entities.enums.EnumOrder;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Instant moment;
  
  private Integer enums;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;
  
  @OneToMany(mappedBy = "id.order")
  private Set<OrderItem> items = new HashSet<>();

  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private Payment payment;

  public Order() {

  }

  public Order(Long id, Instant moment, EnumOrder enums ,User client) {
    this.id = id;
    this.moment = moment;
    this.client = client;
    setEnums(enums);
  }

  public Set<OrderItem> getItems() {
      return items;
  }

  public EnumOrder getEnums() {
	return EnumOrder.valueOf(enums) ;
}

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public void setEnums(EnumOrder enums) {
	this.enums = enums.getCode();
  }

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public Double getTotal(){
    Double sums = 0.0;
    for(OrderItem x : items){
      sums += x.getSubTotal();
    }
    return sums;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
 

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    return Objects.equals(id, other.id);
  }
}