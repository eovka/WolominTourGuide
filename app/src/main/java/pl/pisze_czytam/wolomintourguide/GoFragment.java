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

public class GoFragment extends Fragment {

    public GoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Location> goLocs = new ArrayList<>();
        goLocs.add(new Location(R.drawable.strawbale_house, getString(R.string.strawbale), getString(R.string.strawbale_address), getString(R.string.strawbale_info)));
        goLocs.add(new Location(R.drawable.grabicz, getString(R.string.grabicz), getString(R.string.grabicz_address), getString(R.string.grabicz_info)));
        goLocs.add(new Location(R.drawable.nalkowski_museum, getString(R.string.nalkowski_museum), getString(R.string.nalkowski_address), getString(R.string.nalkowski_info)));
        goLocs.add(new Location(R.drawable.wooden_house, getString(R.string.wooden_house), getString(R.string.wooden_address), getString(R.string.wooden_info)));
        goLocs.add(new Location(R.drawable.ossow, getString(R.string.ossow), getString(R.string.ossow_address), getString(R.string.ossow_info)));
        goLocs.add(new Location(R.drawable.kultura_cinema, getString(R.string.kultura_cinema), getString(R.string.kultura_address), getString(R.string.kultura_info)));
        goLocs.add(new Location(R.drawable.panorama_warsaw, getString(R.string.panorama), getString(R.string.panorama_address), getString(R.string.panorama_info)));

        Collections.sort(goLocs, new Comparator<Location>() {
            @Override
            public int compare(Location loc1, Location loc2) {
                return loc1.getLocationName().compareTo(loc2.getLocationName());
            }
        });

        LocationAdapter locAdapter = new LocationAdapter(getActivity(), 0, goLocs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainFragment detailFragment = new MainFragment();
                Bundle bundle = new Bundle();
                int imageId = goLocs.get(position).getImageResource();
                String name = goLocs.get(position).getLocationName();
                String address = goLocs.get(position).getLocationAddress();
                String description = goLocs.get(position).getLocationDescription();
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
