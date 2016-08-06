package com.lifeistech.android.calculationfortraining;

import android.os.CountDownTimer;

/**
 * Created by Life_is_Tech on 16/08/06.
 */
public class CountDown extends CountDownTimer {
    OnTickListener onTickListener;
    OnFinishListener onFinishListener;

    public CountDown(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long l) {
        if(onTickListener != null ) onTickListener.onTick(l);
    }

    @Override
    public void onFinish() {
        if(onFinishListener != null ) onFinishListener.onFinish();
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    public void setOnTickListener(OnTickListener onTickListener) {
        this.onTickListener = onTickListener;
    }

    interface OnTickListener {
        void onTick(long l);
    }
    interface OnFinishListener {
        void onFinish();
    }

}
