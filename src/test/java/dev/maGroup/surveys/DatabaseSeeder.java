package dev.maGroup.surveys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class DatabaseSeeder {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    public void loadTestData() throws IOException {
        var resource = resourceLoader.getResource("classpath:test-data.json");
        var lines = Files.readAllLines(resource.getFile().toPath());
        String content = String.join("",lines);

        // ADD THE Surveys data
    }
}
