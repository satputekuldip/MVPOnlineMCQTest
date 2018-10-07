package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 07/10/2018.
 */
public class ExamTestRequest {
    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("test_number")
    private Long testNumber;

    @Expose
    @SerializedName("subject_id")
    private Long subjectId;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("created_at")
    private String created_at;

    @Expose
    @SerializedName("updated_at")
    private String updated_at;

    @Expose
    @SerializedName("sync_sts")
    private String syncSts;

    public ExamTestRequest(
            Long id,
            Long testNumber,
            Long subjectId,
            String name,
            String created_at,
            String updated_at,
            String syncSts
    ) {
        this.id = id;
        this.testNumber = testNumber;
        this.subjectId = subjectId;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.syncSts = syncSts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Long testNumber) {
        this.testNumber = testNumber;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getSyncSts() {
        return syncSts;
    }

    public void setSyncSts(String syncSts) {
        this.syncSts = syncSts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamTestRequest)) return false;
        ExamTestRequest that = (ExamTestRequest) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTestNumber(), that.getTestNumber()) &&
                Objects.equals(getSubjectId(), that.getSubjectId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCreated_at(), that.getCreated_at()) &&
                Objects.equals(getUpdated_at(), that.getUpdated_at()) &&
                Objects.equals(getSyncSts(), that.getSyncSts());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTestNumber(), getSubjectId(), getName(), getCreated_at(), getUpdated_at(), getSyncSts());
    }

    @Override
    public String toString() {
        return "ExamTestRequest{" +
                "id=" + id +
                ", testNumber='" + testNumber + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", name='" + name + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", syncSts='" + syncSts + '\'' +
                '}';
    }
}
