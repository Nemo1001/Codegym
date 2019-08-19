package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double population;
    private double area;
    private double GDP;
    private String description;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    public City() {
    }

    public City(String name, double population, double area, double GDP, String description) {
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

    public Nation getNation() {
        return (nation == null) ? new Nation() : nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
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

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
