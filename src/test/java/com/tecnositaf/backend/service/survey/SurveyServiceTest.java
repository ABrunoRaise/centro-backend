package com.tecnositaf.backend.service.survey;

import com.tecnositaf.backend.CentroBackendApplication;
import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.service.SurveyService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SurveyServiceTest {

    @Autowired
    SurveyService surveyService;

    @Test
    public void TestGetSurveyListService(){

        List<Survey> surveysActual  = surveyService.getSurveyList();
        assertSame(1, surveysActual.size());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Survey testSurvey = new Survey();
        testSurvey.setIdSurvey("5e8d8cfdf614ec1938287fda");
        testSurvey.setIdDeviceFk("DeViCeTeSt2");
        testSurvey.setTimestamp(LocalDateTime.parse("2020-03-24 14:58:00",formatter));
        testSurvey.setCpu(4.8);
        testSurvey.setRam(50.6);
        testSurvey.setDeviceTemperature(4.9);
        testSurvey.setAmbientTemperature(12.8);
        testSurvey.setAmbientPressure(14.5);

        assert(testSurvey.equals(surveysActual.get(0)));
    }

    @Test
    public void TestAddSurveyService(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Survey surveyToAdd = new Survey();
        surveyToAdd.setIdDeviceFk("DeviceAdded");
        surveyToAdd.setTimestamp(LocalDateTime.parse("2020-03-24 14:58:00",formatter));
        surveyToAdd.setCpu(4.8);
        surveyToAdd.setRam(50.6);
        surveyToAdd.setDeviceTemperature(4.9);
        surveyToAdd.setAmbientTemperature(12.8);
        surveyToAdd.setAmbientPressure(14.5);

        Survey surveyAdded = surveyService.addSurvey(surveyToAdd);
        surveyToAdd.setIdSurvey(surveyAdded.getIdSurvey());
        assert(surveyAdded.equals(surveyToAdd));
    }

    @Test
    public void TestUpdateSurveyByIdService(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Survey surveyToUpdate = new Survey();
        //Original -- DeViCeTeSt2
        surveyToUpdate.setIdSurvey("5e8d8cfdf614ec1938287fda");
        surveyToUpdate.setIdDeviceFk("DeviceTestUpdated");
        surveyToUpdate.setTimestamp(LocalDateTime.parse("2020-03-24 14:58:00",formatter));
        surveyToUpdate.setCpu(4.8);
        surveyToUpdate.setRam(50.6);
        surveyToUpdate.setDeviceTemperature(4.9);
        surveyToUpdate.setAmbientTemperature(12.8);
        surveyToUpdate.setAmbientPressure(14.5);

        Survey surveyUpdated = surveyService.updateSurveyById(surveyToUpdate);
        //surveyToAdd.setIdSurvey(surveyAdded.getIdSurvey());
        assert(surveyUpdated.equals(surveyToUpdate));
    }

    @Test
    public void TestGetSurveysFromDevice(){
        String deviceToSearch = "DeViCeTeSt2";

        List<Survey> surveysActual  = surveyService.getSurveysFromDevice(deviceToSearch);
        assertSame(1, surveysActual.size());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Survey testSurvey = new Survey();
        testSurvey.setIdSurvey("5e8d8cfdf614ec1938287fda");
        testSurvey.setIdDeviceFk("DeViCeTeSt2");
        testSurvey.setTimestamp(LocalDateTime.parse("2020-03-24 14:58:00",formatter));
        testSurvey.setCpu(4.8);
        testSurvey.setRam(50.6);
        testSurvey.setDeviceTemperature(4.9);
        testSurvey.setAmbientTemperature(12.8);
        testSurvey.setAmbientPressure(14.5);

        assert(testSurvey.equals(surveysActual.get(0)));
    }

    @Test
    public void TestGetSurveysFromDeviceWithTimestamp(){
        String deviceToSearch = "DeViCeTeSt2";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime timestampTest = LocalDateTime.parse("2020-03-24 14:58:00",formatter);

        List<Survey> surveysActual  = surveyService.getSurveysFromDevice(deviceToSearch,timestampTest);
        assertSame(1, surveysActual.size());

        Survey testSurvey = new Survey();
        testSurvey.setIdSurvey("5e8d8cfdf614ec1938287fda");
        testSurvey.setIdDeviceFk("DeViCeTeSt2");
        testSurvey.setTimestamp(timestampTest);
        testSurvey.setCpu(4.8);
        testSurvey.setRam(50.6);
        testSurvey.setDeviceTemperature(4.9);
        testSurvey.setAmbientTemperature(12.8);
        testSurvey.setAmbientPressure(14.5);

        assert(testSurvey.equals(surveysActual.get(0)));
    }

    @Test
    public void TestGetSurveysFromStorageYears(){
        int storageYearsToTest = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime timestampTest = LocalDateTime.parse("2020-03-24 14:58:00",formatter);

        List<Survey> surveysActual  = surveyService.getSurveysByStorageYears(storageYearsToTest);
        assertSame(1, surveysActual.size());

        Survey testSurvey = new Survey();
        testSurvey.setIdSurvey("5e8d8cfdf614ec1938287fda");
        testSurvey.setIdDeviceFk("DeViCeTeSt2");
        testSurvey.setTimestamp(timestampTest);
        testSurvey.setCpu(4.8);
        testSurvey.setRam(50.6);
        testSurvey.setDeviceTemperature(4.9);
        testSurvey.setAmbientTemperature(12.8);
        testSurvey.setAmbientPressure(14.5);

        assert(testSurvey.equals(surveysActual.get(0)));
    }

    @Test
    public void TestGetSurveyById(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime timestampTest = LocalDateTime.parse("2020-03-24 14:58:00",formatter);

        Survey surveyActual  = surveyService.getSurveyById("5e8d8cfdf614ec1938287fda");

        Survey testSurvey = new Survey();
        testSurvey.setIdSurvey("5e8d8cfdf614ec1938287fda");
        testSurvey.setIdDeviceFk("DeViCeTeSt2");
        testSurvey.setTimestamp(timestampTest);
        testSurvey.setCpu(4.8);
        testSurvey.setRam(50.6);
        testSurvey.setDeviceTemperature(4.9);
        testSurvey.setAmbientTemperature(12.8);
        testSurvey.setAmbientPressure(14.5);

        assert(testSurvey.equals(surveyActual));
    }

    @Test
    public void TestDeleteSurveyById(){

        String idSurveyToDelete = "5e8d8cfdf614ec1938287fda";
        surveyService.deleteSurvey(surveyService.getSurveyById(idSurveyToDelete));

        List<Survey> surveysActual  = surveyService.getSurveyList();
        assertSame(0, surveysActual.size());

    }
}
