package views;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import models.Account;

public class CommonMenu {
    static Boolean checkInt(String numString) {
        try { 
            Integer.parseInt(numString); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    static Boolean checkID(String id) {
        String firstPart = id.substring(0,1);
        String secondPart = id.substring(1, id.length());

        if(firstPart.equals("A") && secondPart.length() == 3 && checkInt(secondPart)) {
            return true;
        } 
        return false;
    }

    static Boolean checkPW(String pw) {
        boolean checkDigit = false, checkCharacter = false, checkSpecCharacter = false;
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

        if(pw.length() >= 8) {
            for(int i=0; i < pw.length(); i++) {
                char character = pw.charAt(i);
                if(Character.isDigit(character)) {
                    checkDigit = true;
                } else if (Character.isLetter(character)) {
                    checkCharacter = true;
                } else if (specialCharactersString.contains(Character.toString(character))) {
                    checkSpecCharacter = true;
                }
            }
    
            if(checkDigit && checkCharacter && checkSpecCharacter) {
                return true;
            }
        }

        System.out.println("Password must be at least 8 characters comprised by at least one character, one digit, and one special symbol");
        return false;
    }

    public static ArrayList<Account> loadAccounts(String filePath) {
        ArrayList<Account> accountResult = new ArrayList<Account>();
        ArrayList<String> accounts = loadFile(filePath);
		for (String account : accounts) {
            String[] information = account.split(",");
			if(information.length == 4){
				Account acc = new Account(information[0], information[1], information[2],information[3]);
                accountResult.add(acc);
			}
        }
        return accountResult;
    }

    public static ArrayList<String> loadFile(String filePath) {
        String data = "";
        ArrayList<String> list = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader fReader = new BufferedReader(reader);
			
            while ((data = fReader.readLine()) != null) {
                list.add(data);
            }

            fReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println("Cannot load file");
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String id = new String();
        String pw = new String();
        if (id.isEmpty()) {
            do {
                System.out.print("Enter id AXXX: ");
                id = input.nextLine();
            } while (!checkID(id));
        }
        
        if(pw.isEmpty()) {
            do {
                System.out.print("Enter password: ");
                pw = input.nextLine();
            } while (!checkPW(pw));
        }

        if(!id.isEmpty() && !pw.isEmpty()) {
            ArrayList<Account> accounts = loadAccounts("./data/accounts.dat");
            for(int i=0; i<accounts.size(); i++) {
                if(id.equals(accounts.get(i).getAccountID()) && pw.equals(accounts.get(i).getPassword())) {
                    System.out.println("Successfully login.");
                }
            }
        }
    }
}
