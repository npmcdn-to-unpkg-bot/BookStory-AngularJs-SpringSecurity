package com.Model;

import javax.persistence.*;

/**
 * Created by dexter on 2/12/16.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "order_count")
    private Long order_count;

    public Order(Long user_id, Long book_id) {
        this.user_id = user_id;
        this.order_count = book_id;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getBook_id() {
        return order_count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setBook_id(Long book_id) {
        this.order_count = book_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                "user_id='" + user_id + '\'' +
                ", order_count='" + order_count + '\'' +
                '}';
    }


}
