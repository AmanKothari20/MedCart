package med.cart;

public class UserLocation {
    private String UserId;
    private String User_Location_long;
    private String User_Location_Lat;

    public UserLocation() {
    }

    public String getUserId() {
        return UserId;
    }

    public String getUser_Location_long() {
        return User_Location_long;
    }

    public String getUser_Location_Lat() {
        return User_Location_Lat;
    }

    public void setUser_Location_long(String user_Location_long) {
        User_Location_long = user_Location_long;
    }

    public void setUser_Location_Lat(String user_Location_Lat) {
        User_Location_Lat = user_Location_Lat;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }


}
