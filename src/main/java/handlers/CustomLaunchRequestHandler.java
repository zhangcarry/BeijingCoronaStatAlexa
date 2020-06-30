package handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.LaunchRequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class CustomLaunchRequestHandler implements LaunchRequestHandler {

    public boolean canHandle(HandlerInput handlerInput, LaunchRequest launchRequest) {
        return handlerInput.matches(requestType(LaunchRequest.class));
    }

    public Optional<Response> handle(HandlerInput handlerInput, LaunchRequest launchRequest) {
        
        String response = "";
        int todayCases = 0;
        switch (todayCases) {
            case 0:
                response += "There're no new coronavirus cases in Beijing today, ";
                break;
            case 1:
                response += "1 new coronavirus case has been reported in Beijing today, ";
                break;
            default:
                response += "There're "+todayCases+" new reported coronavirus cases in Beijing today, ";
                break;
        }
        return Optional.empty();
    }
}
