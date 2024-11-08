package org.lab2;

import generated.Plane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {

    private List<Plane.Planes> planes;

    @BeforeEach
    public void setUp() {
        Plane.Planes plane1 = new Plane.Planes();
        plane1.setModel("F-22 Raptor");

        Plane.Planes plane2 = new Plane.Planes();
        plane2.setModel("F-16 Falcon");

        Plane.Planes plane3 = new Plane.Planes();
        plane3.setModel("F-35 Lightning II");

        planes = Arrays.asList(plane1, plane2, plane3);
    }

    @Test
    public void testComparePlanesByModel() {
        // Create a comparator instance
        PlaneComparator comparator = new PlaneComparator();

        // Sort the planes list using the comparator
        Collections.sort(planes, comparator);

        // Assert that the list is sorted in the correct order (lexicographical order of model names)
        assertEquals("F-16 Falcon", planes.get(0).getModel());
        assertEquals("F-22 Raptor", planes.get(1).getModel());
        assertEquals("F-35 Lightning II", planes.get(2).getModel());
    }

    @Test
    public void testComparePlanesWithEqualModels() {
        Plane.Planes plane1 = new Plane.Planes();
        plane1.setModel("F-22 Raptor");

        Plane.Planes plane2 = new Plane.Planes();
        plane2.setModel("F-22 Raptor");

        List<Plane.Planes> planes = Arrays.asList(plane1, plane2);

        // Create a comparator instance
        PlaneComparator comparator = new PlaneComparator();

        // Sort the planes list using the comparator
        Collections.sort(planes, comparator);

        // Assert that the list order is not changed for equal models
        assertEquals("F-22 Raptor", planes.get(0).getModel());
        assertEquals("F-22 Raptor", planes.get(1).getModel());
    }
}
