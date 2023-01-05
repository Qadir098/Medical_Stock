/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.PharmacistDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

public class RecordsAdder {

    void saveEmployee(PharmacistDTO objPhar, Response objResponse, Connection dbConnection) {
        try{
            
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO Pharmacist (Name,father_Name,Email,Contact, Address ) VALUES (?,?,?,?,?);");
            p.setString(1, objPhar.name);
            p.setString(2, objPhar.father_Name);
            p.setString(3, objPhar.email);
            p.setString(4, objPhar.contact);
            p.setString(5, objPhar.address);
//            p.setDouble(6, objPhar.salary);
            
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
