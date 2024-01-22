package retaurant.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        displayCustomLogo();
    }

    private void displayCustomLogo() {
        System.out.println("API CHO NHA HANG DE NHAT QUAN - SAM SON");
        System.out.println("");
    }
}
