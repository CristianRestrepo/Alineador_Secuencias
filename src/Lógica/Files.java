/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;

import java.io.*;

/**
 *
 * @author USUARIO
 */
public class Files {

    FileInputStream input;
    File file;

    public Files() {

    }

    /*Abrir archivo*/
    public String openFile(File file) {
        String content = "";
        try {
            input = new FileInputStream(file);
            int asci;
            while ((asci = input.read()) != -1) {
                char character = (char) asci;
                content += character;
            }

        } catch (Exception e) {

        }
        return content;
    }

}
