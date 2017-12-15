package cristianpaciencia.com.basemvpwithtest.model.pojos;

import io.realm.RealmObject;

/**
 * Created by cristian on 16/11/17.
 */
public class Geo extends RealmObject {
    private String lng;

    private String lat;

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "ClassPojo [lng = " + lng + ", lat = " + lat + "]";
    }
}