package com.coolcats.mvpapplication.presenter;

import com.coolcats.mvpapplication.model.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BillPresenter implements Contract.Presenter {

    public enum State {
        LOADING,
        COMPLETE,
        ERROR
    }


    private Contract.View view;

    public BillPresenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void getAllBills() {
        //TODO: implement fake data
        view.showState(State.LOADING);
        //when done reading
        getFakeBills();
    }

    @Override
    public void getAllBillsMoreThan(double price) {

    }

    //assume you are reading from a database....
    private void getFakeBills() {

        List<Bill> bills = new ArrayList<>();
        new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0; i < 10; i++) {
                    try {
                        int j = new Random().nextInt(50);

                        Thread.sleep(500);
                        bills.add(new Bill("Bill_0" + i, j * i, "01/01/22"));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        view.showError("Oops! Thread issue.");
                        view.showState(BillPresenter.State.ERROR);
                    }
                }

                view.showBills(bills);
                view.showState(BillPresenter.State.COMPLETE);
            }
        }.start();
    }
}
