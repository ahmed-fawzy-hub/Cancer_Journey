package com.esraa.CancerJourney.ui.Welcome;

public class WelcomeActivityPresenter implements Contract.Presenter {
    Contract.View mainView;

    public WelcomeActivityPresenter(Contract.View mainView) {
        this.mainView = mainView;
    }
}
