package com.mindorks.framework.mvp.ui.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadQuestionsActivity extends BaseActivity implements UploadQuestionsMvpView {

    @Inject
    UploadQuestionsPresenter<UploadQuestionsMvpView> mPresenter;

    @BindView(R.id.et_ip_address)
    EditText etIPAddress;

    @BindView(R.id.et_Question_No)
    EditText etQuestionNo;

    @BindView(R.id.et_test_no)
    EditText etTestNo;

    @BindView(R.id.et_question)
    EditText etQuestion;

    @BindView(R.id.et_option_1)
    EditText etOption1;

    @BindView(R.id.et_option_2)
    EditText etOption2;

    @BindView(R.id.et_option_3)
    EditText etOption3;

    @BindView(R.id.et_option_4)
    EditText etOption4;

    @BindView(R.id.chk_btn_option_1)
    AppCompatCheckBox chkBtnOption1;

    @BindView(R.id.chk_btn_option_2)
    AppCompatCheckBox chkBtnOption2;

    @BindView(R.id.chk_btn_option_3)
    AppCompatCheckBox chkBtnOption3;

    @BindView(R.id.chk_btn_option_4)
    AppCompatCheckBox chkBtnOption4;


    public static Intent getStartIntent(Context context) {
        return new Intent(context, UploadQuestionsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_questions);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(UploadQuestionsActivity.this);

        setUp();
    }


    @Override
    protected void setUp() {
        mPresenter.onSetup();
    }

    @OnClick(R.id.btn_edit_address)
    void onClickEditAddres(View view) {
        etIPAddress.setEnabled(true);
    }

    @OnClick(R.id.btn_submit_address)
    void onClickSubmitAddress(View view) {
        etIPAddress.setEnabled(false);
    }

    @OnClick(R.id.btn_submit_question)
    void onClickSubmitQuestion(View view) {
        List<Option> optionList = new ArrayList<Option>();

        if (!checkFields()) {

            try {
//                optionList.add(new Option(null, etOption1.getText().toString(),
//                        Long.parseLong(etQuestionNo.getText().toString()), chkBtnOption1.isChecked(),
//                        null, null));
//                optionList.add(new Option(null, etOption2.getText().toString(),
//                        Long.parseLong(etQuestionNo.getText().toString()), chkBtnOption2.isChecked(),
//                        null, null));
//                optionList.add(new Option(null, etOption3.getText().toString(),
//                        Long.parseLong(etQuestionNo.getText().toString()), chkBtnOption3.isChecked(),
//                        null, null));
//                optionList.add(new Option(null, etOption4.getText().toString(),
//                        Long.parseLong(etQuestionNo.getText().toString()), chkBtnOption4.isChecked(),
//                        null, null));

                mPresenter.submitQuestion(etTestNo.getText().toString(),
                        etQuestionNo.getText().toString(),
                        etQuestion.getText().toString(),
                        optionList);
            } catch (NumberFormatException e) {
                onError("Please Check the Fields!" + e.getMessage());
            }
        } else {
            onError("Please Check the Fields!");
        }
    }

    private boolean checkFields() {
        if (etTestNo.getText().toString().isEmpty()
                || etQuestionNo.getText().toString().isEmpty()
                || etQuestion.getText().toString().isEmpty()
                || etOption1.getText().toString().equals("")
                || etOption2.getText().toString().equals("")
                || etOption3.getText().toString().equals("")
                || etOption4.getText().toString().equals("")){
            return true;
        } else {
            return false;
        }
    }

    @OnClick(R.id.btn_cancel_question)
    void onClickCancelQuestion(View view) {
        finish();
    }

    @Override
    public void updateIpAddress(String ipAddres) {
        etIPAddress.setText(ipAddres);
    }

    @Override
    public String getIpAddress() {
        return etIPAddress.getText().toString();
    }

    @Override
    public void resetFields() {
        etTestNo.setText("");
        etQuestionNo.setText("");
        etQuestion.setText("");
        etOption1.setText("");
        etOption2.setText("");
        etOption3.setText("");
        etOption4.setText("");
        chkBtnOption1.setChecked(false);
        chkBtnOption2.setChecked(false);
        chkBtnOption3.setChecked(false);
        chkBtnOption4.setChecked(false);
    }

    @Override
    public void disableAllFielsds() {
        etTestNo.setEnabled(false);
        etQuestionNo.setEnabled(false);
        etQuestion.setEnabled(false);
        etOption1.setEnabled(false);
        etOption2.setEnabled(false);
        etOption3.setEnabled(false);
        etOption4.setEnabled(false);
        chkBtnOption1.setEnabled(false);
        chkBtnOption2.setEnabled(false);
        chkBtnOption3.setEnabled(false);
        chkBtnOption4.setEnabled(false);
    }

    @Override
    public void enableAllFields() {
        etTestNo.setEnabled(true);
        etQuestionNo.setEnabled(true);
        etQuestion.setEnabled(true);
        etOption1.setEnabled(true);
        etOption2.setEnabled(true);
        etOption3.setEnabled(true);
        etOption4.setEnabled(true);
        chkBtnOption1.setEnabled(true);
        chkBtnOption2.setEnabled(true);
        chkBtnOption3.setEnabled(true);
        chkBtnOption4.setEnabled(true);
    }


}
