using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace csharp_common
{
    class FileIO
    {

        public static string[] readFile(string dir)
        {
            return File.ReadAllLines(@dir);
        }

        public static void writeFile(string dir, string[] lines, Boolean append)
        {
            using (StreamWriter file = new StreamWriter(@dir, append))
            {
                foreach(string line in lines) { file.WriteLine(line); }
            }
        }

        /**
         * A propos de la sérialisation.
         * L'objet passé en paramètre doit avoir l'attribut [Serializable()] juste avant le public class.
         * Cet attribut n'est pas héritable.
         * Pour ne pas sérialiser un champ spécifique, ajoutez l'attribut [NonSerialized()] devant l'attribut.
         */
        public static void serializeObject(string dir, Object obj)
        {
            IFormatter formatter = new BinaryFormatter();
            Stream stream = new FileStream(dir, FileMode.Create, FileAccess.Write, FileShare.None);
            formatter.Serialize(stream, obj);
            stream.Close();
        }

        public static Object unserializeObject(string dir)
        {
            IFormatter formatter = new BinaryFormatter();
            Stream stream = new FileStream(dir, FileMode.Open, FileAccess.Read, FileShare.Read);
            Object obj = formatter.Deserialize(stream);
            stream.Close();

            return obj;
        }
    }
}
