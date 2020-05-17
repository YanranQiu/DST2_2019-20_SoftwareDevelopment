package domain;

public class DrugInfo {

    public DrugInfo(String dosing_guideline_id, String drug_id, String drug_name, String dosing_guideline_name,
                    Boolean dosing_guideline_recommendation, Boolean drug_biomarker, Boolean drug_label_alternate_drug_available,
                    String dosing_guideline_source, String drug_label_source, String drug_label_prescribing_markdown,
                    String dosing_guideline_summary_markdown) {
        this.dosing_guideline_id = dosing_guideline_id;
        this.dosing_guideline_name =dosing_guideline_name;
        this.dosing_guideline_recommendation = dosing_guideline_recommendation;
        this.dosing_guideline_source = dosing_guideline_source;
        this.dosing_guideline_summary_markdown =dosing_guideline_summary_markdown;
        this.drug_biomarker = drug_biomarker;
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.drug_label_alternate_drug_available = drug_label_alternate_drug_available;
        this.drug_label_source = drug_label_source;
        this.drug_label_prescribing_markdown = drug_label_prescribing_markdown;

    }
    private String dosing_guideline_id;
    private String drug_id;
    private String drug_name;
    private String dosing_guideline_name;
    private Boolean dosing_guideline_recommendation;
    private Boolean drug_biomarker;
    private Boolean drug_label_alternate_drug_available;
    private String dosing_guideline_source;
    private String drug_label_source;
    private String drug_label_prescribing_markdown;
    private String dosing_guideline_summary_markdown;


    public String getDosing_guideline_id() {
        return dosing_guideline_id;
    }

    public void setDosing_guideline_id(String dosing_guideline_id) {
        this.dosing_guideline_id = dosing_guideline_id;
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

    public String getDosing_guideline_name() {
        return dosing_guideline_name;
    }

    public void setDosing_guideline_name(String dosing_guideline_name) {
        this.dosing_guideline_name = dosing_guideline_name;
    }

    public Boolean getDosing_guideline_recommendation() {
        return dosing_guideline_recommendation;
    }

    public void setDosing_guideline_recommendation(Boolean dosing_guideline_recommendation) {
        this.dosing_guideline_recommendation = dosing_guideline_recommendation;
    }

    public Boolean getDrug_biomarker() {
        return drug_biomarker;
    }

    public void setDrug_biomarker(Boolean drug_biomarker) {
        this.drug_biomarker = drug_biomarker;
    }

    public Boolean getDrug_label_alternate_drug_available() {
        return drug_label_alternate_drug_available;
    }

    public void setDrug_label_alternate_drug_available(Boolean drug_label_alternate_drug_available) {
        this.drug_label_alternate_drug_available = drug_label_alternate_drug_available;
    }

    public String getDosing_guideline_source() {
        return dosing_guideline_source;
    }

    public void setDosing_guideline_source(String dosing_guideline_source) {
        this.dosing_guideline_source = dosing_guideline_source;
    }

    public String getDrug_label_source() {
        return drug_label_source;
    }

    public void setDrug_label_source(String drug_label_source) {
        this.drug_label_source = drug_label_source;
    }

    public String getDrug_label_prescribing_markdown() {
        return drug_label_prescribing_markdown;
    }

    public void setDrug_label_prescribing_markdown(String drug_label_prescribing_markdown) {
        this.drug_label_prescribing_markdown = drug_label_prescribing_markdown;
    }

    public String getDosing_guideline_summary_markdown() {
        return dosing_guideline_summary_markdown;
    }

    public void setDosing_guideline_summary_markdown(String dosing_guideline_summary_markdown) {
        this.dosing_guideline_summary_markdown = dosing_guideline_summary_markdown;
    }

    @Override
    public String toString() {
        return "DrugInfo{" +
                "dosing_guideline_id='" + dosing_guideline_id + '\'' +
                ", drug_id='" + drug_id + '\'' +
                ", drug_name='" + drug_name + '\'' +
                ", dosing_guideline_name='" + dosing_guideline_name + '\'' +
                ", dosing_guideline_recommendation=" + dosing_guideline_recommendation +
                ", drug_biomarker=" + drug_biomarker +
                ", drug_label_alternate_drug_available=" + drug_label_alternate_drug_available +
                ", dosing_guideline_source='" + dosing_guideline_source + '\'' +
                ", drug_label_source='" + drug_label_source + '\'' +
                ", drug_label_prescribing_markdown='" + drug_label_prescribing_markdown + '\'' +
                ", dosing_guideline_summary_markdown='" + dosing_guideline_summary_markdown + '\'' +
                '}';
    }
}