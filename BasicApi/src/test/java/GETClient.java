import org.restsharp.RestClient;
import org.restsharp.RestRequest;
import org.restsharp.RestResponse;

public class GETClient {
    public static void executeGet(RestClient client) {
        // Create a RestRequest instance for the GET method
        RestRequest getRequest = new RestRequest("resource", RestRequest.Method.GET);

        // Execute the GET request
        RestResponse getResponse = client.Execute(getRequest);

        // Check if the GET request was successful
        if (getResponse != null && getResponse.IsSuccessful()) {
            System.out.println("GET Request successful with status code: " + getResponse.getStatusCode());
            System.out.println("Response: " + getResponse.getContent());
        } else {
            System.out.println("GET Request failed with status code: " + getResponse.getStatusCode());
        }
    }
}
