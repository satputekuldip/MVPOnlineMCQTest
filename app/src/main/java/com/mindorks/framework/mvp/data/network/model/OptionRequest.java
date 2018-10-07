package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 23/06/2018.
 */
public class OptionRequest {

    @Expose
    @SerializedName("option_text")
    private String optionText;

    @Expose
    @SerializedName("question_id")
    private String questionId;

    @Expose
    @SerializedName("is_correct")
    private boolean isCorrect;

    public OptionRequest(String optionText, String questionId, boolean isCorrect) {
        this.optionText = optionText;
        this.questionId = questionId;
        this.isCorrect = isCorrect;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OptionRequest)) return false;
        OptionRequest that = (OptionRequest) o;
        return isCorrect == that.isCorrect &&
                Objects.equals(optionText, that.optionText) &&
                Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(optionText, questionId, isCorrect);
    }

    @Override
    public String toString() {
        return "OptionRequest{" +
                "optionText='" + optionText + '\'' +
                ", questionId='" + questionId + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
