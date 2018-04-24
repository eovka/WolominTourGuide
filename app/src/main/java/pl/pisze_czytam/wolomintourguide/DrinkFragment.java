package pl.pisze_czytam.wolomintourguide;

import android.os.Bundle;
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

import static pl.pisze_czytam.wolomintourguide.MainActivity.STACK;
import static pl.pisze_czytam.wolomintourguide.MainFragment.ADDRESS;
import static pl.pisze_czytam.wolomintourguide.MainFragment.DESCRIPTION;
import static pl.pisze_czytam.wolomintourguide.MainFragment.IMAGE_ID;
import static pl.pisze_czytam.wolomintourguide.MainFragment.NAME;

public class DrinkFragment extends Fragment {

    public DrinkFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Location> drinkLocs = new ArrayList<>();
        drinkLocs.add(new Location (R.drawable.taaka_ryba, getString(R.string.ryba), getString(R.string.ryba_address), getString(R.string.ryba_info)));
        drinkLocs.add(new Location (R.drawable.wwl_pub, getString(R.string.wwl_pub), getString(R.string.wwl_address), getString(R.string.wwl_info)));
        drinkLocs.add(new Location (R.drawable.offside, getString(R.string.offside), getString(R.string.offside_address), getString(R.string.offside_info)));
        drinkLocs.add(new Location (R.drawable.perun, getString(R.string.perun), getString(R.string.perun_address), getString(R.string.perun_info)));
        drinkLocs.add(new Location (R.drawable.pobite_talerze, getString(R.string.pobite_talerze), getString(R.string.pobite_address), getString(R.string.pobite_info)));
        drinkLocs.add(new Location (R.drawable.wakacje_poludnie, getString(R.string.wakacje_na_poludniu), getString(R.string.wakacje_address), getString(R.string.wakacje_info)));
        drinkLocs.add(new Location (R.drawable.przystanek_w, getString(R.string.przystanek_w), getString(R.string.przystanek_address), getString(R.string.przystanek_info)));

        Collections.sort(drinkLocs, new Comparator<Location>() {
            @Override
            public int compare(Location loc1, Location loc2) {
                return loc1.getLocationName().compareTo(loc2.getLocationName());
            }
        });

        LocationAdapter locAdapter = new LocationAdapter(getActivity(), 0, drinkLocs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainFragment detailFragment = new MainFragment();
                Bundle bundle = new Bundle();
                int imageId = drinkLocs.get(position).getImageResource();
                String name = drinkLocs.get(position).getLocationName();
                String address = drinkLocs.get(position).getLocationAddress();
                String description = drinkLocs.get(position).getLocationDescription();
                bundle.putInt(IMAGE_ID, imageId);
                bundle.putString(NAME, name);
                bundle.putString(ADDRESS, address);
                bundle.putString(DESCRIPTION, description);
                detailFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.getBackStackEntryCount();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, detailFragment).addToBackStack(STACK).commit();
            }
        });
        return rootView;
    }
}