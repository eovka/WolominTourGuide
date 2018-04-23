package pl.pisze_czytam.wolomintourguide;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.pisze_czytam.wolomintourguide.databinding.DetailsActivityBinding;

public class HistoryFragment extends Fragment {
    DetailsActivityBinding bind;

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bind = DataBindingUtil.inflate(inflater, R.layout.details_activity, container, false);
        View rootView = bind.getRoot();

        bind.locationImage.setImageDrawable(getResources().getDrawable(R.drawable.history_wolomin));
        bind.titleView.setText(R.string.history_wolomin);
        bind.addressView.setVisibility(View.GONE);
        bind.locationDescription.setText(R.string.history_text);

        return rootView;
    }
}
