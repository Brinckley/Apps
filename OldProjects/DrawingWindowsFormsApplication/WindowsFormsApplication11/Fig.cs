using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
namespace WindowsFormsApplication11
{
    abstract class Fig
    {
        public abstract void Draw(Graphics g,Color col);
        public abstract int Height { get; set; }
        public abstract int Width { get; set; }       
    }
    class Earth:Fig
    {
        public override int Height { get; set; }
        public override int Width { get; set; }
        public override void Draw(Graphics g,Color col)
        {
            int min;
            if (this.Height > this.Width)
                min = this.Width;
            else
                min = this.Height;
            g.FillEllipse(new SolidBrush(Color.Blue), new Rectangle(new Point(this.Width / 2 - min / 4, (this.Height - min / 2) / 2), new Size(min / 2, min / 2)));
            g.FillEllipse(new SolidBrush(Color.Green), new Rectangle(new Point(this.Width / 2-min/16, this.Height/2-min/8), new Size(min / 5, min / 5)));
            
        }
    }
    class Month : Fig
    {
        public override int Height { get; set; }
        public override int Width { get; set; }
        public override void Draw(Graphics g,Color col)
        {
            int min;
            if (this.Height > this.Width)
                min = this.Width;
            else
                min = this.Height;
            g.FillPie(new SolidBrush(Color.Yellow), new Rectangle(new Point(this.Width / 2 - min / 4, (this.Height - min / 2) / 2), new Size(min / 2, min / 2)), -90, 180);
            g.FillPie(new SolidBrush(col), new Rectangle(new Point(this.Width / 2 -5*min/16, (this.Height - min / 2) / 2), new Size(min / 2, min / 2)), -90, 180);

        }
    }
}
