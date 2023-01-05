package dal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MSFactory;
import model.dto.PharmacistDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

public class DALManager {
    IConnection objConnection;
    DBReader objReader;
    RecordsMapper objMapper;
    RecordsAdder objAdder;
    RecordsModifier objModifier;

    public DALManager(RecordsMapper mapper){
    objConnection = new SQLConnection("jdbc:mysql://localhost:3306/","medicineStock", "root","abdulqadir");
    objReader = new DBReader();
    objAdder = MSFactory.getInstanceOfAdder();
    this.objMapper=mapper;
    objModifier = MSFactory.getInstanceOfModifier();
    }
    
    public ArrayList<PharmacistDTO> getEmployeesList(String searchKey) {
                
        Connection  dbConnection = objConnection.getConnection();
        String viewMedicineQuery = "Select * from Pharmacist";
        if(searchKey == null || searchKey.length() > 0)
        {
            viewMedicineQuery += " where Name LIKE '%"+searchKey+"%' OR ID LIKE '%"+searchKey+"%' OR Father_Name LIKE '%"+searchKey+"%' OR Email"
                    + " LIKE '%"+searchKey+"%';";
        }
        ResultSet rs = objReader.getRecords(viewMedicineQuery, dbConnection);
        return objMapper.getMedicine(rs);        
    }  
    public void saveEmployee(PharmacistDTO objEmp, Response objResponse) {
        try{
            
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveEmployee(objEmp,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to create medicine????.", MessageType.Error));
       // objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

    public Response deleteEmployee(String selectedId, Response objResponse) {
        try{
            
            Connection  dbConnection = objConnection.getConnection();
            objModifier.deleteEmployee(selectedId,objResponse,dbConnection);
            return  objResponse;           
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to delete employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        //objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }
    
}
