package chapter5.bean;

import java.io.Serializable;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 */
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String countryCode;

    private String district;

    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}