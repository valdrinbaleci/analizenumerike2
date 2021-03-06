{\rtf1\ansi\ansicpg1252\deff0\deflang1033{\fonttbl{\f0\fswiss\fcharset0 Arial;}}
{\*\generator Msftedit 5.41.15.1515;}\viewkind4\uc1\pard\f0\fs20 public class Spline \{\par
\par
\tab private double[] values;\par
\par
\tab public Spline(double[] v)\{\par
\tab\tab values = v;\par
\tab\}\par
\par
\tab public double evaluate(double x)\{\par
\par
\tab\tab int x0 = (int)x;\par
\tab\tab int x1 = x0+1;\par
\tab\tab double y0 = values[x0];\par
\tab\tab double y1 = values[x1];\par
\tab\tab double s0;\par
\tab\tab double s1;\par
\par
\tab\tab if(x0==0)\{\par
\tab\tab\tab s0 = midSlope(-y1,y0,y1);\par
\tab\tab\tab if(x1==values.length-1) s1 = midSlope(y0,y1,-y0);\par
\tab\tab\tab else s1 = midSlope(y0,y1,values[x1+1]);\par
\tab\tab\}\par
\par
\tab\tab else\{\par
\tab\tab\tab s0 = midSlope(values[x0-1],y0,y1);\par
\tab\tab\tab if(x1==values.length-1) s1 = midSlope(y0,y1,-y0);\par
\tab\tab\tab else s1 = midSlope(y0,y1,values[x1+1]);\par
\tab\tab\}\par
\tab\tab\par
\tab\tab return cubic(y0, y1, s0, s1, x-x0);\par
\tab\tab  \par
\tab\}\par
\par
\tab private double cubic(double y0, double y1, double s0, double s1, double x)\{\par
\par
\tab\tab double a = y0;\par
\tab\tab double b = s0;\par
\tab\tab double c = ( (3*(y1-y0)) - 2*s0 ) - s1;\par
\tab\tab double d = (2*(y0-y1)) + s0 + s1;\par
\tab\tab\par
\tab\tab double[] terms = \{ a, b, c, d \};\par
\tab\tab\par
\tab\tab Polynomial spline = new Polynomial(terms);\par
\tab\tab\par
\tab\tab double result =  spline.evaluate(x);\par
\tab\tab\par
\tab\tab return result;\par
\tab\}\par
\par
\tab private double midSlope(double y1, double y2, double y3)\{\par
\par
\tab\tab double A = (y3 + y1 - 2*y2) / 2;\par
\tab\tab double B = y2 - y1 - A;\par
\tab\tab double slope = 2*A + B;\par
\tab\par
\tab\tab return slope;\par
\tab\}\par
\}\par
}
 