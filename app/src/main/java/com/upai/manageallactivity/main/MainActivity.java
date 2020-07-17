package com.upai.manageallactivity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.upai.manageallactivity.R;
import com.upai.manageallactivity.util.ActivityUtil;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;

    private Toolbar toolbar;
    private Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化
        init();
        // 按钮点击事件
        respondToClick();
    }

    private void init() {
        // 初始化控件id
        toolbar = findViewById(R.id.toolbar);
        btnMain = findViewById(R.id.btn_main);
        // 初始化Presenter
        mainPresenter = new MainPresenter(this, new MainModel());
        // 设置Toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("主界面");
        }
        // 添加Activity到返回栈中
        ActivityUtil.getInstance().addActivity(this);
    }

    private void respondToClick() {
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.switchToFirstActivity(MainActivity.this);
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtil.getInstance().removeActivity(this);
    }
}
