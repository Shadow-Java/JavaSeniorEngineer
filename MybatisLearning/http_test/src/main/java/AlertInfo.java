import java.io.Serializable;

public class AlertInfo implements Serializable {
    private String manufacturerServerId;
    private String alertId;
    private String alertLevel;
    private String dataCenterName;
    private String networkZone;
    private String internetProtocol;
    private String alertSource;
    private String alertType;
    private String alertObject;
    private String alertContent;
    private String alertTime;
    private String alertCatalog;

    @Override
    public String toString() {
        return "AlertInfo{" +
                "manufacturerServerId='" + manufacturerServerId + '\'' +
                ", alertId='" + alertId + '\'' +
                ", alertLevel='" + alertLevel + '\'' +
                ", dataCenterName='" + dataCenterName + '\'' +
                ", networkZone='" + networkZone + '\'' +
                ", internetProtocol='" + internetProtocol + '\'' +
                ", alertSource='" + alertSource + '\'' +
                ", alertType='" + alertType + '\'' +
                ", alertObject='" + alertObject + '\'' +
                ", alertContent='" + alertContent + '\'' +
                ", alertTime='" + alertTime + '\'' +
                ", alertCatalog='" + alertCatalog + '\'' +
                '}';
    }

    public AlertInfo(String manufacturerServerId, String alertId, String alertLevel, String dataCenterName, String networkZone, String internetProtocol, String alertSource, String alertType, String alertObject, String alertContent, String alertTime, String alertCatalog) {
        this.manufacturerServerId = manufacturerServerId;
        this.alertId = alertId;
        this.alertLevel = alertLevel;
        this.dataCenterName = dataCenterName;
        this.networkZone = networkZone;
        this.internetProtocol = internetProtocol;
        this.alertSource = alertSource;
        this.alertType = alertType;
        this.alertObject = alertObject;
        this.alertContent = alertContent;
        this.alertTime = alertTime;
        this.alertCatalog = alertCatalog;
    }

    public String getManufacturerServerId() {
        return manufacturerServerId;
    }

    public void setManufacturerServerId(String manufacturerServerId) {
        this.manufacturerServerId = manufacturerServerId;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    public void setDataCenterName(String dataCenterName) {
        this.dataCenterName = dataCenterName;
    }

    public String getNetworkZone() {
        return networkZone;
    }

    public void setNetworkZone(String networkZone) {
        this.networkZone = networkZone;
    }

    public String getInternetProtocol() {
        return internetProtocol;
    }

    public void setInternetProtocol(String internetProtocol) {
        this.internetProtocol = internetProtocol;
    }

    public String getAlertSource() {
        return alertSource;
    }

    public void setAlertSource(String alertSource) {
        this.alertSource = alertSource;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertObject() {
        return alertObject;
    }

    public void setAlertObject(String alertObject) {
        this.alertObject = alertObject;
    }

    public String getAlertContent() {
        return alertContent;
    }

    public void setAlertContent(String alertContent) {
        this.alertContent = alertContent;
    }

    public String getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(String alertTime) {
        this.alertTime = alertTime;
    }

    public String getAlertCatalog() {
        return alertCatalog;
    }

    public void setAlertCatalog(String alertCatalog) {
        this.alertCatalog = alertCatalog;
    }
}
