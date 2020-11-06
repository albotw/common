using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace csharp_common
{
    public class Timer
    {
        private Thread counterThread;
        private bool stop{ get; set; }

        private bool chrono { get; set; }

        private int tick { get; set; }

        private int tMax { get; set; }

        private int currT;

        private ITimer toNotify { get; set; }

        private Timer(bool chrono, int tick, int tMax, ITimer it)
        {
            this.chrono = chrono;
            this.tick = tick;
            this.tMax = tMax;
            this.toNotify = it;

            this.counterThread = new Thread(new ThreadStart(this.run));
        }

        public static Timer createChrono(int tick)
        {
            return new Timer(true, tick, -1, null);
        }

        public static Timer createCounter(int maxT, int tick, ITimer it)
        {
            return new Timer(false, tick, maxT, it);
        }

        public void start()
        {
            counterThread.Start();
        }

        public void run()
        {
            while(!stop)
            {
                currT += tick;
                if (currT >= tMax && chrono)
                {
                    stop = false;
                    toNotify.timerEnded();
                }

                Thread.Sleep(tick);
            }
        }

        public void stopTimer()
        {
            stop = true;
        }

        public int getTime()
        {
            return this.currT;
        }
    }

    public interface ITimer
    {
        void timerEnded();
    }
}
