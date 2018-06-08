package com.example.anarg.openmap2;

import org.junit.Test;
import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void JsonTest(){
        BackEnd b=new BackEnd();
        String s= b.postRequest("http://tms.affineit.com:4445/SignalAhead/Json/SignalAhead","",true);
        ArrayList<Train> t=b.jsonGov(s);
//        System.out.print(t);
        String s2=b.getRequest("http://192.168.43.115/jsonrender.php");
        System.out.print(b.jsonPlot(s2));
        HashMap<String,GeoPoint> m=b.jsonPlot(s2);
        for (String so: m.keySet()){
            System.out.println(so+": "+m.get(so));
        }
    }
}