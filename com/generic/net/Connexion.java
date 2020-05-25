package com.generic.net;

import java.io.*;
import java.net.Socket;

public class Connexion extends Thread {
    private Socket s;
    private ObjectOutputStream commandOut;
    private ObjectInputStream commandIn;
    private boolean stop;

    public Connexion(Socket s) {
        this.s = s;

        try {
            commandIn = new ObjectInputStream(s.getInputStream());
            commandOut = new ObjectOutputStream(s.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            stop = false;
            while (!stop) {
                Command cmd = (Command) (commandIn.readObject());
                parseCommand(cmd);
            }

            commandIn.close();
            commandOut.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseCommand(Command cmd) {
        // ? lecture et traitement de la commande ici.
    }

    public void stopConnexion() {
        this.stop = true;
    }
}