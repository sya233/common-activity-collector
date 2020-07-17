package com.upai.manageallactivity.second;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.upai.manageallactivity.R;
import com.upai.manageallactivity.util.ActivityUtil;

public class SecondActivity extends AppCompatActivity implements SecondView {

    private SecondPresenter secondPresenter;

    private Button btnFinishAll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // 初始化
        init();
        // 按钮点击
        respondToClick();
    }

    private void init() {
        // 初始化控件id
        Toolbar toolbar = findViewById(R.id.toolbar);
        btnFinishAll=findViewById(R.id.btn_finish_all);
        // 设置ToolBar和ActionBar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("二界面");
        }
        // 添加Activity到返回栈中
        ActivityUtil.getInstance().addActivity(this);
        // 初始化Presenter
        secondPresenter=new SecondPresenter(this,new SecondModel());
    }

    private void respondToClick(){
        btnFinishAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondPresenter.finishAll();
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtil.getInstance().removeActivity(this);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
