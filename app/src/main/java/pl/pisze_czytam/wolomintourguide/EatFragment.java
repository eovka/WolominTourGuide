package pl.pisze_czytam.wolomintourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static pl.pisze_czytam.wolomintourguide.MainFragment.ADDRESS;
import static pl.pisze_czytam.wolomintourguide.MainFragment.DESCRIPTION;
import static pl.pisze_czytam.wolomintourguide.MainFragment.IMAGE_ID;
import static pl.pisze_czytam.wolomintourguide.MainFragment.NAME;

public class EatFragment extends Fragment {

    public EatFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Location> eatLocs = new ArrayList<>();
        eatLocs.add(new Location(R.drawable.kebab_king, getString(R.string.kebab_king), getString(R.string.kebab_address), getString(R.string.kebab_info)));
        eatLocs.add(new Location(R.drawable.pobite_talerze, getString(R.string.pobite_talerze), getString(R.string.pobite_address), getString(R.string.pobite_info)));
        eatLocs.add(new Location(R.drawable.street_food, getString(R.string.street_food), getString(R.string.street_address), getString(R.string.street_info)));
        eatLocs.add(new Location(R.drawable.przystanek_w, getString(R.string.przystanek_w), getString(R.string.przystanek_address), getString(R.string.przystanek_info)));
        eatLocs.add(new Location(R.drawable.wakacje_poludnie, getString(R.string.wakacje_na_poludniu), getString(R.string.wakacje_address), getString(R.string.wakacje_info)));
        eatLocs.add(new Location(R.drawable.obiadek_patelnia, getString(R.string.obiadek_patelnia), getString(R.string.obiadek_p_address), getString(R.string.obiadek_p_info)));
        eatLocs.add(new Location(R.drawable.obiadek_wilenska, getString(R.string.obiadek_wilenska), getString(R.string.obiadek_w_address), getString(R.string.obiadek_w_info)));
        eatLocs.add(new Location(R.drawable.biesiadowo, getString(R.string.biesiadowo), getString(R.string.biesiadowo_address), getString(R.string.biesiadowo_info)));
        eatLocs.add(new Location(R.drawable.thai_viet, getString(R.string.thai_viet), getString(R.string.thai_viet_address), getString(R.string.thai_viet_info)));
        eatLocs.add(new Location(R.drawable.pizza_house, getString(R.string.pizza_house), getString(R.string.pizza_house_address), getString(R.string.pizza_house_info)));

        Collections.sort(eatLocs, new Comparator<Location>() {
            @Override
            public int compare(Location loc1, Location loc2) {
                return loc1.getLocationName().compareTo(loc2.getLocationName());
            }
        });

        LocationAdapter locAdapter = new LocationAdapter(getActivity(), 0, eatLocs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainFragment detailFragment = new MainFragment();
                Bundle bundle = new Bundle();
                int imageId = eatLocs.get(position).getImageResource();
                String name = eatLocs.get(position).getLocationName();
                String address = eatLocs.get(position).getLocationAddress();
                String description = eatLocs.get(position).getLocationDescription();
                bundle.putInt(IMAGE_ID, imageId);
                bundle.putString(NAME, name);
                bundle.putString(ADDRESS, address);
                bundle.putString(DESCRIPTION, description);
                detailFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, detailFragment).commit();
            }
        });

        return rootView;
    }
}
