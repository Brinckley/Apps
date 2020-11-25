using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Практика__3
{
    public class ValueEventArgs : EventArgs
    {
        public int R { get; set; }
        public ValueEventArgs(int R)
        {
            this.R = R;
        }
    }
}
