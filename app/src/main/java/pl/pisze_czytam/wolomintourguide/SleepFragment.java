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

public class SleepFragment extends Fragment {

    public SleepFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Location> sleepLocs = new ArrayList<>();
        sleepLocs.add(new Location(R.drawable.hotel_livia, getString(R.string.livia), getString(R.string.livia_address), getString(R.string.livia_info)));
        sleepLocs.add(new Location(R.drawable.alexandra, getString(R.string.alexandra), getString(R.string.alexandra_address), getString(R.string.alexandra_info)));
        sleepLocs.add(new Location(R.drawable.u_stefaniakow, getString(R.string.stefaniacy), getString(R.string.stefaniacy_address), getString(R.string.stefaniacy_info)));
        sleepLocs.add(new Location(R.drawable.dom_mysliwski, getString(R.string.mysliwski), getString(R.string.mysliwski_address), getString(R.string.mysliwski_info)));
        sleepLocs.add(new Location(R.drawable.trylogia, getString(R.string.trylogia), getString(R.string.trylogia_address), getString(R.string.trylogia_info)));

        Collections.sort(sleepLocs, new Comparator<Location>() {
            @Override
            public int compare(Location loc1, Location loc2) {
                return loc1.getLocationName().compareTo(loc2.getLocationName());
            }
        });

        LocationAdapter locAdapter = new LocationAdapter(getActivity(), 0, sleepLocs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainFragment detailFragment = new MainFragment();
                Bundle bundle = new Bundle();
                int imageId = sleepLocs.get(position).getImageResource();
                String name = sleepLocs.get(position).getLocationName();
                String address = sleepLocs.get(position).getLocationAddress();
                String description = sleepLocs.get(position).getLocationDescription();
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