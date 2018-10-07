package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 23/06/2018.
 */
public class QuestionRequest {
    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("question_id")
    private String questionId;

    @Expose
    @SerializedName("question_text")
    private String questionText;

    @Expose
    @SerializedName("question_img_url")
    private String imgUrl;

    @Expose
    @SerializedName("test_no")
    private String testNo;

    public QuestionRequest(Long id, String questionId, String questionText, String imgUrl, String testNo) {
        this.id = id;
        this.questionId = questionId;
        this.questionText = questionText;
        this.imgUrl = imgUrl;
        this.testNo = testNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionRequest)) return false;
        QuestionRequest that = (QuestionRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(questionId, that.questionId) &&
                Objects.equals(questionText, that.questionText) &&
                Objects.equals(imgUrl, that.imgUrl) &&
                Objects.equals(testNo, that.testNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, questionId, questionText, imgUrl, testNo);
    }

    @Override
    public String toString() {
        return "QuestionRequest{" +
                "id=" + id +
                ", questionId='" + questionId + '\'' +
                ", questionText='" + questionText + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", testNo='" + testNo + '\'' +
                '}';
    }


}
