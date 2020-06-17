using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace csharp_common
{
    class CountDownLatch
    {
        private int count { get; set; }

        public CountDownLatch(int nThreads)
        {
            this.count = nThreads;
        }

        public void countDown()
        {
            count--;
            if (count == 0)
            {
                lock (this) { Monitor.PulseAll(this); }
            }
            else
            {
                lock(this) { Monitor.Wait(this); }
            }
        }
    }
}
