package com.example.task1516.service;

import com.example.task1516.SchedulerBean;
import com.example.task1516.entity.Departure;
import com.example.task1516.entity.PostOffice;
import com.example.task1516.repository.DepartureRepository;
import com.example.task1516.repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ScheduleService implements SchedulerBean {

    @Autowired
    private final DepartureRepository departureRepository;
    @Autowired
    private final PostOfficeRepository officeRepository;

    public ScheduleService(DepartureRepository departureRepository, PostOfficeRepository officeRepository) {
        this.departureRepository = departureRepository;
        this.officeRepository = officeRepository;
    }


    @ManagedOperation
    @Scheduled(cron = "0 * * * * *")
    public void doScheduledTask() throws IOException {

        for (File myFile : new File("C:\\Users\\Илья\\Desktop\\шаблоны джава\\prac22").listFiles()) {
            if (myFile.isFile())
                myFile.delete();
        }

        List<Departure> departures = departureRepository.findAll();
        List<PostOffice> postOffices = officeRepository.findAll();


        for (int i = 0; i < departures.size(); i++) {
            File departure = new File("C:\\Users\\Илья\\Desktop\\шаблоны джава\\prac22\\departure_" + i + ".txt");
            FileWriter writer = new FileWriter(departure, true);
            writer.write(departures.get(i).toString());
            writer.close();
        }
        for (int i = 0; i < postOffices.size(); i++) {
            File postoffice = new File("C:\\Users\\Илья\\Desktop\\шаблоны джава\\prac22\\postoffice_" + i + ".txt");
            FileWriter writer = new FileWriter(postoffice, true);
            writer.write(postOffices.get(i).toString());
            writer.close();
        }
    }

}
