package org.lab2;

import generated.Plane;
import java.util.Comparator;

public class PlaneComparator implements Comparator<Plane.Planes> {
    @Override
    public int compare(Plane.Planes p1, Plane.Planes p2) {
        return p1.getModel().compareTo(p2.getModel());
    }
}
