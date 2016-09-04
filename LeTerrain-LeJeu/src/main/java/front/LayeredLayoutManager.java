package front;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class LayeredLayoutManager implements LayoutManager {

    public void addLayoutComponent(String name, Component comp) {
        // TODO Auto-generated method stub
    }

    public void removeLayoutComponent(Component comp) {
        // TODO Auto-generated method stub
    }

    public Dimension preferredLayoutSize(Container parent) {
        Component[] components = parent.getComponents();
        if (components.length == 0) {
            return new Dimension(0, 0);
        }
        Dimension d = components[0].getPreferredSize();
        for (int i = 1; i < components.length; i++) {
            Dimension tmp = components[i].getPreferredSize();
            if (d.width < tmp.width)
                d.width = tmp.width;
            if (d.height < tmp.height)
                d.height = tmp.height;
        }
        return d;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Component[] components = parent.getComponents();
        if (components.length == 0) {
            return new Dimension(0, 0);
        }
        Dimension d = components[0].getMinimumSize();
        for (int i = 1; i < components.length; i++) {
            Dimension tmp = components[i].getMinimumSize();
            if (d.width < tmp.width)
                d.width = tmp.width;
            if (d.height < tmp.height)
                d.height = tmp.height;
        }
        return d;
    }

    public void layoutContainer(Container parent) {
        Dimension d = parent.getSize();
        for (Component c : parent.getComponents()) {
            c.setSize(d);
        }
    }

}
