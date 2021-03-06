package cristianpaciencia.com.basemvpwithtest.model.pojos;

import io.realm.RealmObject;

/**
 * Created by cristian on 16/11/17.
 */
public class Address extends RealmObject {
    private Geo geo;

    private String zipcode;

    private String street;

    private String suite;

    private String city;

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ClassPojo [geo = " + geo + ", zipcode = " + zipcode + ", street = " + street + ", suite = " + suite + ", city = " + city + "]";
    }
}