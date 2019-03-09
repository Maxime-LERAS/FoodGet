package program.model;

import java.time.LocalDateTime;

public class AlertModel {

    private String alertContent;
    private LocalDateTime alertDate;

    public AlertModel(String alertContent, LocalDateTime alertDate) {
        this.alertContent = alertContent;
        this.alertDate = alertDate;
    }

    public AlertModel(String alertContent) {
        this.alertContent = alertContent;
        this.alertDate = LocalDateTime.now();
    }

    public String getAlertContent() {
        return alertContent;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }
}
