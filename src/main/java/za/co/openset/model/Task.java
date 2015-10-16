package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 */

@Entity
@Table(name="task")
public class Task extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq")
    @Column(name = "task_id")
    private Long taskId;

    @OneToOne(optional=true)
    @JoinColumn(name = "period_id")
    private Period period;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "assigned_to")
    private String assignedTo;

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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
}
