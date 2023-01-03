package dal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MSFactory;
import model.dto.MedicineDTO;
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
    objConnection = new SQLConnection("jdbc:mysql://localhost:3306/","MedicalStock", "root","12345");
    objReader = new DBReader();
    objAdder = MSFactory.getInstanceOfAdder();
    this.objMapper=mapper;
    objModifier = MSFactory.getInstanceOfModifier();
    }
    
    public ArrayList<MedicineDTO> getMedicineList(String searchKey) {
                
        Connection  dbConnection = objConnection.getConnection();
        String viewMedicineQuery = "Select * from medicine";
        if(searchKey == null || searchKey.length() > 0)
        {
            viewMedicineQuery += " where name LIKE '%"+searchKey+"%' OR Id LIKE '%"+searchKey+"%' OR expiryDate LIKE '%"+searchKey+"%' OR price LIKE '%"+searchKey+"%';";
        }
        ResultSet rs = objReader.getRecords(viewMedicineQuery, dbConnection);
        return objMapper.getMedicine(rs);        
    }  
    public void saveEmployee(MedicineDTO objEmp, Response objResponse) {
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
            objModifier.deleteMedicine(selectedId,objResponse,dbConnection);
            return  objResponse;           
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to delete Medicine", MessageType.Error));
        //objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }
     public Response updateMedicine(String selectedId, Response objResponse) {
        try{
            
            Connection  dbConnection = objConnection.getConnection();
            objModifier.updateMedicine(selectedId,objResponse,dbConnection);
            return  objResponse;           
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to update Medicine", MessageType.Error));
        //objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }
}
