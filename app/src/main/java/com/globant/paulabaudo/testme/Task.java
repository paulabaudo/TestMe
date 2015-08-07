package com.globant.paulabaudo.testme;

import java.util.Date;
import java.util.List;

/**
 * Created by paula.baudo on 8/6/2015.
 */
public class Task {

    private String mName;
    private Boolean mDone;
    private List<Integer> mTime;
    private Date mDoneDate;
    private String mDoneBy;

    public Task() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean getDone() {
        return mDone;
    }

    public void setDone(Boolean done) {
        mDone = done;
        if (mDone){
            mDoneDate = getCurrentDate();
        }
    }

    protected Date getCurrentDate(){
        return new Date();
    }

    public Date getDoneDate() {
        return mDoneDate;
    }

    @Override
    public String toString() {
        return mName + ": " + (mDone?"Done":"Not done");
    }

    public List<Integer> getTime() {
        return mTime;
    }

    public void setTime(List<Integer> time) {
        mTime = time;
    }

    public String getDoneBy() {
        return mDoneBy;
    }

    public void setDoneBy(String doneBy) {
        mDoneBy = doneBy;
    }
}
