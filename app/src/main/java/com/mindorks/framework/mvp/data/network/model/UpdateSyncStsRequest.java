package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 07/10/2018.
 */
public class UpdateSyncStsRequest {
    @Expose
    @SerializedName("sync_sts")
    private String syncSts;

    public UpdateSyncStsRequest(String syncSts) {
        this.syncSts = syncSts;
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
        if (!(o instanceof UpdateSyncStsRequest)) return false;
        UpdateSyncStsRequest that = (UpdateSyncStsRequest) o;
        return Objects.equals(getSyncSts(), that.getSyncSts());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSyncSts());
    }

    @Override
    public String toString() {
        return "UpdateSyncStsRequest{" +
                "syncSts='" + syncSts + '\'' +
                '}';
    }
}
