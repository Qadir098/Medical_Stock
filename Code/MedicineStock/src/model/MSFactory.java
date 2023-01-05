
package model;

import dal.DALManager;
import dal.RecordsAdder;
import dal.RecordsMapper;
import dal.RecordsModifier;
import model.dto.Response;


public class MSFactory {

    static DALManager getInstanceOfDALManager() {
        return new DALManager(new RecordsMapper());
    }

    public static MSController getInstanceOfSMSController() {
        return new MSController();
    }

    static Response getResponseInstance() {
        return new Response();
    }

    public static RecordsAdder getInstanceOfAdder() {
        return new RecordsAdder();
    }

    public static RecordsModifier getInstanceOfModifier() {
        return new RecordsModifier();
    }
    
}
