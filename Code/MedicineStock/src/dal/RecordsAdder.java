/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.MedicineDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

public class RecordsAdder {

    void saveEmployee(MedicineDTO objEmp, Response objResponse, Connection dbConnection) {
        try{
            
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO medicine (name,quantity,price,maniDate, expiryDate,typeOfMedicine ) VALUES (?,?,?,?,?,?);");
            p.setString(1, objEmp.name);
            p.setInt(2, objEmp.quantity);
            p.setDouble(3, objEmp.price);
            p.setString(4, objEmp.maniDate);
            p.setString(5, objEmp.expiryDate);
            p.setString(6, objEmp.typeOfMedicine);
            
            int rowsInserted = p.executeUpdate();
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("Medicine added successfully.", MessageType.Information));
            }
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to create medicine!!!!!", MessageType.Error));
            System.out.println("weeping "+e.getMessage());
            //objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

}
