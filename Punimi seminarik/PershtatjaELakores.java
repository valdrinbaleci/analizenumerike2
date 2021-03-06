{\rtf1\ansi\ansicpg1252\deff0\deflang1033{\fonttbl{\f0\fswiss\fcharset0 Arial;}}
{\*\generator Msftedit 5.41.15.1515;}\viewkind4\uc1\pard\f0\fs20 import java.awt.* ;\par
import javax.swing.* ;\par
import java.util.Arrays;\par
import java.util.Date ;\par
\par
public class Pershtatja e lakores \{\par
\par
\tab public static int SLEEP = 1 ;\par
\par
\tab public static void main(String[] args) \{\par
\par
\tab\tab double[] values = \{ +1, -4, +1, -2, +1, -1, +4, +3, -3, +1 \} ;\tab\tab // vlerat y\par
\tab\tab\par
\tab\tab double[] v = Arrays.copyOf(values,values.length);\par
\tab\tab Arrays.sort(v);\par
\tab\tab\par
\tab\tab double deltaX = 0.01 ;\tab\tab // saktesia\tab\par
\par
\tab\tab JFrame frame = new JFrame("Fit Curves to Points") ;\par
\tab\tab Graph graph = new Graph(-1.0,v.length,v[0]-1,v[v.length-1]+1,1000,500) ;\tab // parameterat jane x_min, x_max, y_min, y_max\tab\tab\tab\tab             frame.getContentPane().add(graph) ;\par
\tab\tab frame.pack() ;\par
\tab\tab frame.setVisible(true) ;\par
\tab\tab sleep(500) ;\par
\par
\tab\tab // Nderto pikat\par
\tab\tab graph.PEN_WIDTH = 10 ;\tab\tab\tab\tab\par
\tab\tab graph.PEN_COLOR = Color.black ;\tab\tab\par
\tab\tab for (int x=0 ; x<values.length ; x++) \{ graph.point(x,values[x]) ; \}\tab\tab // vizaton gjdo pike te thirrur\par
\par
\tab\tab // Nderto polinomin interpolues te Lagranzhit\par
\tab\tab graph.PEN_WIDTH = 3 ;\par
\tab\tab graph.PEN_COLOR = Color.red ;\par
\tab\tab Polynomial lagrange = Lagrange.interpolate(values) ;\par
\tab\tab for (double x=0 ; x<values.length-1 ; x+=deltaX) \{\par
\tab\tab\tab graph.point(x,lagrange.evaluate(x)) ;\par
\tab\tab\tab sleep(SLEEP) ;\par
\tab\tab\}\par
\par
\tab\tab // Nderto cubic spline \par
\tab\tab graph.PEN_WIDTH = 3 ;\par
\tab\tab graph.PEN_COLOR = Color.blue ;\par
\tab\tab Spline spline = new Spline(values) ;\par
\tab\tab for (double x=0 ; x<values.length-1 ; x+=deltaX) \{\par
\tab\tab\tab graph.point(x,spline.evaluate(x)) ;\par
\tab\tab\tab sleep(SLEEP) ;\par
\tab\tab\}\par
\par
\tab\}\par
\par
\tab public static void sleep(long milliseconds) \{\par
\tab\tab Thread thread = new Thread() ;\par
\tab\tab try \{ thread.sleep(milliseconds) ; \}\par
\tab\tab catch (Exception e) \{\}\par
\tab\}\par
\par
\}\par
}
 