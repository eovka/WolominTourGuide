package pl.pisze_czytam.wolomintourguide;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.pisze_czytam.wolomintourguide.databinding.DetailsActivityBinding;

import static android.graphics.Typeface.BOLD;

public class MainFragment extends Fragment {
    DetailsActivityBinding bind;
    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bind = DataBindingUtil.inflate(inflater, R.layout.details_activity, container, false);
        View rootView = bind.getRoot();

        bind.locationImage.setImageDrawable(getResources().getDrawable(R.drawable.wolomin_panorama));
        bind.titleView.setText(R.string.about_wolomin);
        bind.addressView.setText(R.string.wolomin_coordinates);
        bind.locationDescription.setText(R.string.wolomin_info);

        bind.addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapsUri = Uri.parse("geo:@52.3425904,21.2011826&q=Wołomin");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        return rootView;
    }
}
