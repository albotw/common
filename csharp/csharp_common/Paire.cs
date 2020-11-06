using System;
using System.Collections.Generic;
using System.Text;

namespace csharp_common
{
    class Paire<K, V> : IEquatable<Paire<K, V>>
    {
        private K key
        { get; set; }

        private V value
        { get; set; }

        public Paire()
        {
            key = default(K);
            value = default(V);
        }

        public Paire(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public override string ToString()
        {
            string s = "[";
            s += "key: " + this.key.ToString();
            s += " | value: " + this.value.ToString();
            s += "]\n";
            return s;
        }

        public override bool Equals(object obj)
        {
            return Equals(obj as Paire<K, V>);
        }

        public bool Equals(Paire<K, V> other)
        {
            return other != null &&
                   EqualityComparer<K>.Default.Equals(key, other.key) &&
                   EqualityComparer<V>.Default.Equals(value, other.value);
        }

        public override int GetHashCode()
        {
            int hashCode = 1363396886;
            hashCode = hashCode * -1521134295 + EqualityComparer<K>.Default.GetHashCode(key);
            hashCode = hashCode * -1521134295 + EqualityComparer<V>.Default.GetHashCode(value);
            return hashCode;
        }

        public static bool operator ==(Paire<K, V> left, Paire<K, V> right)
        {
            return EqualityComparer<Paire<K, V>>.Default.Equals(left, right);
        }

        public static bool operator !=(Paire<K, V> left, Paire<K, V> right)
        {
            return !(left == right);
        }
    }
}
