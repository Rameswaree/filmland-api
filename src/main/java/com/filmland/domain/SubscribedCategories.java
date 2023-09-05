package com.filmland.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class for subscribedCategories table
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "subscribedCategories")
public class SubscribedCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "userName")
    private String userName;
    @Column(name = "subscribedContent")
    private String subscribedContent;
    @Column(name = "price")
    private Double price;
    @Column(name = "subscribedDate")
    private LocalDateTime subscribedDate;
    @Column(name = "startDate")
    private LocalDateTime startDate;

    public SubscribedCategories(String name, String userName, String subscribedContent, Double price, LocalDateTime subscribedDate, LocalDateTime startDate) {
        this.name = name;
        this.userName = userName;
        this.subscribedContent = subscribedContent;
        this.price = price;
        this.subscribedDate = subscribedDate;
        this.startDate = startDate;
    }
}
