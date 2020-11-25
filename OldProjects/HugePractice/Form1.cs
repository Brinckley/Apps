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
    public partial class Form1 : Form
    {
        List<Top> l = new List<Top>();
        bool up = false;
        bool down = false;
        int what = 0;
        
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            DoubleBuffered = true;
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            if (l.Count() == 0) return;
            l[0].Draw(e.Graphics);
            for (int i=1; i<l.Count(); i++)
                {
                    e.Graphics.DrawLine(new Pen(Color.Black), new Point(l[i - 1].X, l[i - 1].Y), new Point(l[i].X, l[i].Y));
                    l[i].Draw(e.Graphics);                        
                }
            e.Graphics.DrawLine(new Pen(Color.Black), new Point(l.Last().X, l.Last().Y), new Point(l[0].X, l[0].Y));            
        }

        private void Form1_MouseDown(object sender, MouseEventArgs e)
        {

            if (e.Button == MouseButtons.Left)
            {
                bool b = false;
                foreach (Top figure in l)
                {
                    if (figure.Check(e.X, e.Y))//Проверка попадания
                    {
                        figure.dx = e.X - figure.X;
                        figure.dy = e.Y - figure.Y;
                        figure.drag = true;
                        b = true;
                    }
                }
                if (!b)
                {
                    if (Insidefig(e.X, e.Y))
                    {
                        foreach (Top figure in l)
                        {
                            figure.dx = e.X - figure.X;
                            figure.dy = e.Y - figure.Y;
                            figure.drag = true;
                        }
                    }
                    else
                    {
                        Top a = new Triangle(e.X, e.Y);
                        if (circleToolStripMenuItem.Checked)
                        {
                            a = new Circle(e.X, e.Y);
                        }
                        if (squareToolStripMenuItem.Checked)
                        {
                            a = new Square(e.X, e.Y);
                        }
                        if (triangleToolStripMenuItem.Checked)
                        {
                            a = new Triangle(e.X, e.Y);
                        }
                        a.Color = colorDialog1.Color;
                        l.Add(a);
                    }
                }
            }

            if (e.Button == MouseButtons.Right)
            {
                foreach (Top s in l)
                {
                    if (s.Check(e.X, e.Y))
                    {
                        l.Remove(s);
                        break;
                    }
                }
            }
        }

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            foreach(Top s in l)
            {
                if (s.drag)
                {
                    s.X = e.X - s.dx;
                    s.Y = e.Y - s.dy;
                }
                this.Invalidate();
            }
        }

        private void Form1_MouseUp(object sender, MouseEventArgs e)
        {
            foreach(Top figure in l)
            {
                figure.drag = false;
            }
            Open();
            this.Invalidate();
        }

        private void circleToolStripMenuItem_Click(object sender, EventArgs e)
        {
            circleToolStripMenuItem.Checked = true;
            squareToolStripMenuItem.Checked = false;
            triangleToolStripMenuItem.Checked = false;
        }

        private void squareToolStripMenuItem_Click(object sender, EventArgs e)
        {
            circleToolStripMenuItem.Checked = false;
            squareToolStripMenuItem.Checked = true;
            triangleToolStripMenuItem.Checked = false;
        }

        private void triangleToolStripMenuItem_Click(object sender, EventArgs e)
        {
            circleToolStripMenuItem.Checked = false;
            squareToolStripMenuItem.Checked = false;
            triangleToolStripMenuItem.Checked = true;
        }

        private void Open()
        {
            if(l.Count <= 3) { 
                return;
            }

            List<Top> border = new List<Top>();


            //ищем точку с минимальной координатой У с помощью цикла for
            Top p1 = l[0];
            foreach (Top p in l)
            { 
                if (p.Y < p1.Y) p1 = p;
            }
            border.Add(p1);

            //найдём вторую точку

            double minCos = double.MinValue;
            Top p2 = null;
            foreach(Top p in l)
            {
                int dx = p.X - p1.X, dy = p.Y - p1.Y;
                if (dx / Math.Sqrt(dx * dx + dy * dy) > minCos)
                {
                    minCos = dx / Math.Sqrt(dx * dx + dy * dy);
                    p2 = p;
                }
            }
            border.Add(p2);

            //циклом находим такую точку, проходящяя через которую прямая образует минимальный угол с векторм (1, 0). 
            //цикл завершится, когда мы наткнёмся на точку с order = 0
            //угол считаем по особой формуле

            Top nextP = null;
            Top currentP = p2;
            Top prevP = p1;
            while (true)
            {
                int dXa = prevP.X - currentP.X;
                int dYa = prevP.Y - currentP.Y;
                minCos = 1;
                foreach (Top p in l)
                {
                    if ((p == currentP) || (p == prevP)) continue; // Не сравниваем точку саму с собой
                    int dXb = p.X - currentP.X, dYb = p.Y - currentP.Y;
                    double cos = (dXa * dXb + dYa * dYb) / (Math.Sqrt(dXa * dXa + dYa * dYa) * Math.Sqrt(dXb * dXb + dYb * dYb));
                    if (cos<minCos) { 
                        minCos = cos;
                        nextP = p;
                    }
                }
                if (nextP == p1)
                {
                    break;
                }

                border.Add(nextP);
                prevP = currentP;
                currentP = nextP;
            }
            l = border;
        }

        private bool Insidefig(int x, int y)
        {
            if (l.Count < 3)
                return false;
            List<Top> copy = new List<Top>(l);
            copy.Add(new Triangle(x, y));
            for (int i = 0; i < copy.Count; i++)
            {
                for (int j = i + 1; j < copy.Count; j++)
                {
                    for (int l = 0; l < copy.Count; l++)
                    {
                        if (l != j && l != i && i != j)
                        {
                            if ((copy[l].X - copy[i].X) * (copy[j].Y - copy[i].Y) - (copy[j].X - copy[i].X) * (copy[l].Y - copy[i].Y) > 0)
                            {
                                up = true;
                            }
                            else
                            {
                                down = true;
                            }
                        }
                    }
                    if ((up == true && down == false) | (down == true && up == false))
                    {
                        copy[i].ex = true;
                        copy[j].ex = true;
                    }
                    up = false;
                    down = false;
                }
            }
            if (copy[copy.Count - 1].ex)
            {return false;}
            else
            {return true;}
        }

        private void цветToolStripMenuItem_Click(object sender, EventArgs e)
        {
                colorDialog1.ShowDialog(); //меняем цвет по выбору
                foreach (Top s in l)
                {
                   s.Color = colorDialog1.Color;
                }
                this.Invalidate();
        }

        private void размерToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2(Практика__3.Top.R, 1, 50, "Радиус");// Минимальный размер,максимум,имя
            f2.ValueChanged += RadiusDeligate;
            if ((f2 == null) || (f2.IsDisposed))
            {
                f2 = new Form2(Практика__3.Top.R, 1, 50, "Радиус");
                f2.ValueChanged += RadiusDeligate;
                f2.Show();
            }
            if (!f2.Visible)
                f2.Show();
            else
                f2.Activate();
        }

        private void RadiusDeligate(object Sender, ValueEventArgs e)
        {
            Практика__3.Top.R = e.R;
            this.Invalidate();
        }

        private void стартToolStripMenuItem_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
        }

        private void стопToolStripMenuItem_Click(object sender, EventArgs e)
        {
            timer1.Enabled = false;
        }

        private void интервалToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f3 = new Form2(timer1.Interval, 10, 1000, "Измените период");
            f3.ValueChanged += IntervalDelegate;
            if ((f3 == null) || (f3.IsDisposed))
            {
                f3 = new Form2(timer1.Interval, 10, 1000, "Измените период");
                f3.ValueChanged += IntervalDelegate;
                f3.Show();
            }
            if (!f3.Visible)
                f3.Show();
            else
                f3.Activate();
        }

        private void IntervalDelegate(object Sender, ValueEventArgs e)
        {
            timer1.Interval = e.R;
            Refresh();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            Random r = new Random();
            foreach (Top s in l)
            {
                s.X += r.Next(-1, 2);
                s.Y += r.Next(-1, 2);
            }
            Open();
            Refresh();
        }

    }
}
