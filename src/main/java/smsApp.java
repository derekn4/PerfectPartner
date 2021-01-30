import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

import static spark.Spark.*;


import java.io.IOException;

public class smsApp {
    public static String message = "what can I do for you today?";
    public static user;
    public static String reqBody;
    public static void main(String[] args) {
        HashMap<String, String> userDB = new HashMap<>();
        get("/", (req, res) -> "Hi I'm lonely ):");

        post("/sms", (req, res) -> {
            reqBody = req.queryParams("Body");
            user = req.queryParams("From");
            if (!userDB.containsKey(user)){
                userDB.put(user, "");
                message = "hello there! I see you need assistance, what can I do for you? :)"
            }
            res.type("application/xml");

            Body body = new Body.Builder("The Robots are coming! Head for the hills!").build();
            Message sms = new Message.Builder().body(body).build();
            MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
            return twiml.toXml();
        });
    }
}