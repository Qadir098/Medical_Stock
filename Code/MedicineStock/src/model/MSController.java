
package model;

import dal.DALManager;
import java.util.ArrayList;
import model.dto.MedicineDTO;
import model.dto.Response;
import model.validators.CommonValidator;


public class MSController {
    DALManager objDAL;
    public MSController(){
    objDAL = MSFactory.getInstanceOfDALManager();
    }

    public ArrayList<MedicineDTO> viewEmployees(String searchKey) {
        return objDAL.getMedicineList(searchKey);
    }

    public Response addEmployee(MedicineDTO objEmp) {
        Response objResponse = MSFactory.getResponseInstance();
        CommonValidator.validateEmployee(objEmp,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveEmployee(objEmp,objResponse);
        }
        return objResponse;
    }

    public Response deleteMedicine(String selectedId) {
        Response objResponse = MSFactory.getResponseInstance();
        objDAL.deleteEmployee(selectedId, objResponse);
        return objResponse;
    }
    public Response updateMedicine(String selectedId){
        Response objResponse= MSFactory.getResponseInstance();
        objDAL.updateMedicine(selectedId, objResponse);
        return objResponse;
    }
}
