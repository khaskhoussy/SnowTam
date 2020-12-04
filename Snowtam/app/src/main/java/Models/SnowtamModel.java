package Models;

public class SnowtamModel {

    private String id;
    private String entity;
    private String status;
    private String Qcode;
    private String Area;
    private String SubArea;
    private String Condition;
    private String Subject;
    private String Modifier;
    private String message;
    private String startdate;
    private String enddate;
    private String all;
    private String location;
    private boolean isICAO;
    private String Created;
    private String key;
    private String type;
    private String StateCode;
    private String StateName;
    private float criticality;


    public SnowtamModel() {
    }

    public SnowtamModel(String id, String entity, String status, String qcode, String area, String subArea, String condition, String subject, String modifier, String message, String startdate, String enddate, String all, String location, boolean isICAO, String created, String key, String type, String stateCode, String stateName, float criticality) {
        this.id = id;
        this.entity = entity;
        this.status = status;
        Qcode = qcode;
        Area = area;
        SubArea = subArea;
        Condition = condition;
        Subject = subject;
        Modifier = modifier;
        this.message = message;
        this.startdate = startdate;
        this.enddate = enddate;
        this.all = all;
        this.location = location;
        this.isICAO = isICAO;
        Created = created;
        this.key = key;
        this.type = type;
        StateCode = stateCode;
        StateName = stateName;
        this.criticality = criticality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQcode() {
        return Qcode;
    }

    public void setQcode(String qcode) {
        Qcode = qcode;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getSubArea() {
        return SubArea;
    }

    public void setSubArea(String subArea) {
        SubArea = subArea;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getModifier() {
        return Modifier;
    }

    public void setModifier(String modifier) {
        Modifier = modifier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isICAO() {
        return isICAO;
    }

    public void setICAO(boolean ICAO) {
        isICAO = ICAO;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public float getCriticality() {
        return criticality;
    }

    public void setCriticality(float criticality) {
        this.criticality = criticality;
    }

    @Override
    public String toString() {
        return "SnowtamModel{" +
                "id='" + id + '\'' +
                ", entity='" + entity + '\'' +
                ", status='" + status + '\'' +
                ", Qcode='" + Qcode + '\'' +
                ", Area='" + Area + '\'' +
                ", SubArea='" + SubArea + '\'' +
                ", Condition='" + Condition + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Modifier='" + Modifier + '\'' +
                ", message='" + message + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", all='" + all + '\'' +
                ", location='" + location + '\'' +
                ", isICAO=" + isICAO +
                ", Created='" + Created + '\'' +
                ", key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", StateCode='" + StateCode + '\'' +
                ", StateName='" + StateName + '\'' +
                ", criticality=" + criticality +
                '}';
    }
}
