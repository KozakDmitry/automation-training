import org.junit.jupiter.api.Test;

import java.awt.geom.Path2D;

import static org.junit.jupiter.api.Assertions.*;

class ExistTriangleTest {


    @Test
    public void allZero(){
        assertThrows(IllegalArgumentException.class, () -> ExistTriangle.IsPossible(0, 0, 0));
    }

    @Test
    public void allNegative(){
        assertThrows(IllegalArgumentException.class, () -> ExistTriangle.IsPossible(-10.0, -4, -2));
    }

    @Test
    public void oneZero(){
        assertThrows(IllegalArgumentException.class, () -> ExistTriangle.IsPossible(4.0, 6.2, 0));
    }

    @Test
    public void oneNegative(){
        assertThrows(IllegalArgumentException.class, () -> ExistTriangle.IsPossible(-4.0, 6.5, 3.0));
    }


    @Test
    public void oneSideMuchLarger(){
        assertFalse(ExistTriangle.IsPossible(15.0, 10.0, 200.0));
    }

    @Test
    public void oneSideLightlyLarger(){
        assertFalse(ExistTriangle.IsPossible(5.3, 4.7, 10.1));
    }

    @Test
    public void oneSideEqualToSum(){
        assertFalse(ExistTriangle.IsPossible(5.5, 5.5, 11.0));
    }

    @Test
    public void equilateralTriangle(){
        assertTrue(ExistTriangle.IsPossible(7.0, 7.0, 7.0));
    }

    @Test
    public void isoscelesTriangle(){
        assertTrue(ExistTriangle.IsPossible(3.2, 5.0, 3.2));
    }

    @Test
    public void RightTriangle(){
        assertTrue(ExistTriangle.IsPossible(5.0, 4.0, 3.0));
    }

    @Test
    public void arbitraryTriangle(){
        assertTrue(ExistTriangle.IsPossible(5.0, 9.0, 5.6));
    }
}