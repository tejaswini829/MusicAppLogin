package com.stackroute.MuzixApp.config;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.repository.MusicRepository;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = Logger.getLogger(StartupApplicationListener.class);

    private MusicRepository musicRepository;

    @Autowired
    public StartupApplicationListener(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Entering Data On Start");

        Track track1 = new Track();
        musicRepository.save(track1);

        Track track2 = new Track();
        musicRepository.save(track2);

        log.info("Initial data entered");


    }
}