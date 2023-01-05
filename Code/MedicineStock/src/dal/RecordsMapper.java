
package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.dto.PharmacistDTO;


public class RecordsMapper {
  
    
    // Read records from data base 
    
    ArrayList<PharmacistDTO> getMedicine(ResultSet rs) {
        ArrayList<PharmacistDTO> emplist = new ArrayList<>();
        try{
        while (rs.next())
            {
                PharmacistDTO objMedicine=new PharmacistDTO();                
                objMedicine.id=rs.getString(1);
                objMedicine.name= rs.getString(2);
                objMedicine.father_Name=rs.getString(3);
                objMedicine.email = rs.getString(4);
                objMedicine.contact= rs.getString(5);
                objMedicine.address= rs.getString(6);
//                objMedicine.salary= rs.getDouble(7);
                emplist.add(objMedicine);
            }
        }catch (Exception e){
        }
        return emplist;
    }
    
}
