package com.generic.net;

public interface ServerManager {
    public void init();

    public void newConnexion(Connexion c);

    public void clean();
}