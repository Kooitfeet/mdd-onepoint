package io.gatling.gop;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import db.GatlingResultsToDatabase;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class ConnectionSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://onepoint.wd3.myworkdayjobs.com")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*", ".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*", ".*www\\.google\\.com.*", ".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("fr,fr-FR;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36 Edg/119.0.0.0");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("pragma", "no-cache"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("Accept", "*/*"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "cross-site"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("origin", "https://onepoint.wd3.myworkdayjobs.com"),
    Map.entry("pragma", "no-cache"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Accept", "application/xml, application/json"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Content-Type", "application/x-www-form-urlencoded"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("X-CALYPSO-CSRF-TOKEN", "46919679-2b30-401c-b6a0-62240ae5b6c9"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_6 = Map.ofEntries(
    Map.entry("Accept", "application/json"),
    Map.entry("Accept-Language", "fr-FR"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Content-Type", "application/x-www-form-urlencoded"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("X-CALYPSO-CSRF-TOKEN", "46919679-2b30-401c-b6a0-62240ae5b6c9"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_10 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "image"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_13 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Origin", "https://onepoint.wd3.myworkdayjobs.com"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "image"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_14 = Map.ofEntries(
    Map.entry("Accept", "application/json"),
    Map.entry("Accept-Language", "fr-FR"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Content-Type", "application/json"),
    Map.entry("Origin", "https://onepoint.wd3.myworkdayjobs.com"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("X-CALYPSO-CSRF-TOKEN", "46919679-2b30-401c-b6a0-62240ae5b6c9"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_20 = Map.ofEntries(
    Map.entry("Accept", "application/xml, application/json"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Origin", "https://onepoint.wd3.myworkdayjobs.com"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Microsoft Edge\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private String uri1 = "https://cta-service-cms2.hubspot.com/ctas/v2/public/cs/preview/click";
  
  private String uri2 = "https://wd3.myworkdaycdn.com/wday/asset/candidate-experience-jobs/2023.46.30/compiled-lang";
  
  private String uri3 = "https://wd3.myworkday.com/wday/asset/client-analytics/uxInsights.min.js";

  private ScenarioBuilder scn = scenario("ConnectionSimulation")
    .exec(
      http("request_0")
        .get(uri1 + "?cta_guid=b93858d7-552d-47be-9de1-d37aa98cbad6&placement_guid=439e2dcc-f7ac-4538-9326-655aa649a267&portal_id=2820264&redirectUrl=https%3A%2F%2Fonepoint.wd3.myworkdayjobs.com%2Ffr-FR%2Fonepoint%3Futm_campaign%3DSortie%2520page%2520nous%2520rejoindre%26utm_source%3Dsite%2520web%26utm_medium%3Dworkday%26utm_content%3DCTA%2520nous%2520rejoindre%2520%2528corps%2520de%2520page%2529")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri3 + "?plate=BMT216A")
            .headers(headers_1),
          http("request_2")
            .get(uri2 + "/generic/fr-FR.json")
            .headers(headers_2),
          http("request_3")
            .get(uri2 + "/cxs_job_posting_details/fr-FR.json")
            .headers(headers_2),
          http("request_4")
            .get(uri2 + "/cxs_search_labels/fr-FR.json")
            .headers(headers_2),
          http("request_5")
            .get("/wday/cxs/onepoint/onepoint/userprofile")
            .headers(headers_5),
          http("request_6")
            .get("/wday/cxs/onepoint/videoLabels")
            .headers(headers_6),
          http("request_7")
            .get("/wday/cxs/onepoint/onepoint/approot")
            .headers(headers_6),
          http("request_8")
            .get("/wday/cxs/onepoint/onepoint/sidebar")
            .headers(headers_6),
          http("request_9")
            .get("/wday/cxs/onepoint/onepoint/sidebar")
            .headers(headers_6),
          http("request_10")
            .get("/onepoint/assets/logo")
            .headers(headers_10),
          http("request_11")
            .get("/onepoint/assets/banner")
            .headers(headers_10),
          http("request_12")
            .get("/wday/cxs/onepoint/onepoint/sidebarimage/c7d837cbe4dd01963790aca52502ee00")
            .headers(headers_10),
          http("request_13")
            .get("/onepoint/assets/banner")
            .headers(headers_13),
          http("request_14")
            .post("/wday/cxs/onepoint/onepoint/jobs")
            .headers(headers_14)
            .body(RawFileBody("computerdatabase/connectionsimulation/0014_request.json"))
        ).check(status().saveAs("code")).check(currentLocation().saveAs("currentLocation"))
    ).exec(session -> {
            try {
              GatlingResultsToDatabase.insertTestData(Timestamp.from(Instant.now()),
                      session.get("currentLocation"), session.get("code"), "bouton de connexion");
            } catch (SQLException | ClassNotFoundException e) {
              throw new RuntimeException(e);
            }
            return session;
    })
    .pause(3)
    .exec(
      http("request_15")
        .get("/onepoint/assets/banner")
        .headers(headers_13)
        .resources(
          http("request_16")
            .get("/onepoint/assets/banner")
            .headers(headers_13)
        )
    )
    .pause(2)
    .exec(
      http("request_17")
        .get("/onepoint/assets/banner")
        .headers(headers_13)
    )
    .pause(5)
    .exec(
      http("request_18")
        .get("/onepoint/assets/logo")
        .headers(headers_10)
        .resources(
          http("request_19")
            .get("/wday/cxs/onepoint/onepoint/account/configuration")
            .headers(headers_6)
        )
    )
    .pause(8)
    .exec(
      http("request_20")
        .post("/fr-FR/onepoint/login")
        .headers(headers_20)
        .formParam("password", "Epfonepoint2023!")
        .formParam("username", "epfonepoint@gmail.com")
        .resources(
          http("request_21")
            .get("/wday/cxs/onepoint/onepoint/userprofile")
            .headers(headers_5),
          http("request_22")
            .get("/onepoint/assets/banner")
            .headers(headers_13)
        ).check(status().saveAs("code")).check(currentLocation().saveAs("currentLocation"))
    ).exec(session -> {
            try {
              GatlingResultsToDatabase.insertTestData(Timestamp.from(Instant.now()),
                      session.get("currentLocation"), session.get("code"), "requete de connexion");

            } catch (SQLException | ClassNotFoundException e) {
              throw new RuntimeException(e);
            }
            return session;
          });

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
