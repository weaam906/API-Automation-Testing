package RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TrelloAPIs {
    public static void main(String[] args) {
        /*Global variables*/
        String BaseURL = "https://api.trello.com/1/";
        String BasePath = "organizations/";
        String APIKey = "f4002854f34c545a2abd2e016718c28a";
        String APIToken = "ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9";
        String displayName ="WeaamKamal";
        String boardID ="5bc26e4b048b79835e649265";

    // 1- Create a new organization  API==> {{BaseURL}}organizations/?key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9&displayName={displayName}
   RestAssured.given()
              .baseUri(BaseURL)
              .basePath(BasePath)
              .queryParam("key", APIKey)
              .queryParam("token",APIToken)
              .queryParam("displayName",displayName)
              .body("")
              .when().post();
            //.prettyPrint();

   // 2-Get Organizations for a member API ==> {{BaseURL}}members/me?organizations=all&key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9
      Response response = RestAssured.given()
              .baseUri(BaseURL+"members/me")
              .queryParam("organizations","all")
              .queryParam("key",APIKey)
              .queryParam("token",APIToken)
              .queryParam("displayName",displayName)
              .when().get();
     // response.prettyPrint();

    // 3-Create a board inside an organization API ==> {{BaseURL}}boards/?name=Api Board&key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9
        RestAssured.given()
                .baseUri(BaseURL)
                .basePath("boards/")
                .queryParam("name","Api Board")
                .queryParam("key", APIKey)
                .queryParam("token",APIToken)
                .body("")
                .when().post();
              //.prettyPrint();

    // 4-Get boards in an organization API ==> {{BaseURL}}members/me?boards=open&key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9
        Response boardResponse = RestAssured.given()
                .baseUri(BaseURL)
                .basePath("members/me")
                .queryParam("boards","open")
                .queryParam("key",APIKey)
                .queryParam("token",APIToken)
                .when().get();
        // boardResponse.prettyPrint();

    // 5-Create a new list API ==> {{BaseURL}}lists?name=Api List&idBoard={{boardID}}&key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9
        RestAssured.given()
                .baseUri(BaseURL)
                .basePath("lists")
                .queryParam("name","Api List")
                .queryParam("idBoard",boardID)
                .queryParam("key", APIKey)
                .queryParam("token",APIToken)
                .body("")
                .when().post();
              //.prettyPrint();

    // 6-Get all lists on a board API ==> {{BaseURL}}boards/5bc26e4b048b79835e649265/lists?key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9
        Response allListsResponse = RestAssured.given()
                .baseUri(BaseURL)
                .basePath("boards/5bc26e4b048b79835e649265/lists")
                .queryParam("key",APIKey)
                .queryParam("token",APIToken)
                .when().get();
       //  allListsResponse.prettyPrint();

    // 7-Archive a list API ==> {{BaseURL}}lists/63f81908f40c303b328db77d/closed?key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9&value=true
        RestAssured.given()
                .baseUri(BaseURL)
                .basePath("lists/63f81908f40c303b328db77d/closed")
                .queryParam("key",APIKey)
                .queryParam("token",APIToken)
                .queryParam("value","true")
                .when().put();
              //.prettyPrint();

    // 8-Delete a board API ==> {{BaseURL}}boards/6052265c5dc437253db43ecd?key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9
        RestAssured.given()
                .baseUri(BaseURL)
                .basePath("boards/6052265c5dc437253db43ecd")
                .queryParam("key",APIKey)
                .queryParam("token",APIToken)
                .when().delete();
              //.prettyPrint();

    // 9-Delete an organization API ==> {{BaseURL}}organizations/63f81a18b3ae4f72045730d4?key=f4002854f34c545a2abd2e016718c28a&token=ATTA5ee137a59b2027836e94c75acb71fe794a9d1df5cb4db9aa909f502325f83a6151E5A0A9
        RestAssured.given()
                .baseUri(BaseURL)
                .basePath("organizations/63f81a18b3ae4f72045730d4")
                .queryParam("key",APIKey)
                .queryParam("token",APIToken)
                .when().delete();
              //.prettyPrint();
    }
}
