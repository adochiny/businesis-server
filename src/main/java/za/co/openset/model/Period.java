package za.co.openset.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adonis on 2015/06/04.
 */
@Entity
@Table(name="period")
public class Period extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "period_seq")
    @SequenceGenerator(name = "period_seq", sequenceName = "period_seq")
    @Column(name = "period_id")
    private Long periodId;

    @Column(name="description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
