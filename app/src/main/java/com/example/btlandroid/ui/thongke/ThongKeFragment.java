package com.example.btlandroid.ui.thongke;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.btlandroid.R;
import com.example.btlandroid.adapter.ThongKeLoaiChiRecyclerviewAdapter;
import com.example.btlandroid.adapter.ThongKeLoaiThuRecyclerviewAdapter;
import com.example.btlandroid.entity.ThongKeLoaiChi;
import com.example.btlandroid.entity.ThongKeLoaiThu;

import java.util.List;

public class ThongKeFragment extends Fragment {
    private ThongKeViewModel mThongKeViewModel;
    private EditText mEtTongThu;
    private RecyclerView rvThongKeLoaiThu;
    private ThongKeLoaiThuRecyclerviewAdapter mThongKeLoaiThuAdapter;
    private EditText mEtTongChi;
    private RecyclerView rvThongKeLoaiChi;
    private ThongKeLoaiChiRecyclerviewAdapter mThongKeLoaiChiAdapter;
    public ThongKeFragment() {

    }
    public static ThongKeFragment newInstance(String param1, String param2) {
        ThongKeFragment fragment = new ThongKeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_ke, container, false);
        mEtTongThu = view.findViewById(R.id.etTongThu);
        rvThongKeLoaiThu =view.findViewById(R.id.rvThongKeLoaiThu);
        mThongKeViewModel = new ViewModelProvider(this).get(ThongKeViewModel.class);
        mThongKeLoaiThuAdapter = new ThongKeLoaiThuRecyclerviewAdapter(getActivity());
        rvThongKeLoaiThu.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvThongKeLoaiThu.setAdapter(mThongKeLoaiThuAdapter);

        mThongKeViewModel.getTongThu().observe(getActivity(), new Observer<Float>() {
            @Override
            public void onChanged(Float tong) {
                mEtTongThu.setText(""+tong);
            }
        });
        mThongKeViewModel.getThongKeLoaiThus().observe(getActivity(), new Observer<List<ThongKeLoaiThu>>() {
            @Override
            public void onChanged(List<ThongKeLoaiThu> thongKeLoaiThus) {
                mThongKeLoaiThuAdapter.setList(thongKeLoaiThus);
            }
        });

        mEtTongChi = view.findViewById(R.id.etTongChi);
        rvThongKeLoaiChi =view.findViewById(R.id.rvThongKeLoaiChi);
        mThongKeLoaiChiAdapter = new ThongKeLoaiChiRecyclerviewAdapter(getActivity());
        rvThongKeLoaiChi.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvThongKeLoaiChi.setAdapter(mThongKeLoaiChiAdapter);

        mThongKeViewModel.getTongChi().observe(getActivity(), new Observer<Float>() {
            @Override
            public void onChanged(Float tong) {
                mEtTongChi.setText(""+tong);
            }
        });
        mThongKeViewModel.getThongKeLoaiChis().observe(getActivity(), new Observer<List<ThongKeLoaiChi>>() {
            @Override
            public void onChanged(List<ThongKeLoaiChi> thongKeLoaiChis) {
                mThongKeLoaiChiAdapter.setList(thongKeLoaiChis);
            }
        });
        return view;
    }
}