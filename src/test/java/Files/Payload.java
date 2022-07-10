package Files;

public class Payload {

    public static String AddPlace(String str) {
	return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
		+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \""+str+"\",\r\n"
		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
		+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
		+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://dadadadad.com\",\r\n"
		+ "  \"language\": \"Indian-IN\"\r\n" + "}\r\n" + "\r\n" + "";
    }

    public static String UpdatePlace(String placeid) {
	return "{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"70 Summer walk, Morroco\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n" + "}";
    }

    public static String CoursePrice() {
	return "{\r\n" + "\"dashboard\":{\r\n" + "\"purchaseAmount\":1673,\r\n" + "\"website\":\"www.asnhudhar.com\"\r\n"
		+ "},\r\n" + "\"courses\":[{\r\n" + "\"title\":\"sdshdshd\",\r\n" + "\"price\":67,\r\n"
		+ "\"copies\":9\r\n" + "},\r\n" + "{\r\n" + "\"title\":\"ffgf\",\r\n" + "\"price\":55,\r\n"
		+ "\"copies\":8\r\n" + "},\r\n" + "{\r\n" + "\"title\":\"hjhjh\",\r\n" + "\"price\":90,\r\n"
		+ "\"copies\":7\r\n" + "}]\r\n" + "}\r\n" + "";
    }

}
