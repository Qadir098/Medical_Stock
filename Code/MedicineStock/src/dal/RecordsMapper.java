
package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.dto.MedicineDTO;


public class RecordsMapper {
  
    
    // Read records from data base 
    
    ArrayList<MedicineDTO> getMedicine(ResultSet rs) {
        ArrayList<MedicineDTO> emplist = new ArrayList<>();
        try{
        while (rs.next())
            {
                MedicineDTO objMedicine=new MedicineDTO();                
                objMedicine.Id=rs.getString(1);
                objMedicine.name= rs.getString(2);
                objMedicine.quantity=rs.getInt(3);
                objMedicine.price =(int) rs.getDouble(4);
                objMedicine.maniDate= rs.getDate(5).toString();
                objMedicine.expiryDate= rs.getDate(6).toString();
                objMedicine.typeOfMedicine= rs.getString(7);
                emplist.add(objMedicine);
            }
        }catch (Exception e){
        }
        return emplist;
    }
    
}
