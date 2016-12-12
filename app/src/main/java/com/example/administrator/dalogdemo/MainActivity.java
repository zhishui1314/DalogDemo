package com.example.administrator.dalogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String[] arras = {"1", "2", "3", "4", "5"};

    private String result;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 单选按钮
     *
     * @param view
     */
    public void danx(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择项目：");
        builder.setSingleChoiceItems(arras, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, arras[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }

        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    /**
     * 多选按钮
     * @param view
     */
    public void duox(View view) {
        final List<String> mList = new ArrayList<String>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("please select");
        builder.setMultiChoiceItems(arras, new boolean[]{false, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                mList.add(arras[i]);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, mList.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }
    public void zx(View view){
        v = View.inflate(MainActivity.this, R.layout.items,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("标题");
        builder.setView(v,0,0,0,0);//为了兼容低版本
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editText = (EditText) v.findViewById(R.id.ed);
                String trim = editText.getText().toString().trim();
                Toast.makeText(MainActivity.this,trim,Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消",null);
        builder.create().show();

    }
}
