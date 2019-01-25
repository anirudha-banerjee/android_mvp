package com.nerdscorner.mvplib.testapp.interfaces.behaviour.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.interfaces.model.BaseInterfacesModel;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter.BehaviourMainPresenterInterface;

public class BehaviourMainModel extends BaseInterfacesModel<BehaviourMainPresenterInterface> implements BehaviourMainModelInterface {

    @Override
    public void doSomethingInBackground() {
        new SomeBackgroundTask(this).execute();
    }

    private static class SomeBackgroundTask extends AsyncTask<Void, Void, Void> {
        private BehaviourMainModel model;

        SomeBackgroundTask(BehaviourMainModel model) {
            this.model = model;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            model.getPresenter().onBackgroundTaskCompleted();
        }
    }
}