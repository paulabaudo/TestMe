package com.globant.paulabaudo.testme;

/**
 * Created by paula.baudo on 8/6/2015.
 */
public class Task {

    private String mName;
    private Boolean mDone;

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
    }

    @Override
    public String toString() {
        return mName + ": " + (mDone?"Done":"Not done");
    }
}
