using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication11
{
    public partial class Form1 : Form
    {
        bool flag1, flag2;
        Fig a;
        Fig b;
        public Form1()
        {
            InitializeComponent();
            a = new Earth();
            b = new Month();
        }
        private void splitContainer1_Panel1_Paint(object sender, PaintEventArgs e)
        {
            this.a.Width = e.ClipRectangle.Width;
            this.a.Height = e.ClipRectangle.Height;
            if(flag1)
            {
                a.Draw(e.Graphics, this.splitContainer1.Panel1.BackColor);
            }
        }
        private void splitContainer1_Panel2_Paint(object sender, PaintEventArgs e)
        {
            this.b.Width = e.ClipRectangle.Width;
            this.b.Height = e.ClipRectangle.Height;
            if (flag2)
            {
                b.Draw(e.Graphics, this.splitContainer1.Panel2.BackColor);
            }
        }
        private void Form1_SizeChanged(object sender, EventArgs e)
        {           
            this.splitContainer1.Panel1.Invalidate();
            this.splitContainer1.Panel2.Invalidate();
        }
        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            flag1 = !flag1;
            this.splitContainer1.Panel1.Invalidate();
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            flag2 = !flag2;
            this.splitContainer1.Panel2.Invalidate();
        }
    }
}
