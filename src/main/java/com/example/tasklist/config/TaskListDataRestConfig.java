package com.example.tasklist.config;

import com.example.tasklist.entity.Task;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class TaskListDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Configure CORS
        cors.addMapping("/**")
                .allowedOrigins("https://task-list-app-01.netlify.app/") // Replace with your Netlify domain
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

        // Expose entity IDs
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // Expose IDs for the Task entity
        config.exposeIdsFor(Task.class);
    }
}
