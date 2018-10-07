package com.mindorks.framework.mvp.ui.sync.from.server;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;

import com.example.circulardialog.CDialog;
import com.example.circulardialog.extras.CDConstants;
import com.github.jorgecastilloprz.FABProgressCircle;
import com.github.jorgecastilloprz.listeners.FABProgressListener;
import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.data.file.model.FileData;
import com.mindorks.framework.mvp.ui.base.BaseActivity;
import com.mindorks.framework.mvp.utils.AppConstants;

import java.io.File;
import java.io.FileWriter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class SyncFromServerActivity extends BaseActivity implements SyncFromServerMvpView, FABProgressListener {

    @Inject
    SyncFromServerPresenter<SyncFromServerMvpView> mPresenter;

    @BindView(R.id.fabProgressCircle)
    FABProgressCircle fabProgressCircle;



    private boolean taskRunning;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SyncFromServerActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_from_server);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        fabProgressCircle.attachListener(this);
        mPresenter.onSetup();
    }

    @OnClick(R.id.fab)
    void onFabClicked(){
        mPresenter.onFabButtonClicked();
    }


    @Override
    public void startFABAnimation() {
        fabProgressCircle.show();
    }

    @Override
    public void finishFABAnimation() {
        fabProgressCircle.beginFinalAnimation();
    }

    @Override
    public void onFABProgressAnimationEnd() {
        Snackbar.make(fabProgressCircle, R.string.cloud_sync_complete, Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }


    @Override
    public void saveJsonFile(String json, String filename) {
        //mPresenter.saveToFile(json,filename);

        //region From Activity
        FileData fileData = new FileData(new File(AppConstants.FILE_ABSOLUTE_PATH),json,filename);
        if(!fileData.getPath().exists()){
            fileData.getPath().mkdir();
        }

        try{
            File gpxfile = new File(fileData.getPath(), fileData.getFilename());
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(fileData.getData());
            writer.flush();
            writer.close();


        }catch (Exception e){
            Timber.tag("FileHandling").d(e);
        }
        //endregion
    }
}
