package com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;


public class MaintenanceRequestTest {
        @Test
        public void constructorTest01() {
            MaintenanceRequest maintenanceRequest = new MaintenanceRequest("Demo", "User", "demo@user.com", "123", "Sold", "2023-10-23");
            maintenanceRequest.setId(1L);

            String expected = "1 Demo User demo@user.com 123 Sold 2023-10-23";
            String actual = maintenanceRequest.toString();

            Assertions.assertEquals(expected, actual);
        }
    }