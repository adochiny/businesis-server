package za.co.openset.model;

import za.co.openset.type.WarehouseType;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 *
 * Building where we can store products.
 */

@Entity
@Table(name="warehouse",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Warehouse extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "warehouse_seq")
    @SequenceGenerator(name = "warehouse_seq", sequenceName = "warehouse_seq")
    @Column(name = "warehouse_id")
    private Long warehouseId;

    //warehouse belong to an organisation.
    @ManyToOne(optional=true, cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="organisation_id",referencedColumnName="organisation_id")
    private Organisation organisation;

    // we wont link to products as there is too many values, warehouse has products.

    @OneToOne(optional=true,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;


    @Column(name = "name", length = 100,
            nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 115)
    private String description;

    // inbound / outbound/ client
    @Column(name = "warehouse_type", length = 115)
    @Enumerated(EnumType.STRING)
    private WarehouseType warehouseType;

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
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

    public WarehouseType getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(WarehouseType warehouseType) {
        this.warehouseType = warehouseType;
    }
}
