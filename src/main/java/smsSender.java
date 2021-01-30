import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class smsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC28e1ee7c89b06cbe3d753e5790a411d7";
    public static final String AUTH_TOKEN =
            "7e7df97b1482b6a5bbc60c4823efc3b0";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+17142036625"), // to
                        new PhoneNumber("+17142036625"), // from
                        "Function Call to Weather or a Hello")
                .create();

        System.out.println(message.getSid());
    }
}