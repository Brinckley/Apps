using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Практика__3
{
    public delegate void ValueChangedEventHandler(object Sender, ValueEventArgs e);

    public partial class Form2 : Form
    {
        public Form2(int v = 1, int min = 0, int max = 100, string Title = "title")
        {
            InitializeComponent();
            trackBar1.Value = v;
            trackBar1.Minimum = min;
            trackBar1.Maximum = max;
            Text = Title;
        }

        public event ValueChangedEventHandler ValueChanged;

        private void trackBar1_Scroll(object Sender, EventArgs e)
        {
            this.ValueChanged(this, new ValueEventArgs(trackBar1.Value));
        }

        private void trackBar1_Move(object Sender, EventArgs e)
        {
            this.ValueChanged(this, new ValueEventArgs(trackBar1.Value));
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }
    }
}
