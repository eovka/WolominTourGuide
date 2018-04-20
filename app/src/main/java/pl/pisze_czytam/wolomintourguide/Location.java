package pl.pisze_czytam.wolomintourguide;

public class Location {
    private int imageResourceId;
    private String locationName;
    private String locationDescription;

    public Location (int imageResId, String locName, String locDescription){
        imageResourceId = imageResId;
        locationName = locName;
        locationDescription = locDescription;
    }

    public int getImageResource() {
        return imageResourceId;
    }
    public String getLocationName() {
        return locationName;
    }
    public String getLocationDescription() {
        return locationDescription;
    }
}
