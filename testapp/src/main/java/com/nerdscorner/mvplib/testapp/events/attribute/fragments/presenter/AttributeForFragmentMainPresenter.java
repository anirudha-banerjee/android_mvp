package com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter;

import android.support.v4.app.Fragment;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.events.attribute.activities.model.AttributeMainModel.BackgroundTaskCompletedEvent;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.Fragment1;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.Fragment2;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.AttributeFragmentMainModel;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.AttributeFragmentMainView;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.AttributeFragmentMainView.NextFragmentClickedEvent;

import org.greenrobot.eventbus.Subscribe;

public class AttributeForFragmentMainPresenter extends BaseActivityPresenter<AttributeFragmentMainView, AttributeFragmentMainModel> {

    public AttributeForFragmentMainPresenter(AttributeFragmentMainView view, AttributeFragmentMainModel model) {
        super(view, model);

        //Just so we can show the fragment 1 when the view is created
        onNextFragmentClicked(null);
    }

    @Subscribe
    public void onNextFragmentClicked(NextFragmentClickedEvent event) {
        int nextFragment = model.getNextFragment();
        Fragment fragment;
        switch (nextFragment) {
            case AttributeFragmentMainModel.FRAGMENT_1:
                fragment = new Fragment1();
                break;
            case AttributeFragmentMainModel.FRAGMENT_2:
                fragment = new Fragment2();
                break;
            default:
                throw new IllegalArgumentException("Invalid fragment code: " + nextFragment);
        }
        view.setCurrentFragment(fragment);
    }

    @Subscribe
    public void onBackgroundTaskCompleted(BackgroundTaskCompletedEvent event) {
    }
}