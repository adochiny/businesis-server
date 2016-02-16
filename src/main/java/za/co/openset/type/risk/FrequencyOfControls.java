package za.co.openset.type.risk;

/**
 * Created by adonis on 2015/06/06.
 *
 */
public enum FrequencyOfControls {
    Daily("Daily")
    ,SemiAnnually("SemiAnnually")
    ,Quarterly("Quarterly"), Monthly("Monthly")
    ;
    private String description;

    FrequencyOfControls(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
