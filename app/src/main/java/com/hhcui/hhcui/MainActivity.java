package com.hhcui.hhcui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean illegalName = IllegalNameUtil.getInstance(this).isIllegalName("取消收藏");
        Log.d(TAG, "习近平 is illegal name is " + illegalName);
    }
}
