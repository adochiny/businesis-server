package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 *
 * Used to locate items in the warehouse.
 */

@Entity
@Table(name="storage")
public class Storage extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "storage_seq")
    @SequenceGenerator(name = "storage_seq", sequenceName = "storage_seq")
    @Column(name = "storage_id")
    private Long storageId;

    @Column(name = "name")
    private String name;

    @Column(name = "x_value")
    private String xValue;

    @Column(name = "y_value")
    private String yValue;

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getxValue() {
        return xValue;
    }

    public void setxValue(String xValue) {
        this.xValue = xValue;
    }

    public String getyValue() {
        return yValue;
    }

    public void setyValue(String yValue) {
        this.yValue = yValue;
    }
}
