package pl.pisze_czytam.wolomintourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EatFragment extends Fragment {

    public EatFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        ArrayList<Location> eatLocs = new ArrayList<>();
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.kebab_king), getString(R.string.kebab_address)));
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.pobite_talerze), getString(R.string.pobite_address)));
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.street_food), getString(R.string.street_address)));
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.przystanek_w), getString(R.string.przystanek_address)));
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.wakacje_na_poludniu), getString(R.string.wakacje_na_poludniu)));
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.obiadek_patelnia), getString(R.string.obiadek_p_address)));
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.obiadek_wilenska), getString(R.string.obiadek_w_address)));
        eatLocs.add(new Location(R.drawable.biesiadowo, getString(R.string.biesiadowo), getString(R.string.biesiadowo_address)));
        eatLocs.add(new Location(R.drawable.wolomin_panorama, getString(R.string.thai_viet), getString(R.string.thai_viet_address)));

        Collections.sort(eatLocs, new Comparator<Location>() {
            @Override
            public int compare(Location loc1, Location loc2) {
                return loc1.getLocationName().compareTo(loc2.getLocationName());
            }
        });

        LocationAdapter locAdapter = new LocationAdapter(getActivity(), 0, eatLocs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locAdapter);

        return rootView;
    }
}
