import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.stream.*;
import java.util.*;
import java.io.*;
import classfile.*;

// *j_json* *json* *json_array* *json_Serializable* *json_class* *j_json_example*
class Item implements Serializable {
    @SerializedName("_OrderDetails")
    private OrderDetails[] mOrderDetails;

    @SerializedName("Id")
    private String mId;
    public String getId(){
        return mId;
    }

    public OrderDetails[] getMOrderDetails(){ 
        return mOrderDetails;
    }

    @SerializedName("OrderData")
    private String mOrderDate;

    @SerializedName("Number")
    private String mNumber;

    @SerializedName("CustomerName")
    private String mCustomerName;

    @SerializedName("Note")
    private String mNote;

    // Add setters and getters

    public static class OrderDetails implements Serializable {
        @SerializedName("ProductName")
        private String mProductName;
        String getMProductName(){
            return mProductName;
        }

        @SerializedName("TotalAfterDiscount_Lc")
        private String mTotalAfterDiscount;

        @SerializedName("MeasureUnitName")
        private String mMeasureUnitName;

        @SerializedName("TotalPrice_Lc")
        private String mTotalPrice;

        @SerializedName("PricePerUnit_Lc")
        private String mPricePerUnit;

        @SerializedName("Quantity")
        private String mQuantity;

        // Add setters and getters
    }
}

public class JsonArray {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();
        String responseJSON = "[\n" +
                              "  {\n" +
                              "    \"_OrderDetails\": [\n" +
                              "      {\n" +
                              "         \"ProductName\": \"FUCHS SUPER GT SAE 10W30 6X5 / FP10100010102\",\n" +
                              "        \"TotalAfterDiscount_Lc\": \"7500\",\n" +
                              "        \"MeasureUnitName\": \"كرتونة\",\n" +
                              "        \"TotalPrice_Lc\": \"7500\",\n" +
                              "        \"PricePerUnit_Lc\": \"75\",\n" +
                              "        \"Quantity\": \"100\"\n" +
                              "      }\n" +
                              "    ],\n" +
                              "    \"Id\": \"274\",\n" +
                              "    \"OrderDate\": \"4/10/2014 12:00:00 AM\",\n" +
                              "    \"Number\": \"16\",\n" +
                              "    \"CustomerName\": \"الأسد\",\n" +
                              "    \"Note\": \"\"\n" +
                              "  }\n" +
                              "]";

        Item[] placelist;
        Gson gson = new Gson();
        placelist = gson.fromJson(responseJSON, Item[].class);
        System.out.println(Arrays.toString(placelist));
        for(Item m : placelist){
            Print.pbl(m.getId());
            for(Item.OrderDetails order : m.getMOrderDetails()){
                Print.pbl(order.getMProductName());
            }
        }

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        Aron.end();
    }
}


