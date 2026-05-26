package com.eduhub1.eduhub_backend1.component;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class LoggerComponent {
    
    public void logInfo(String message) {
        System.out.println("[INFO] " + LocalDateTime.now() + " - " + message);
    }
    
    public void logError(String message) {
        System.out.println("[ERROR] " + LocalDateTime.now() + " - " + message);
    }
}
