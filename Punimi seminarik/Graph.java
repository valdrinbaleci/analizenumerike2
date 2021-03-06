{\rtf1\ansi\ansicpg1252\deff0\deflang1033{\fonttbl{\f0\fswiss\fcharset0 Arial;}}
{\*\generator Msftedit 5.41.15.1515;}\viewkind4\uc1\pard\f0\fs20 import java.awt.* ;\par
import java.util.ArrayList;\par
\par
import javax.swing.* ;\par
\par
public class Graph extends JPanel \{\par
\par
\tab public int PEN_WIDTH = 10;\par
\tab public Color PEN_COLOR = Color.black ;\par
\tab\par
\tab private ArrayList<Point> points = new ArrayList<Point>();\par
\par
\tab private double xmin, xmax, ymin, ymax, xrange, yrange , xscale, yscale;\par
\tab private int width, height;\par
\tab private int oval_x, oval_y;\par
\tab\par
\tab public Graph(double x_min, double x_max, double y_min, double y_max, int w, int h) \{\par
\tab\tab\par
\tab\tab xmin = x_min;\par
\tab\tab xmax = x_max;\par
\tab\tab ymin = y_min;\par
\tab\tab ymax = y_max;\par
\tab\tab width = w ;\par
\tab\tab height = h ;\par
\tab\tab\par
\tab\tab xrange = x_max-x_min;\par
\tab\tab yrange = y_max-y_min;\par
\tab\tab\par
\tab\tab xscale = width/xrange;\par
\tab\tab yscale = height/yrange;\par
\tab\par
\tab\tab setPreferredSize(new Dimension(w,h)) ;\par
\tab\}\par
\par
\tab public void point(double x, double y) \{\par
\tab\tab // shto pike te re te vargu i pikave\par
\tab\tab Point point = new Point(xtrans(x),ytrans(y), PEN_COLOR, PEN_WIDTH);\par
\tab\tab points.add(point);\par
\tab\tab repaint();\par
\tab\}\par
\par
\tab public void paintComponent(Graphics g) \{\par
\tab\tab\par
\tab\tab // vizato prapavijen\par
\tab\tab super.paintComponent(g) ;\par
\tab\tab g.setColor(Color.white) ;\par
\tab\tab g.fillRect(0,0,width,height) ;\par
\par
\tab\tab // vizato boshtet\par
\tab\tab g.setColor(Color.black) ;\par
\tab\tab g.drawLine( xtrans(xmin), ytrans(0), xtrans(xmax), ytrans(0)) ;\par
\tab\tab g.drawLine( xtrans(0), ytrans(ymin), xtrans(0), ytrans(ymax)) ;\par
\par
\tab\tab // vizato te gjitha pikat \par
\tab\tab for(int i = 0; i<points.size(); i++)\{\par
\tab\tab\tab g.setColor(points.get(i).getColor()) ;\par
\tab\tab\tab int x = points.get(i).getx();\par
\tab\tab\tab int y = points.get(i).gety();\par
\tab\tab\tab int pointSize = points.get(i).getSize();\par
\tab\tab\tab g.fillOval(x, y, pointSize, pointSize);\par
\tab\tab\}\par
\par
\tab\}\par
\tab\par
\tab private int xtrans(double x)\{\par
\tab\tab return (int)(xscale(Math.abs(xmin)) + xscale(x));\par
\tab\}\par
\tab\par
\tab private int ytrans(double y)\{\par
\tab\tab return (int)(yscale(ymax) - yscale(y));\par
\tab\}\par
\par
\tab private double yscale(double y)\{\par
\tab\tab return y*yscale;\par
\tab\}\par
\tab\par
\tab private double xscale(double x)\{\par
\tab\tab return x*xscale;\par
\tab\}\par
\par
\tab private class Point\{\par
\tab\tab private int x;\par
\tab\tab private int y;\par
\tab\tab private Color pointColor;\par
\tab\tab private int pointSize;\par
\tab\tab\par
\tab\tab private Point(int x_in, int y_in, Color c, int s)\{\par
\tab\tab\tab x = x_in;\par
\tab\tab\tab y = y_in;\par
\tab\tab\tab pointColor = c;\par
\tab\tab\tab pointSize = s;\par
\tab\tab\}\par
\tab\tab\par
\tab\tab private int getx()\{\par
\tab\tab\tab return x;\par
\tab\tab\}\par
\tab\tab\par
\tab\tab private int gety()\{\par
\tab\tab\tab return y;\par
\tab\tab\}\par
\tab\tab\par
\tab\tab private Color getColor()\{\par
\tab\tab\tab return pointColor;\par
\tab\tab\}\par
\tab\tab\par
\tab\tab private int getSize()\{\par
\tab\tab\tab return pointSize;\par
\tab\tab\}\par
\tab\}\par
\}\par
}
 