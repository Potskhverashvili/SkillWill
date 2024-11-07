package com.example.Assignments34_Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TimeManagementService {
    @Scheduled(fixedRate = 2000)
    private void twoSecondRateTask() {

        System.out.println("---Pass Two Second ---" + LocalDateTime.now() + "\n");
    }

    @Scheduled(fixedDelay = 3000)
    private void currentTimeEveryThreeSecond() {
        System.out.println("---Current Time Every Three Second---" + LocalDateTime.now() + "\n");
    }

    @Scheduled(cron = "* 15 6 */1 */1 *")
    private void setConcreteTime(){
        System.out.println("---Set Time 06:15---" + LocalDateTime.now() + "\n");
    }
}
