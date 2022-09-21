import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private final double[] radii = {0.005, 0.1, 0.5, 1.0, -3.5, 5.7, 8.2, 6.6};
    private final double[] set_radii = {11.3, 4.2, -2.9, 5.5, 7.0, 6.0, 8.6, 9.3};
    private ArrayList<Circle> circles;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        circles = new ArrayList<>();
        for(int ndx = 0; ndx < radii.length; ndx++) {
            Circle cir = new Circle(radii[ndx]);
            circles.add(cir);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() { circles = null; }

    @org.junit.jupiter.api.Test
    void testToString() {
        for(Circle c : circles) {
            System.out.println(c);
        }
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assert(circles.size() == radii.length);
        for(Circle c : circles) {
            Circle shallowCopy = c;
            assertEquals(c, shallowCopy);
            Circle nullPointer = null;
            assertFalse(c.equals(nullPointer));
            assertFalse(c.equals("not a circle"));
        }
        for (int i = 0; i < radii.length; i++) {
            Circle c = circles.get(i);
            Circle other_c = new Circle(radii[i]);
            assertNotSame(other_c, c);
            assertEquals(other_c, c);
            Circle not_c = new Circle(radii[i] + 5.0);
            assertNotEquals(not_c, c);
        }
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assert(circles.size() == radii.length);
        for (int i = 0; i < radii.length; i++) {
            Circle c = circles.get(i);
            Circle other_c = new Circle(radii[i]);
            assertNotSame(other_c, c);
            assertEquals(other_c.hashCode(), c.hashCode());
        }
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
        assertEquals(radii.length, circles.size());
        for (int ndx = 0; ndx < circles.size(); ndx++) {
            double radius = circles.get(ndx).getRadius();
            double exp_radius = radii[ndx] > 0 ? radii[ndx] : 0;
            assertEquals(exp_radius, radius);
        }
    }

    @org.junit.jupiter.api.Test
    void setRadius() {
        assertEquals(set_radii.length, radii.length);
        for (int i = 0; i < circles.size(); i++) {
            Circle c = circles.get(i);
            double exp_r = set_radii[i] > 0 ? set_radii[i] : 0;
            c.setRadius(set_radii[i]);
            assertEquals(exp_r, c.getRadius());
        }
    }

    @org.junit.jupiter.api.Test
    void getCircumference() {
        assertEquals(radii.length, circles.size());
        for(int ndx = 0; ndx < circles.size(); ndx++) {
            double circumference = circles.get(ndx).getCircumference();
            double exp_circum = radii[ndx] > 0 ? (2 * Math.PI*(radii[ndx])) : 0;
            assertEquals(exp_circum, circumference);
        }
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        assertEquals(radii.length, circles.size());
        for(int ndx = 0; ndx < circles.size(); ndx++) {
            double area = circles.get(ndx).getArea();
            double exp_area = radii[ndx] > 0 ? (Math.PI * Math.pow(radii[ndx], 2)) : 0;
            assertEquals(exp_area, area);
        }
    }
}