package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 */

@Entity
@Table(name="attribute",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Attribute extends BasePo{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "attribute_seq")
    @SequenceGenerator(name = "attribute_seq", sequenceName = "attribute_seq")
    @Column(name = "attribute_id")
    private Long attributeId;

    //
    @ManyToOne(optional=true, cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="asset_id",referencedColumnName="asset_id")
    private Asset asset;

    @Column(name="name", unique = true)
    private String name;

    @Column(name="attribute_type")
    private String attributeType;

    @Column(name="value")
    private String value;

    @Column(name="double_value")
    private Double doubleValue;

    @Column(name="description")
    private String description;

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
