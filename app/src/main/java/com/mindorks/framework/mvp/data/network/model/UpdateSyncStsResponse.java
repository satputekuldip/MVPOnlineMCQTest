package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Created by SPARK on 07/10/2018.
 */
public class UpdateSyncStsResponse {
    @Expose
    @SerializedName("success")
    private boolean success;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private QuestionsResponse.QuestionsRepo data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public QuestionsResponse.QuestionsRepo getData() {
        return data;
    }

    public void setData(QuestionsResponse.QuestionsRepo data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateSyncStsResponse)) return false;
        UpdateSyncStsResponse that = (UpdateSyncStsResponse) o;
        return isSuccess() == that.isSuccess() &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {

        return Objects.hash(isSuccess(), getMessage(), getData());
    }

    @Override
    public String toString() {
        return "UpdateSyncStsResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
