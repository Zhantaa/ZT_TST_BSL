package com.example.myfirstandroid;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////按键监测，进行登录弹框判断
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "WIFI已断开", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("输入账户安全密码");
                final EditText et = new EditText(MainActivity.this);
                et.setHint("请输入密码");
                et.setSingleLine(true);
                builder.setView(et);
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String password = et.getText().toString();//getText中的内容再转换为string类型 方便验证密码是否正确
                        if (password.equals("123456")) {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            public void click(View v) {
            }
        });
///////////////////////第一页
        Button btn1 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment fragment1 = new MyFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction beginTransaction =fm.beginTransaction();
                beginTransaction.replace(R.id.fragment_buju,fragment1);
                beginTransaction.commit();
            }
        });
/////////////////////////////////////////////第二页
        Button btn2 = (Button) findViewById(R.id.button6);
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment2 fragment2 = new MyFragment2();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction beginTransaction =fm.beginTransaction();
                beginTransaction.replace(R.id.fragment_buju,fragment2);
                beginTransaction.commit();
            }
        });
    }
/////////////////////////正向传送数据//////////////////////////////////

    public void click1(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        EditText editText = (EditText) findViewById(R.id.username);
        String inputText = editText.getText().toString();
        intent.putExtra("username", inputText);
        startActivityForResult(intent, 1);
    }
//////////////////////////回传数据
    public void click(View v) {
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            String acquiredData = data.getStringExtra("password"); //获取回传的数据
            EditText password1 = (EditText) findViewById(R.id.editText2);
            password1.setText(acquiredData);
            Toast.makeText(MainActivity.this, acquiredData, Toast.LENGTH_SHORT).show();
        }
    }

}
