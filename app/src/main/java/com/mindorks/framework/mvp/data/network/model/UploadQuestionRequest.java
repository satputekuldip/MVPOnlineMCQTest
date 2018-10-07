package com.mindorks.framework.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 25/06/2018.
 */
public class UploadQuestionRequest {

    @Expose
    @SerializedName("submit")
    private String submit;

    @Expose
    @SerializedName("test_no")
    private String testNo;

    @Expose
    @SerializedName("q_no")
    private String questionNo;

    @Expose
    @SerializedName("question")
    private String questionText;

    @Expose
    @SerializedName("op1")
    private String option1;

    @Expose
    @SerializedName("op1_is_correct")
    private boolean op1IsCorrect;

    @Expose
    @SerializedName("op2")
    private String option2;

    @Expose
    @SerializedName("op2_is_correct")
    private boolean op2IsCorrect;

    @Expose
    @SerializedName("op3")
    private String option3;

    @Expose
    @SerializedName("op3_is_correct")
    private boolean op3IsCorrect;

    @Expose
    @SerializedName("op4")
    private String option4;

    @Expose
    @SerializedName("op4_is_correct")
    private boolean op4IsCorrect;

    public UploadQuestionRequest(String submit, String testNo,
                                 String questionNo, String questionText,
                                 String option1, boolean op1IsCorrect,
                                 String option2, boolean op2IsCorrect,
                                 String option3, boolean op3IsCorrect,
                                 String option4, boolean op4IsCorrect) {
        this.submit = submit;
        this.testNo = testNo;
        this.questionNo = questionNo;
        this.questionText = questionText;
        this.option1 = option1;
        this.op1IsCorrect = op1IsCorrect;
        this.option2 = option2;
        this.op2IsCorrect = op2IsCorrect;
        this.option3 = option3;
        this.op3IsCorrect = op3IsCorrect;
        this.option4 = option4;
        this.op4IsCorrect = op4IsCorrect;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public boolean isOp1IsCorrect() {
        return op1IsCorrect;
    }

    public void setOp1IsCorrect(boolean op1IsCorrect) {
        this.op1IsCorrect = op1IsCorrect;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public boolean isOp2IsCorrect() {
        return op2IsCorrect;
    }

    public void setOp2IsCorrect(boolean op2IsCorrect) {
        this.op2IsCorrect = op2IsCorrect;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public boolean isOp3IsCorrect() {
        return op3IsCorrect;
    }

    public void setOp3IsCorrect(boolean op3IsCorrect) {
        this.op3IsCorrect = op3IsCorrect;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public boolean isOp4IsCorrect() {
        return op4IsCorrect;
    }

    public void setOp4IsCorrect(boolean op4IsCorrect) {
        this.op4IsCorrect = op4IsCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadQuestionRequest)) return false;
        UploadQuestionRequest that = (UploadQuestionRequest) o;
        return op1IsCorrect == that.op1IsCorrect &&
                op2IsCorrect == that.op2IsCorrect &&
                op3IsCorrect == that.op3IsCorrect &&
                op4IsCorrect == that.op4IsCorrect &&
                Objects.equals(submit, that.submit) &&
                Objects.equals(testNo, that.testNo) &&
                Objects.equals(questionNo, that.questionNo) &&
                Objects.equals(questionText, that.questionText) &&
                Objects.equals(option1, that.option1) &&
                Objects.equals(option2, that.option2) &&
                Objects.equals(option3, that.option3) &&
                Objects.equals(option4, that.option4);
    }

    @Override
    public int hashCode() {

        return Objects.hash(submit, testNo, questionNo, questionText, option1, op1IsCorrect, option2, op2IsCorrect, option3, op3IsCorrect, option4, op4IsCorrect);
    }
}
