package domain;

public class UserHistory {

    public UserHistory(String user_name, String id, String drug_id, String drug_name, String summary, String prescribing) {
        this.user_name = user_name;
        this.id = id;
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.summary = summary;
        this.prescribing = prescribing;

    }

    private String user_name;
    private String id;
    private String drug_id;
    private String drug_name;
    private String summary;
    private String prescribing;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(String drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrescribing() {
        return prescribing;
    }

    public void setPrescribing(String prescribing) {
        this.prescribing = prescribing;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "user_name=" + user_name +
                ", id=" + id +
                ", drug_id=" + drug_id +
                ", drug_name=" + drug_name +
                ", summary=" + summary +
                ", prescribing=" + prescribing +
                '}';
    }
}