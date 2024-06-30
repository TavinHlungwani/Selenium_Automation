
public class POSTClient {
    public static void main(String[] args) {
        // Define the base URL
        String baseUrl = "https://api.example.com/";

        // Create a RestClient instance
        RestClient client = new RestClient(baseUrl);

        // Create a RestRequest instance for the POST method
        RestRequest request = new RestRequest("resource", RestRequest.Method.POST);

        // Add any request body if needed
        // request.AddJsonBody("{\"key\":\"value\"}");

        // Execute the POST request
        RestResponse response = client.Execute(request);

        // Check if the POST request was successful
        if (response != null && response.IsSuccessful()) {
            System.out.println("POST Request successful with status code: " + response.getStatusCode());

            // Now, execute the GET request
            GETClient.executeGet(client);
        } else {
            System.out.println("POST Request failed with status code: " + response.getStatusCode());
        }
    }
}