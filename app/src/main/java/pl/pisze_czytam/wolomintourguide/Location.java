package pl.pisze_czytam.wolomintourguide;

public class Location {
    private int imageResourceId;
    private String locationName;
    private String locationAddress;
    private String locationDescription;

    public Location (int imageResId, String locName, String locAddress, String locDescription){
        imageResourceId = imageResId;
        locationName = locName;
        locationAddress = locAddress;
        locationDescription = locDescription;
    }

    public int getImageResource() {
        return imageResourceId;
    }
    public String getLocationName() {
        return locationName;
    }
    public String getLocationAddress() {
        return locationAddress;
    }
    public String getLocationDescription() {
        return locationDescription;
    }
}
