package com.dreammovie.chaircategory;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loai_ghes")
public class ChairCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    private BigDecimal price;

    @Column (nullable = false)
    private int seatCount;

    // Constructors
    public ChairCategory(){
    }

    public ChairCategory(Long id, String name, String description, BigDecimal price, int seatCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.seatCount = seatCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
