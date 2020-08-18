package com.generic.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class ObjectIO {
    public static void pushObject(Object o, String IP, int port) throws Exception {
        Socket s = new Socket(IP, port);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        Serializable tmp = (Serializable) o;

        out.writeObject(tmp);
        out.close();
        s.close();
    }

    public static Object pullObject(String ip, int port) throws Exception {
        Socket s = new Socket(ip, port);
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        Object tmp = in.readObject();

        in.close();
        s.close();

        return tmp;
    }
}