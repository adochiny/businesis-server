package za.co.openset.type;

/**
 * Created by adonis on 2015/06/02.
 */
public enum ApplicationStatus {
    SAVED("saved", "Saved online, not yet submitted for processing"),
    SUBMITTED("submitted", "Submitted for processing"),
    INPROGRESS("in progress", "Submit failed, needs to be resubmitted");

    private final String status;
    private final String description;

    private ApplicationStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus(){
        return status;
    }

    public String getDescription(){
        return description;
    }
}