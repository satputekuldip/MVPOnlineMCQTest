package com.mindorks.framework.mvp.ui.test.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.ui.base.BaseActivity;

public class TestListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);
    }

    @Override
    protected void setUp() {

    }
}