package com.example.activitytest;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import static android.view.MotionEvent.ACTION_DOWN;

/**
 * Activity的生命周期
 * Bundle如何传递数据
 * Activity的启动模式
 */

public class MainActivity extends AppCompatActivity {

    /**
     * 异常Activity生命周期：
     * onPause->onSaveInstanceState->onStop->onDestroy->onCreate->onStart->onRestoreInstanceState->onResume
     */

    /**
     * Activity的启动模式
     * standard
     * singleTop(栈顶复用)
     * singleTask(栈内复用)
     * singleInstance(独立的任务栈)
     */

    /**
     * Launch an activity
     * startActivity()
     * startActivityForResult()//onActivityResult
     */

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView textView;

    //Activity
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.i(TAG, "onSaveInstanceState1: ");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    //AppCompatActivity
    /**
     * home键或者锁屏都会调用、back键不会调用(需要保存状态时才会调用)
     * 横竖屏切换调用
     * 会自动保存各种UI控件状态，自动恢复(View控件都具体实现onSaveInstanceState)(UI控件必须指定唯一ID，为了使用Bundle保存)
     * 分发事件，通知PhoneWindow-DecorView-View分别保存状态
     * Acticity被动销毁(非主动退出)
     * before onStop，但是和onPause不确定前后顺序
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState2: " + outState.toString());
        super.onSaveInstanceState(outState);
    }


    /**
     * after onStart, 销毁之后重启调用
     *
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState1: ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        Log.i(TAG, "onRestoreInstanceState2: ");
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    /**
     * AndroidManifest中设置Activity的属性android:configChanges="orientation|keyboardHidden|screenSize"
     * configChanges只有同时添加这三个属性，才会保持Activity的生命周期的状态
     * 添加orientation这个属性才会onConfigurationChanged回调
     * Activity中 mFragments.dispatchConfigurationChanged(newConfig);
     * 实质上主要是 Activity 中收到 AMS 的通知，回调，然后把事件分发到 Window、Fragment、ActionBar 等。
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i(TAG, "onConfigurationChanged: ");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        //打开TextView的数据保存
        //TextView onSaveInstanceState freezesText决定是否保存
        textView.setFreezesText(true);
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == ACTION_DOWN) {
            textView.setText("123321");
            //显式intent
            Intent intent = new Intent(this, Main2Activity.class);
            startActivityForResult(intent, 1);
        }
        return true;
    }

    /**
     * startActivityForResult launch activity2
     * activity2销毁回调此方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i(TAG, "onActivityResult requestCode: " + requestCode + "resultCode: " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
