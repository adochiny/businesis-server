package za.co.openset.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Calendar;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by adonis on 2015/06/04.
 */
@Entity
@Table(name="currency")
public class Currency extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "currency_seq")
    @SequenceGenerator(name = "currency_seq", sequenceName = "currency_seq")
    @Column(name = "currency_id")
    private Long currencyId;

    @Column(name = "currency",
            length = 3, unique = true)
    private String currency;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "currency_desc")
    private String currencyDesc;

    @Column(name = "country", length = 100)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    private String country;

    @Column(name = "exchange_rate")
    private Double exchangeRate;

    @Column(name = "value")
    private Double value;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
