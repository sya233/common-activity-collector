package com.upai.manageallactivity.first;

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

public class FirstActivity extends AppCompatActivity implements FirstView {

    private FirstPresenter firstPresenter;

    private Toolbar toolbar;
    private Button btnFirst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        // 初始化
        init();
        // 点击事件
        respondToClick();
    }

    private void init() {
        // 初始化控件id
        toolbar=findViewById(R.id.toolbar);
        btnFirst = findViewById(R.id.btn_first);
        // 初始化Presenter
        firstPresenter = new FirstPresenter(this, new FirstModel());
        // 设置ActionBar
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("一界面");
        }
        // 添加Activity到返回栈中
        ActivityUtil.getInstance().addActivity(this);
    }

    private void respondToClick() {
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstPresenter.switchToSecondActivity(FirstActivity.this);
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
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
}
