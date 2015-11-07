import java.io.*;
import java.lang.String;
import java.util.*;

class Encounter{
    public List<UserInfo> list = new ArrayList<UserInfo>();
    public Encounter(UserInfo user1, UserInfo user2) {
        list.add(user1);
        list.add(user2);
    }
}

class HighLight
{
    public static void main(String args[])
    {
        try {
            Map<String, List<UserInfo>> map = new HashMap<String, List<UserInfo>>();
            List<UserInfo> list = new ArrayList<UserInfo>();
            BufferedReader in = new BufferedReader(new FileReader("userdata.txt"));	
            String line;
            while((line = in.readLine()) != null) {
                line = line.trim();
                String[] array = line.split("\\|");
                if(array.length == 4){
                    long unixTime = Long.parseLong(array[1], 10);  
                    double longitude = Double.parseDouble(array[2]);  
                    double latitude = Double.parseDouble(array[3]);  
                    UserInfo info = new UserInfo(array[0], unixTime, longitude, latitude);
                    list.add(info);

                    List<UserInfo> listUserInfo = map.get(array[0]);
                    if(listUserInfo == null){
                        UserInfo info1 = new UserInfo(array[0], unixTime, longitude, latitude);
                        listUserInfo = new ArrayList<UserInfo>();
                        listUserInfo.add(info1);
                        map.put(array[0], listUserInfo);
                    }
                    else{
                        listUserInfo.add(new UserInfo(array[0], unixTime, longitude, latitude));
                    }
                }
            }

            Collections.sort(list);

            for(UserInfo info: list){
                //System.out.println("name=[" + info.name + "]ut=[" + info.unixTime + "]longitude=[" + info.longitude + "]latitude=[" + info.latitude + "]"); 
            }
            System.out.println(); 

            List<List<UserInfo>> listList = new ArrayList<List<UserInfo>>();
            for(Map.Entry<String, List<UserInfo>> entry: map.entrySet()){
                String myKey = entry.getKey();
                List<UserInfo> listUserInfo = entry.getValue();
                listList.add(listUserInfo);
                for(UserInfo info: listUserInfo){
                    System.out.println("name=[" + info.name + "]ut=[" + info.unixTime + "]longitude=[" + info.longitude + "]latitude=[" + info.latitude + "]"); 
                }
                System.out.println();  
            }
            
            Map<String, List<Encounter>> encounterMap = new HashMap<String, List<Encounter>>();
            for(int i=0; i<listList.size(); i++){
                List<UserInfo> myList = listList.get(i);
                for(UserInfo elem1: myList){
                    for(int k=i+1; k<listList.size(); k++){
                        List<UserInfo> otherList= listList.get(k);
                        for(UserInfo elem2: otherList){
                            generateEncouter(elem1, elem2, encounterMap);
                        }
                    }
                }
            }
            for(Map.Entry<String, List<Encounter>> entry: encounterMap.entrySet()){
                String key = entry.getKey();
                List<Encounter> encounter = entry.getValue();
                System.out.println("key=[" + key + "]"); 
                for(Encounter en: encounter){
                    System.out.println(key + "->["+en.list.get(0).unixTime+"] [" + en.list.get(1).unixTime+"]"); 
                }
            }
            in.close();
        }
        catch(IOException io) {
            io.printStackTrace();
        }
    }

    public static void generateEncouter(UserInfo elem1, UserInfo elem2, Map<String, List<Encounter>> encounterMap) {
        double sixHours = 3600*6;
        double oneDay = 3600*24;
        double diff = Math.abs(elem1.unixTime - elem2.unixTime);
        if(diff <= sixHours)
        {
            String pair = elem1.name + elem2.name;
            List<Encounter> enList = encounterMap.get(pair);
            if(enList != null){
                Encounter en = enList.get(enList.size()-1);
                double max = Math.max(elem1.unixTime, elem2.unixTime);

                if(Math.abs(en.list.get(1).unixTime - max) >= oneDay){
                    double haverSine = haversine(elem1.latitude, elem1.longitude, elem2.latitude, elem2.longitude);
                    if(haverSine <= 150)
                    {
                        System.out.print("harvS=["+haverSine+"]"); 
                        System.out.print("name=[" + elem1.name + "]ut=[" + elem1.unixTime + "]->"); 
                        System.out.println("name=[" + elem2.name + "]ut=[" + elem2.unixTime + "]"); 
                        if(elem2.unixTime > elem1.unixTime){
                            enList.add(new Encounter(elem1, elem2));
                        }
                        else{
                            enList.add(new Encounter(elem2, elem1));
                        }
                    }
                }
            }
            else{
                List<Encounter> newList = new ArrayList<Encounter>(); 
                if(elem2.unixTime > elem1.unixTime){
                    newList.add(new Encounter(elem1, elem2));
                }
                else{
                    newList.add(new Encounter(elem2, elem1));
                }
                encounterMap.put(pair, newList);
            }
        }
    }

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371009; // In Meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
}
