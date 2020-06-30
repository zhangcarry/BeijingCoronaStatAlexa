import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.LaunchRequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.io.IOException;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class CustomLaunchRequestHandler implements LaunchRequestHandler {

    JavaGetRequest javaGetRequest = new JavaGetRequest();

    public boolean canHandle(HandlerInput handlerInput, LaunchRequest launchRequest) {
        return handlerInput.matches(requestType(LaunchRequest.class));
    }

    public Optional<Response> handle(HandlerInput handlerInput, LaunchRequest launchRequest) {
        String response = "";
        try {
            CoronaCase coronaCase = JavaGetRequest.getCoronaCase();
            int active = coronaCase.getActive();
            switch (active) {
                case 0:
                    response += "There're no active coronavirus cases in Beijing as of today, ";
                    break;
                case 1:
                    response += "1 active case of coronavirus has been reported in Beijing as of today, ";
                    break;
                default:
                    response += "There're "+active+" active  coronavirus cases in Beijing as of today, ";
                    break;
            }
            int death = coronaCase.getDeath();
            int confirmed = coronaCase.getConfirmed();
            response += "bring a total of "+confirmed+" cases, ";
            switch (death) {
                case 0:
                    response += "with no deaths recorded.";
                    break;
                case 1:
                    response += "including 1 death.";
                    break;
                default:
                    response += "including "+death+" death cases.";
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
            response += "The server cannot be reached";
        }

        return handlerInput.getResponseBuilder()
                .withSpeech(response)
                .build();
    }
}
