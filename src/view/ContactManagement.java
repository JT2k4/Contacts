/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.Validation;
import java.util.ArrayList;
import model.Contact;

/**
 *
 * @author PC
 */
public class ContactManagement extends Menu  {
    private static String[] mc = {"Add a contact ", "Display all Contact", "Delete a Contact",  "Exit"};
    ArrayList<Contact> lc = new ArrayList<>();
    
    public ContactManagement() {
        super(mc, "Equation Program ");
    }
    public static void main(String[] args) {
        new ContactManagement().run();
    }

   @Override
    public void execute(int n) {
        switch(n){
            case 1:
                createContact(lc);
                break;
            case 2:
                printAllContact(lc);
                break;
            case 3:
                deleteContactd(lc);
                break;
            default:
                break;        
        }
    }
    public static void createContact(ArrayList<Contact> lc) {
        System.out.print("Enter id contact: ");
        int contactId = Validation.checkInputInt();
        System.out.print("Enter first name: ");
        String firstName = Validation.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = Validation.checkInputString();
        System.out.print("Enter group: ");
        String group = Validation.checkInputString();
        System.out.print("Enter address: ");
        String address = Validation.checkInputString();
        System.out.print("Enter phone: ");
        String phone = Validation.checkInputPhone();
        lc.add(new Contact(contactId, firstName + lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }
    public static void printAllContact(ArrayList<Contact> lc) {
        System.out.printf("%-5s%-20s%-20s%-20s%-20s%-20s\n", "Id",
                "First name", "Last name", "Group", "Address", "Phone");
        //print infomation of contact from first to last list contact
        for (Contact contact : lc) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }
    public static void deleteContactd(ArrayList<Contact> lc) {
        System.out.print("Enter id: ");
        int idDelete = Validation.checkInputInt();
        Contact contactDelete = getContactById(lc, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            lc.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    //get contact by id
    public static Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        for (Contact contact : lc) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }

}
