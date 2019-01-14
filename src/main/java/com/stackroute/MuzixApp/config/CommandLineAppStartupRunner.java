package com.stackroute.MuzixApp.config;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.repository.MusicRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);


    private MusicRepository musicRepository;

    @Autowired
    public CommandLineAppStartupRunner(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Initial Data Entry.....");

        Track track1 = new Track();
        musicRepository.save(track1);

        Track track2 = new Track();
        musicRepository.save(track2);

        log.info("Initial Data Entered.....");
    }
}
