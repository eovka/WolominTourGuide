package pl.pisze_czytam.wolomintourguide;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.pisze_czytam.wolomintourguide.databinding.DetailsActivityBinding;

public class MainFragment extends Fragment {
    DetailsActivityBinding bind;
    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bind = DataBindingUtil.inflate(inflater, R.layout.details_activity, container, false);
        View rootView = bind.getRoot();

        Bundle bundle = getArguments();
        if (bundle != null) {
            int imageId = bundle.getInt("imageId");
            String name = bundle.getString("name");
            String description = bundle.getString("description");
            bind.locationImage.setImageDrawable(getResources().getDrawable(imageId));
            bind.titleView.setText(name);
            bind.addressView.setText(description);
        } else {
        bind.locationImage.setImageDrawable(getResources().getDrawable(R.drawable.wolomin_panorama));
        bind.titleView.setText(R.string.about_wolomin);
        bind.addressView.setText(R.string.wolomin_coordinates);
        bind.locationDescription.setText(R.string.wolomin_info);
        }

        bind.addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapsUri = Uri.parse("geo:@52.3425904,21.2011826,13z?q=Wołomin");
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
