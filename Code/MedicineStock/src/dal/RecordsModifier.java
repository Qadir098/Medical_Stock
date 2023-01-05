/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

/**
 *
 * @author Mukhtiar-HPC
 */
public class RecordsModifier {

    void deleteEmployee(String selectedId, Response objResponse, Connection dbConnection) {
        try{
            PreparedStatement p;// (FirstName,LastName,Title) VALUES (?,?,?);");
   
            p = dbConnection.prepareStatement("delete from Pharmacist where name=? OR Id=?");
            p.setString(1, selectedId);
            p.setString(2, selectedId);
            int rowsInserted = p.executeUpdate();
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("Medicine deleted successfully.", MessageType.Information));
            }
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to delete medicine.", MessageType.Error));
            //objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }
    
}
