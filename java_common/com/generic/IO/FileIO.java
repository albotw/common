package com.generic.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * L'objet a écrire / lire doit implémenter l'interface Serizlizable. La gestion
 * des exceptions doit se faire la ou la méthode est appellée afin d'implémenter
 * des fallbacks.
 */

public class FileIO {

    public static void writeObjectToFile(Object o, String dir) throws Exception {
        FileOutputStream fos = new FileOutputStream(dir);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Serializable tmp = (Serializable) o;
        oos.writeObject(tmp);

        System.out.println("--- wrote file ---");

        oos.close();
        fos.close();
    }

    public static Object loadObjectFromFile(String dir) throws Exception {
        FileInputStream fis = new FileInputStream(dir);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object tmp = ois.readObject();

        ois.close();
        fis.close();
        return tmp;
    }

}