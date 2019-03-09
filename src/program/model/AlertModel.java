package program.model;

import java.util.Date;

public class AlertModel {

    private String alertContent;
    private Date alertDate;

    public AlertModel(String alertContent, Date alertDate) {
        this.alertContent = alertContent;
        this.alertDate = alertDate;
    }

    public AlertModel(String alertContent) {
        this.alertContent = alertContent;
        this.alertDate = new Date();
    }

    public String getAlertContent() {
        return alertContent;
    }

    public Date getAlertDate() {
        return alertDate;
    }
}
