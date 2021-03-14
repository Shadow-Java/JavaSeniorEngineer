public class StorageInfo {
    private String manufacturerServerId;
    private String tenantId;
    private String tenantName;
    private String dataCenterName;
    private String networkZone;
    private String protectionLevel;
    private String securityType;
    private Integer storageCapacity;


    public StorageInfo(String manufacturerServerId, String tenantId, String tenantName, String dataCenterName, String networkZone, String protectionLevel, String securityType, Integer storageCapacity) {
        this.manufacturerServerId = manufacturerServerId;
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.dataCenterName = dataCenterName;
        this.networkZone = networkZone;
        this.protectionLevel = protectionLevel;
        this.securityType = securityType;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return "StorageInfo{" +
                "manufacturerServerId='" + manufacturerServerId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", dataCenterName='" + dataCenterName + '\'' +
                ", protectionLevel='" + protectionLevel + '\'' +
                ", securityType='" + securityType + '\'' +
                ", storageCapacity='" + storageCapacity + '\'' +
                '}';
    }

    public String getManufacturerServerId() {
        return manufacturerServerId;
    }

    public void setManufacturerServerId(String manufacturerServerId) {
        this.manufacturerServerId = manufacturerServerId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    public void setDataCenterName(String dataCenterName) {
        this.dataCenterName = dataCenterName;
    }

    public String getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(String protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }


}
