package model.validators;

import model.dto.PharmacistDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

public class CommonValidator {

    public static void validateEmployee(PharmacistDTO medicine, Response objResponse) {

        if (medicine.name == null || medicine.name.length() < 3) {

            objResponse.messagesList.add(new Message(" Name is not valid, Provide valid name with at least 3 characters.", MessageType.Error));
            //mesg = " Name is not valid, Provide valid name with at least 3 characters";
        } else if (medicine.name.length() >= 3 && medicine.name.length() <= 20) {
            for (int i = 0; i < medicine.name.length(); i++) {
                char c = medicine.name.charAt(i);
                if (Character.isDigit(c) || c == '!' || c == '@' || c == '#' || c == '$'
                        || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')'
                        || c == '/' || c == '}' || c == '{' || c == '[' || c == ']' || c == '"' || c == '|'
                        || c == '?' || c == '>' || c == '<' || c == '~' || c == '`' || c == '+' || c == '-' || c == '=' || c == '.' || c == ',') {
                    objResponse.messagesList.add(new Message("Name must not be contain digits", MessageType.Error));
                    // mesg = "Name must not be contain digits or special character";
                    break;
                }
            }

        } else {
            objResponse.messagesList.add(new Message("Name length limit cross ", MessageType.Error));
            //mesg = "Name length limit cross";
        }
        //return mesg;
    }
    
    

}


/*

 if (medicine.name == null || medicine.name.length() < 3) {

            objResponse.messagesList.add(new Message(" Name is not valid, Provide valid name with at least 3 characters.", MessageType.Error));
            //mesg = " Name is not valid, Provide valid name with at least 3 characters";
        } else if (medicine.name.length() >= 3 && medicine.name.length() <= 20) {
            for (int i = 0; i < medicine.name.length(); i++) {
                char c = medicine.name.charAt(i);
                if (Character.isDigit(c) || c == '!' || c == '@' || c == '#' || c == '$'
                        || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')'
                        || c == '/' || c == '}' || c == '{' || c == '[' || c == ']' || c == '"' || c == '|'
                        || c == '?' || c == '>' || c == '<' || c == '~' || c == '`' || c == '+' || c == '-' || c == '=' || c == '.' || c == ',') {
                    objResponse.messagesList.add(new Message("Name must not be contain digits",MessageType.Error));
                   // mesg = "Name must not be contain digits or special character";
                    break;
                }
            }

        } else {
            objResponse.messagesList.add(new Message("Name length limit cross ",MessageType.Error));
            //mesg = "Name length limit cross";
        }
        //return mesg;
    }

    public static String ValidMedicinePrice(Medicine medicine) {
        String mesg = "";
        if (medicine.name == null || medicine.name.length() < 3) {

            //objResponse.messagesList.add(new Message(" Name is not valid, Provide valid name with at least 3 characters.", MessageType.Error));
            mesg = " Name is not valid, Provide valid name with at least 3 characters";
        } else if (medicine.name.length() >= 3 && medicine.name.length() <= 20) {
            for (int i = 0; i < medicine.name.length(); i++) {
                char c = medicine.name.charAt(i);
                if (Character.isDigit(c)) {
                    //objResponse.messagesList.add(new Message("Name must not be contain digits",MessageType.Error));
                    mesg = "Name must not be contain digits";
                    break;
                }

            }

        } else {
//            objResponse.messagesList.add(new Message("Name length limit cross ",MessageType.Error));
            mesg = "Name length limit cross";
        }
        return mesg;
    }
    
}
*/
