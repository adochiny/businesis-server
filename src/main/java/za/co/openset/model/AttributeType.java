package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 */

@Entity
@Table(name="attribute_type",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class AttributeType extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "attribute_type_seq")
    @SequenceGenerator(name = "attribute_type_seq", sequenceName = "attribute_type_seq")
    @Column(name = "attribute_type_id")
    private Long attributeTypeId;

    @Column(name="name", unique = true)
    private String name;

    @Column(name="description")
    private String description;

    public Long getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(Long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
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
}
