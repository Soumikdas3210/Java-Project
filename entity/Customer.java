package entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

import classes.*;
import views.LoginFrame;

public class Customer extends User {
    private String question;
    private String answer;
    public void setQuestion (String question){
        this.question = question;
    }
    public void setAnswer (String answer){
        this.answer = answer;
    }
    public String getQuestion(){
        return this.question;
    }
    public String getAnswer(){
        return this.answer;
    }

    public Customer() {
        super();
    }

    public Customer(String username, String password) {
        super(username, password);
        File f = new File("data/user.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {

                String words[] = line.split("\t");
                if (words[0].equals(username) && words[1].equals(password)) {
                    this.setEmail(words[2]);
                    this.setAnswer(words[5]);
                    this.setQuestion(words[4]);
                }
            }
        } catch (Exception ex3) {
            System.out.println(ex3.getMessage());
        }
    }
}