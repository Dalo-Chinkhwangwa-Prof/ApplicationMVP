package com.coolcats.mvpapplication.presenter;

import com.coolcats.mvpapplication.model.Bill;

import java.util.List;

public interface Contract {

    interface Presenter {
        void getAllBills();
        void getAllBillsMoreThan(double price);
    }

    interface View {
        void showState(BillPresenter.State dataState);
        void showBills(List<Bill> bills);
        void showError(String message);
    }

}
