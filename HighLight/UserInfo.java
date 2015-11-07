public class UserInfo implements Comparable<UserInfo>{
    String name;
    long unixTime;
    double longitude;
    double latitude;
    public UserInfo(String name, long unixTime, double longitude, double latitude){
        this.name = name;
        this.unixTime = unixTime;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // Java 32-bit int will work until 2038 
    public int compareTo(UserInfo other) {
        if(this.unixTime == other.unixTime)
            return 0;
        else if(this.unixTime > other.unixTime)
            return 1; 
        else 
            return -1;
    }
}


