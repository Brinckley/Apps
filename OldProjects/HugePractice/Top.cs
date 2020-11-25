using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Практика__3
{
    abstract class Top
    {
        public int X { get; set; } //Центр фигуры
        public int Y { get; set; } //Центр фигуры
        public int dx { get; set; } 
        public int dy { get; set; } 
        public bool drag { get; set; } //перетаскивание
        public bool ex { get; set; }
        public int order { get; set; }
        static public int R { get; set; } 
        public Color Color { get; set; } //цвет фигуры

        public Top(int x, int y) //конструтор класса
        {
            this.X = x;
            this.Y = y;
            R = 40;
            Color = Color.Red;
        }

        abstract public void Draw(Graphics g); //метод для рисования фигуры

        abstract public bool Check(int x, int y); //метод для определения положения х и у относительно фигуры (внутри или нет)  

    }

    class Circle : Top
    {
        public Circle(int x, int y) : base(x, y)
        { }

        override public void Draw(Graphics g)
        {
            SolidBrush a;
            a = new SolidBrush(Color);
            g.FillEllipse(a, X - R, Y - R, 2 * R, 2 * R);
        }

        public override bool Check(int X, int Y)//Проверка попадания
        {
            return (Math.Pow(X - this.X, 2) + Math.Pow(Y - this.Y, 2)) < (Math.Pow(R, 2));
        }

        
    }

    class Square : Top
    {
        public Square(int X, int Y) : base(X, Y)
        { }

        override public void Draw(Graphics g)
        {
            SolidBrush a = new SolidBrush(Color);
            g.FillRectangle(a, X - R, Y - R, 2 * R, 2 * R);
        }

        public override bool Check(int x, int y)//Проверка попадания
        {
            return ((x >= X - R) && (x <= X + R) && (y >= Y - R) && (y <= Y + R));
        }
    }

    class Triangle : Top
    {
        double s,s1,s2,s3;
        double l1, l2, l3;
        public Triangle(int x, int y) : base(x, y)
        { }

        override public void Draw(Graphics g)
        {
            SolidBrush a = new SolidBrush(Color);
            g.FillPolygon(a, new Point[] { new Point(X - R, Y + R), new Point(X, Y - R), new Point(X + R, Y + R) });
        }

        public override bool Check(int X1, int Y1)//Проверка попадания
        {
            s = TriangleArea(X - R, Y + R, X, Y - R, X + R, Y + R);
            s1 = TriangleArea(X - R, Y + R, X, Y - R, X1, Y1);
            s2 = TriangleArea(X - R, Y + R, X1, Y1, X + R, Y + R);
            s3 = TriangleArea(X1, Y1, X, Y - R, X + R, Y + R);
            return (Math.Abs(s - (s1 + s2 + s3)) < 0.01);
        }

        static public double TriangleArea(int x1, int y1, int x2, int y2, int x3, int y3)
        {
            double l1 = Math.Sqrt(Math.Pow(x2 - x1, 2) + Math.Pow(y2 - y1, 2));
            double l2 = Math.Sqrt(Math.Pow(x3 - x2, 2) + Math.Pow(y3 - y2, 2));
            double l3 = Math.Sqrt(Math.Pow(x1 - x3, 2) + Math.Pow(y1 - y3, 2));
            double p = (l1 + l2 + l3) / 2;
            return Math.Sqrt(p * (p - l1) * (p - l2) * (p - l3));
        }
    }
}

