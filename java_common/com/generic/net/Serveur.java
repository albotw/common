package com.generic.net;

import java.net.ServerSocket;

public class Serveur extends Thread {
    private ServerSocket ss;
    private int port;
    private boolean stop;
    private ServerManager manager;

    public static Serveur instance;

    public static void main(String[] args) {
        Serveur s = new Serveur(80, null);
        s.start();
    }

    public Serveur(int port, ServerManager manager) {
        instance = this;
        this.port = port;
        manager.init();
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
                manager.newConnexion(c);
            }
            // ? Nettoyage / vidage / sauvegarde a faire ici
            manager.clean();
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