package pointOfSale;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Printer implements Printable {

	String message=null;
	JFrame j;

	public Printer(String message, JFrame j) {
		this.message = message;
		this.j = j;
	}
	public Printer(String message) {
		this.message = message;
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        JFrame x = this.j;
        x.getGraphics();
        x.paint(g2d);
        x.repaint();
     //   g.drawString("Hello world!", 100, 100);
// g.drawImage(new ImageIcon("Icons\\IconBig.jpg").getImage(),100,100, null);
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;

	}

}