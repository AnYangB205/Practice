package com.example.myapplication.ui.main;

import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<Long> curTime = new MutableLiveData(){

    };

    public MutableLiveData<String> time = new MutableLiveData<>();

    public MainViewModel() {
        super();
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    long value = System.currentTimeMillis();
                    curTime.postValue(value);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                    String format = simpleDateFormat.format(new Date(value));
                    time.postValue(format);
                    SystemClock.sleep(1000);
                }

            }
        }.start();

    }
}