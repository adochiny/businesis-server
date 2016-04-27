package za.co.openset.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by adonis on 2015/06/02.
 *
 */
@MappedSuperclass
public class BasePo implements Serializable {

    @Transient
    private String userReference;

    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.DATE)
    Date created;

    @Column(name = "updated")
    @Temporal(TemporalType.DATE)
    Date updated;

    @Column(name = "isactive", nullable = false)
    Boolean isactive;

    @Column(name = "createdby", nullable = false)
    Long createdby;

    @Column(name = "updatedby")
    Long updatedby;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Long getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Long updatedby) {
        this.updatedby = updatedby;
    }

    public String getUserReference() {
        return userReference;
    }

    public void setUserReference(String userReference) {
        this.userReference = userReference;
    }
}
