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
    public static final String IMAGE_ID = "imageId";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String DESCRIPTION = "description";
    Bundle bundle;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bind = DataBindingUtil.inflate(inflater, R.layout.details_activity, container, false);
        View rootView = bind.getRoot();

        bundle = getArguments();
        if (bundle != null) {
            int imageId = bundle.getInt(IMAGE_ID);
            String name = bundle.getString(NAME);
            String address = bundle.getString(ADDRESS);
            String description = bundle.getString(DESCRIPTION);
            bind.locationImage.setImageDrawable(getResources().getDrawable(imageId));
            bind.titleView.setText(name);
            bind.addressView.setText(address);
            bind.locationDescription.setText(description);
            getActivity().setTitle(name);
        } else {
        bind.locationImage.setImageDrawable(getResources().getDrawable(R.drawable.wolomin_panorama));
        bind.titleView.setText(R.string.about_wolomin);
        bind.addressView.setText(R.string.wolomin_coordinates);
        bind.locationDescription.setText(R.string.wolomin_info);
        }

        bind.addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapsUri;
                if (bundle == null) {
                    mapsUri = Uri.parse("geo:@52.3425904,21.2011826,13z?q=Wołomin");
                } else {
                    StringBuilder address = new StringBuilder();
                    address.append("geo:@0,0?q=").append(bind.addressView.getText().toString()).
                            append(" ").append(getString(R.string.wolomin));
                    mapsUri = Uri.parse(address.toString());
                }
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        if (bundle != null) {
            getActivity().setTitle(bundle.getString(NAME));
        } else {
            getActivity().setTitle(R.string.app_name);
        }
    }
}
