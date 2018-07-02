package com.example.admin.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxJava();


    }

    /**
     * rxJava：是rxjava最简单的使用。----------------------------------------------------------------------------------------------------------------------------------------
     */
    public void rxJava() {
        //观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("TEST", "onSubscribe");

            }

            @Override
            public void onNext(String s) {
                Log.i("TEST", "onNext："+s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("TEST", "onError");
            }

            @Override
            public void onComplete() {
                Log.i("TEST", "onComplete");
            }
        };
        //创建被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("发射数据");
            }
        });
        observable.subscribe(observer);
    }
    /**
     * rxJava：的使用。----------------------------------------------------------------------------------------------------------------------------------------
     */

}
