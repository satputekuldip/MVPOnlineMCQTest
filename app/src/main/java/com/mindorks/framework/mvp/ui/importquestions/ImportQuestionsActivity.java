package com.mindorks.framework.mvp.ui.importquestions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.ui.base.BaseActivity;
import com.mindorks.framework.mvp.ui.main.MainActivity;
import com.mindorks.framework.mvp.ui.splash.SplashActivity;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImportQuestionsActivity extends BaseActivity implements ImportQuestionsMvpView {

    @Inject
    ImportQuestionsPresenter<ImportQuestionsMvpView> mPresenter;

    @BindView(R.id.tvQuestionFileName)
    TextView tvQuestionFileName;

    @BindView(R.id.tvOptionsFileName)
    TextView tvOptionFileName;

    @BindView(R.id.btnBrowseQuestion)
    Button btnBrowseQuestion;

    @BindView(R.id.btnBrowseOptions)
    Button btnBrowseOptions;

    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @BindView(R.id.btnCancel)
    Button btnCancel;

    boolean question = false;

    private int MAX_ATTACHMENT_COUNT = 1;
    private ArrayList<String> questionsPath = new ArrayList<>();
    private ArrayList<String> optionsPath = new ArrayList<>();
    private String filePath = "";

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ImportQuestionsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_questions);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ImportQuestionsActivity.this);
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.btnBrowseQuestion)
    void onQuestionsBrowseClick(View view){
        question = true;
        mPresenter.onQuestionsBrowseClick();
    }

    @OnClick(R.id.btnBrowseOptions)
    void onOptionsBrowseClick(View view){
        question = false;
        mPresenter.onOptionsBrowseClick();
    }

    @OnClick(R.id.btnSubmit)
    void onSubmitClick(View view){
        try {
            mPresenter.onSubmitClick();
        } catch (IOException e) {
            showMessage("Import Failed due to "+e.getMessage());
        }
    }

    @OnClick(R.id.btnCancel)
    void onCancelClick(View view){
        mPresenter.onCancelClick();
    }

    @Override
    public void updateQuestionsFilePath(String path){
        tvQuestionFileName.setText(path);
    }

    @Override
    public String getQuestionsFilePath() {
        return tvQuestionFileName.getText().toString();
    }

    @Override
    public void updateOptionsFilePath(String path){
        tvOptionFileName.setText(path);
    }

    @Override
    public String getOptionsFilePath() {
        return tvOptionFileName.getText().toString();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(ImportQuestionsActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void finishActivity() {
        this.finish();
    }


    @Override
    public void onPickDoc(int requestCode) {
        new MaterialFilePicker()
                .withActivity(this)
                .withRequestCode(requestCode)
                .withFilter(Pattern.compile(".*\\.json$")) // Filtering files and directories by file name using regexp
                .start();

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        filePath = "";
        if (resultCode == RESULT_OK) {
            filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            switch (requestCode) {
                case 1:
                    updateQuestionsFilePath(filePath);
                    break;
                case 2:
                    updateOptionsFilePath(filePath);
                    break;
                /*default:
                    break;*/
            }
        }
    }
}
