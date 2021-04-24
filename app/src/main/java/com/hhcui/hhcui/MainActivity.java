package com.hhcui.hhcui;

import android.Manifest;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ImageView;


/**
 * @ClassName: MainActivity
 * @Description:
 * @Author: hhcui
 * @CreateDate: 2020/1/10 9:02
 * @UpdateDate: 2020/1/10 9:02
 * @Version: 1.0
 */
public class MainActivity extends Activity {
    private String TAG = this.getClass().getSimpleName();
    private ImageView mImage ;
    private final String imageUrl = "https://img1.3lian.com/2015/w3/66/81.jpg";
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean illegalName = IllegalNameUtil.getInstance(this).isIllegalName("取消收藏");
        Log.d(TAG, "习近平 is illegal name is " + illegalName);

        mImage = findViewById(R.id.image_main);
        requestPermissions(new String[]{Manifest.permission.INTERNET},1001);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1001){
            Log.d(TAG, "onRequestPermissionsResult() called with: requestCode = [" + requestCode + "], permissions = [" + permissions + "], grantResults = [" + grantResults + "]");

//            Glide.with(this).load(imageUrl).into(mImage);
        }
    }
}
