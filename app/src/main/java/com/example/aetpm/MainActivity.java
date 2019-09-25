package com.example.aetpm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.uuzuche.lib_zxing.activity.CaptureActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button QRbtn ;
    private Button scan ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
       // ZXingLibrary.initDisplayOpinion(this);
        initView();

    }

    private void initView(){
        QRbtn=findViewById(R.id.QRbutton);
        QRbtn.setOnClickListener(this);
        scan = findViewById(R.id.SCANbutton);
        scan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.QRbutton:
                //获取权限
                requsetPermission();

                break;
            case R.id.SCANbutton:
                //查询
                break;
            default:

                break;
        }
    }


    //申请权限
    private void requsetPermission(){
        if (Build.VERSION.SDK_INT>22){
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    android.Manifest.permission.CAMERA)!=     PackageManager.PERMISSION_GRANTED){
                //先判断有没有权限 ，没有就在这里进行权限的申请
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{android.Manifest.permission.CAMERA},1);

            }else {
                GoScan();
            }
        }else {
            GoScan();
        }
    }
    //跳转扫描scan
    private  void GoScan(){
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        Intent intent1 = new Intent(MainActivity.this, com.example.aetpm.scan.class);
        startActivityForResult(intent, 1);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //这里已经获取到了摄像头的权限，想干嘛干嘛了可以
                    GoScan();
                }else {
                    //这里是拒绝给APP摄像头权限，给个提示什么的说明一下都可以。
                    Toast.makeText(MainActivity.this,"请手动打开相机权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }
}
