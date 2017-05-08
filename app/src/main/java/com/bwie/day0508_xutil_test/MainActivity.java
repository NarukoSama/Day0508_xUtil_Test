package com.bwie.day0508_xutil_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//显示布局文件
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @ViewInject(R.id.iv)
    ImageView iv;
    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //显示布局
        x.view().inject(this);

        application = (MyApplication) getApplication();


    }

    /*
    必须private
     */
    //点击事件 , type = View.OnClickListener.class type 默认是 OnClickListener
    @Event(value = {R.id.bt_httpget, R.id.bt_httppost, R.id.bt_iv}, type = View.OnClickListener.class)
    private void btnClick(View view) {

        switch (view.getId()) {

            case R.id.bt_httpget:

                //get
                httpGet();

                break;

            case R.id.bt_httppost:

                //post
                httpPost();

                break;

            case R.id.bt_iv:

                //显示图片
                showImage();

                break;

        }


    }

    public void showImage() {

        x.image().bind(iv, "http://img2.duitang.com/uploads/item/201302/12/20130212212634_crCkA.thumb.600_0.jpeg", application.imageOption());

    }

    public void httpPost() {


        RequestParams params = new RequestParams("http://qhb.2dyt.com/Bwei/login");

        params.addBodyParameter("postkey", "bwei");
        params.addBodyParameter("username", "18511098888");
        params.addBodyParameter("password", "11111");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                System.out.println("result = " + result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    public void httpGet() {

        RequestParams params = new RequestParams("http://qhb.2dyt.com/Bwei/login");

        params.addQueryStringParameter("postkey", "bwei");
        params.addQueryStringParameter("username", "18511098888");
        params.addQueryStringParameter("password", "11111");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                System.out.println("result = " + result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }


}
