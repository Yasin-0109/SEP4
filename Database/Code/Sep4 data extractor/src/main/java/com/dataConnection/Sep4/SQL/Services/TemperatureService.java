package com.dataConnection.Sep4.SQL.Services;

import com.dataConnection.Sep4.SQL.dao.Co2Repository;
import com.dataConnection.Sep4.SQL.dao.RoomRepository;
import com.dataConnection.Sep4.SQL.dao.TemperatureRepository;
import com.dataConnection.Sep4.SQL.model.Co2;
import com.dataConnection.Sep4.SQL.model.Device;
import com.dataConnection.Sep4.SQL.model.Room;
import com.dataConnection.Sep4.SQL.model.Temperature;
import com.dataConnection.Sep4.mongo.EUIMongoRepository;
import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {


    @Autowired
    TemperatureRepository temperature;

    @Autowired
    EUIMongoRepository er;

    @Autowired
    RoomRepository rr;

    private List<EUIMongo> EUI;

    @Scheduled(fixedRate = 5000)
    public void updateTemperature()
    {
        EUI = er.findAll();
        if(EUI!= null && temperature.findAll() != null) {

        int value = EUI.size()-temperature.findAll().size();


        for(int i =EUI.size()-value; i<EUI.size(); i++)
        {
            temperature.save(new Temperature("NORMAL",EUI.get(i).getDate(), EUI.get(i).getTemperature(),rr.findAll().get(EUI.get(i).getRoomId())));
        }
    }else {
            System.out.println("No values in db");
        }
    }
}
