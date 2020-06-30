import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class SimpleStreamHandler extends SkillStreamHandler {

    public SimpleStreamHandler() {
        super(Skills.standard()
                .addRequestHandler(new CustomLaunchRequestHandler())
                .build());
    }
}