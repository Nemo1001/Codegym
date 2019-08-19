package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String population;
    private String area;
    private String GDP;
    private String description;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    public City() {
    }

    public City(String name, String population, String area, String GDP, String description) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.GDP = GDP;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("name[id=%d, population='%s', area='%s', GDP='%s', description='%s']", id, name, population,area,GDP,description);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
