package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Created by SPARK on 22/06/2018.
 */
public class QuestionsResponse {

    @Expose
    @SerializedName("success")
    private boolean success;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private List<QuestionsRepo> data;

    public boolean getStatusCode() {
        return success;
    }

    public void setStatusCode(boolean statusCode) {
        this.success = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<QuestionsRepo> getData() {
        return data;
    }

    public void setData(List<QuestionsRepo> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionsResponse)) return false;
        QuestionsResponse that = (QuestionsResponse) o;
        return Objects.equals(getStatusCode(), that.getStatusCode()) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStatusCode(), getMessage(), getData());
    }

    @Override
    public String toString() {
        return "QuestionsResponse{" +
                "statusCode=" + success  +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public class QuestionsRepo {

        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("test_id")
        private String testNo;

        @Expose
        @SerializedName("question_number")
        private String questionNumber;

        @Expose
        @SerializedName("question_text")
        private String questionText;

        @Expose
        @SerializedName("question_image_url")
        private String imgUrl;

        @Expose
        @SerializedName("sync_sts")
        private boolean syncSts;

        @Expose
        @SerializedName("created_at")
        private String createdAt;

        @Expose
        @SerializedName("updated_at")
        private String updatedAt;



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTestNo() {
            return testNo;
        }

        public void setTestNo(String testNo) {
            this.testNo = testNo;
        }

        public String getQuestionNumber() {
            return questionNumber;
        }

        public void setQuestionNumber(String questionNumber) {
            this.questionNumber = questionNumber;
        }

        public String getQuestionText() {
            return questionText;
        }

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public boolean isSyncSts() {
            return syncSts;
        }

        public void setSyncSts(boolean syncSts) {
            this.syncSts = syncSts;
        }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof QuestionsRepo)) return false;
            QuestionsRepo that = (QuestionsRepo) o;
            return isSyncSts() == that.isSyncSts() &&
                    Objects.equals(getId(), that.getId()) &&
                    Objects.equals(getTestNo(), that.getTestNo()) &&
                    Objects.equals(getQuestionNumber(), that.getQuestionNumber()) &&
                    Objects.equals(getQuestionText(), that.getQuestionText()) &&
                    Objects.equals(getImgUrl(), that.getImgUrl()) &&
                    Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                    Objects.equals(getUpdatedAt(), that.getUpdatedAt());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getId(), getTestNo(), getQuestionNumber(), getQuestionText(), getImgUrl(), isSyncSts(), getCreatedAt(), getUpdatedAt());
        }

        @Override
        public String toString() {
            return "QuestionsRepo{" +
                    "id=" + id +
                    ", testNo='" + testNo + '\'' +
                    ", questionNumber='" + questionNumber + '\'' +
                    ", questionText='" + questionText + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", syncSts=" + syncSts +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        }
    }
}
