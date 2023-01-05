
package model;

import dal.DALManager;
import java.util.ArrayList;
import model.dto.PharmacistDTO;
import model.dto.Response;
import model.validators.CommonValidator;


public class MSController {
    DALManager objDAL;
    public MSController(){
    objDAL = MSFactory.getInstanceOfDALManager();
    }

    public ArrayList<PharmacistDTO> viewEmployees(String searchKey) {
        return objDAL.getEmployeesList(searchKey);
    }

    public Response addEmployee(PharmacistDTO objEmp) {
        Response objResponse = MSFactory.getResponseInstance();
        CommonValidator.validateEmployee(objEmp,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveEmployee(objEmp,objResponse);
        }
        return objResponse;
    }

    public Response deleteEmployee(String selectedId) {
        Response objResponse = MSFactory.getResponseInstance();
        objDAL.deleteEmployee(selectedId, objResponse);
        return objResponse;
    }
}
