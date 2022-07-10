package Resources;

import java.util.List;
import java.util.*;
import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {
    public AddPlace addPlaceLayout(String name, String language, String address) {
	AddPlace p = new AddPlace();
	p.setAccuracy(50);
	p.setAddress(address);
	p.setLanguage(language);
	p.setPhone_number("(+91)7856456987");
	p.setWebsite("https://rahulshettyacademy.com");
	p.setName(name);
	List<String> myList = new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	p.setTypes(myList);
	Location l = new Location();
	l.setLat(-38.888);
	l.setLng(33.7686);
	p.setLocation(l);
	return p;

    }

}
