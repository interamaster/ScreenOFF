package com.mio.jrdv.screenoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by joseramondelgado on 23/12/16.
 */



public class ShellExecuter {

    public ShellExecuter() {

    }

    public String Executer(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = output.toString();
        return response;

    }
}