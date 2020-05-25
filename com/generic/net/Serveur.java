package com.generic.net;

import java.net.ServerSocket;

public class Serveur extends Thread {
    private ServerSocket ss;
    private int port;
    private boolean stop;

    public static Serveur instance;

    public static void main(String[] args) {
        Serveur s = new Serveur(80);
        s.start();
    }

    public Serveur(int port) {
        instance = this;
        this.port = port;
        // ? Instanciation d'objets a faire ici
    }

    public void run() {
        try {
            ss = new ServerSocket(port);
            System.out.println(ss.toString());
            stop = false;
            while (!stop) {
                Connexion c = new Connexion(ss.accept());
                c.start();
                // ? Traitement post connexion au niveau du serveur à faire ici.
            }
            // ? Nettoyage / vidage / sauvegarde a faire ici
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        this.stop = true;
        try {
            ss.close();
        } catch (Exception e) {
        }
    }
}