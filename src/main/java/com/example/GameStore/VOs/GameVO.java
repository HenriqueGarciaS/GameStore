package com.example.GameStore.VOs;

import java.math.BigDecimal;

public class GameVO {

    private String name;
    private String releaseDate;
    private String availableSystems;
    private BigDecimal price;
    private String genres;

    public GameVO(){}

    public GameVO(String name, String releaseDate, String availableSystems, BigDecimal price, String genres) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.availableSystems = availableSystems;
        this.price = price;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAvailableSystems() {
        return availableSystems;
    }

    public void setAvailableSystems(String availableSystems) {
        this.availableSystems = availableSystems;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
