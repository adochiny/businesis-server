package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 */
@Entity
@Table(name="request")
public class Request extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "request_seq")
    @SequenceGenerator(name = "request_seq", sequenceName = "request_seq")
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "assigned_to")
    private String assignedTo;

    // mapped to period 1 to 1.
    @OneToOne(optional=false)
    @JoinColumn(name = "period_id")
    private Period period;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
