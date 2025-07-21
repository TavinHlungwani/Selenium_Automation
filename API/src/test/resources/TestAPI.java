import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class TestAPI {

    public static void main(String[] args) {
        // Base URI for Reqres API
        RestAssured.baseURI = "https://reqres.in/api";

        // 1. Perform an HTTP operation to retrieve data from the endpoint
        Response response = RestAssured
                .get("/users/2"); // Fetch user with ID 2
        
        // 2. Print out the Status code if you successfully return results
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        // Check if the request is successful
        if (statusCode == 200) {
            // Parse the response JSON
            JSONObject jsonResponse = new JSONObject(response.getBody().asString());
            JSONObject userData = jsonResponse.getJSONObject("data");

            // 3. Print out the first name
            String firstName = userData.getString("first_name");
            System.out.println("First Name: " + firstName);

            // 4. Print out the URL which is in the response body
            String avatarUrl = userData.getString("avatar");
            System.out.println("Avatar URL: " + avatarUrl);

            // 5. Update the email address to yours
            JSONObject updatedUserData = new JSONObject();
            updatedUserData.put("email", "your.email@example.com");

            Response updateResponse = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .body(updatedUserData.toString())
                    .put("/users/2"); // Update user with ID 2

            // 6. Print out the new email address
            if (updateResponse.getStatusCode() == 200) {
                System.out.println("Updated Email: " + updatedUserData.getString("email"));
            }

            // 7. Delete the last name
            userData.remove("last_name");

            // 8. Print out the new last name (should not exist)
            System.out.println("Last Name After Deletion: " + userData.optString("last_name", "No Last Name"));
        } else {
            System.out.println("Failed to retrieve user data.");
        }
    }
}
