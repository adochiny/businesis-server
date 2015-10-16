package za.co.openset.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by adonis on 2015/06/02.
 */
public class BaseDto implements Serializable {

    private String userReference;

    private Date created;
    private Date updated;
    private Boolean isactive;
    private Long createdby;
    private Long updatedby;

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

    @Override
    public String toString() {
        return "BaseDto{" +
                "created=" + created +
                ", updated=" + updated +
                ", isactive=" + isactive +
                ", createdby=" + createdby +
                ", updatedby=" + updatedby +
                '}';
    }
}
