package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Property;

import java.util.List;
import java.util.Objects;

/**
 * Created by SPARK on 22/06/2018.
 */
public class OptionsResponse {


    @Expose
    @SerializedName("success")
    private boolean success;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private List<OptionsRepo> data;

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

    public List<OptionsRepo> getData() {
        return data;
    }

    public void setData(List<OptionsRepo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OptionsResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OptionsResponse)) return false;
        OptionsResponse that = (OptionsResponse) o;
        return isSuccess() == that.isSuccess() &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {

        return Objects.hash(isSuccess(), getMessage(), getData());
    }

    public class OptionsRepo {
        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("question_id")
        private Long questionId;

        @Expose
        @SerializedName("option_no")
        private Long optionNo;

        @Expose
        @SerializedName("option_text")
        private String optionText;


        @Expose
        @SerializedName("is_correct")
        private boolean isCorrect;

        @Expose
        @SerializedName("sync_sts")
        private boolean syncSts;

        @Expose
        @SerializedName("created_at")
        private String createdAt;

        @Expose
        @SerializedName("updated_at")
        private String updatedAt;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public Long getOptionNo() {
            return optionNo;
        }

        public void setOptionNo(Long optionNo) {
            this.optionNo = optionNo;
        }

        public String getOptionText() {
            return optionText;
        }

        public void setOptionText(String optionText) {
            this.optionText = optionText;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public void setCorrect(boolean correct) {
            isCorrect = correct;
        }

        public boolean isSyncSts() {
            return syncSts;
        }

        public void setSyncSts(boolean syncSts) {
            this.syncSts = syncSts;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof OptionsRepo)) return false;
            OptionsRepo that = (OptionsRepo) o;
            return isCorrect() == that.isCorrect() &&
                    isSyncSts() == that.isSyncSts() &&
                    Objects.equals(getId(), that.getId()) &&
                    Objects.equals(getQuestionId(), that.getQuestionId()) &&
                    Objects.equals(getOptionNo(), that.getOptionNo()) &&
                    Objects.equals(getOptionText(), that.getOptionText()) &&
                    Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                    Objects.equals(getUpdatedAt(), that.getUpdatedAt());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getId(), getQuestionId(), getOptionNo(), getOptionText(), isCorrect(), isSyncSts(), getCreatedAt(), getUpdatedAt());
        }

        @Override
        public String toString() {
            return "OptionsRepo{" +
                    "id=" + id +
                    ", questionId=" + questionId +
                    ", optionNo=" + optionNo +
                    ", optionText='" + optionText + '\'' +
                    ", isCorrect=" + isCorrect +
                    ", syncSts=" + syncSts +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        }
    }
}
