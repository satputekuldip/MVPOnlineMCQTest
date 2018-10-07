package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 25/06/2018.
 */
public class UploadResponse {
    @Expose
    @SerializedName("status_code")
    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadResponse)) return false;
        UploadResponse that = (UploadResponse) o;
        return Objects.equals(statusCode, that.statusCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(statusCode);
    }
}
