package pl.pisze_czytam.wolomintourguide;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.pisze_czytam.wolomintourguide.databinding.DetailsActivityBinding;

import static android.graphics.Typeface.BOLD;

public class MainFragment extends Fragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DetailsActivityBinding bind = DataBindingUtil.inflate(inflater, R.layout.details_activity, container, false);
        View rootView = bind.getRoot();

        bind.locationImage.setImageDrawable(getResources().getDrawable(R.drawable.wolomin_panorama));
        bind.titleView.setText(R.string.about_wolomin);
        bind.addressView.setText(R.string.wolomin_coordinates);
        bind.locationDescription.setText(R.string.wolomin_info);

        return rootView;
    }
}
