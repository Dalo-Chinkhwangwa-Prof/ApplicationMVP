package com.coolcats.mvpapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.coolcats.mvpapplication.R;
import com.coolcats.mvpapplication.databinding.ActivityMainBinding;
import com.coolcats.mvpapplication.model.Bill;
import com.coolcats.mvpapplication.presenter.BillPresenter;
import com.coolcats.mvpapplication.presenter.Contract;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private Contract.Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new BillPresenter(this);

        presenter.getAllBills();
    }

    @Override
    public void showState(BillPresenter.State dataState) {

        runOnUiThread(() -> {
            switch (dataState) {
                case LOADING:
                    binding.progressBar.setVisibility(View.VISIBLE);
                    break;
                case ERROR:
                    binding.progressBar.setVisibility(View.GONE);
                    this.showError("An error occurred!");
                    break;
                default:
                    binding.progressBar.setVisibility(View.GONE);
                    break;

            }
        });
    }

    @Override
    public void showBills(List<Bill> bills) {
        Log.d("TAG_X", "show bills called");
        for (int i = 0; i < bills.size(); i++) {
            Log.d("TAG_X", bills.get(i).toString());
        }
    }

    @Override
    public void showError(String message) {

        Snackbar.make(binding.getRoot(), "An Error occurred", Snackbar.LENGTH_LONG).show();

    }
}