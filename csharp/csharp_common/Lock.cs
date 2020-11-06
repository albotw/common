using System.Threading;

namespace csharp_common
{
    class Lock
    {
        private bool locked;

        public Lock()
        {
            locked = false;
        }

        public void getLock()
        {
            if (!locked)
            {
                locked = true;
            }
            else
            {
                Monitor.Wait(this);
            }
        }

        public void releaseLock()
        {
            locked = false;
            // Lock est l'équivalent de synchronized
            // pulse est l'équivalent de notify.
            lock (this) { Monitor.Pulse(this); }
        }
    }
}
