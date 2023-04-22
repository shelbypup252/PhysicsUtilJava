import java.lang.Math;


/**
 * A collection of useful methods for physics calculations.
 */
public class PhysicsUtil {


  /**
   * Calculates the x and y components of a vector given its magnitude and direction.
   *
   * @param magnitude the magnitude of the vector
   * @param direction the direction of the vector in degrees (measured from the positive x-axis)
   * @return an array containing the x and y components of the vector in that order
   */
  public static double[] calculateVectorComponents(double magnitude, double direction) {
    double radians = Math.toRadians(direction);
    double x = magnitude * Math.cos(radians);
    double y = magnitude * Math.sin(radians);
    return new double[] {x, y};
  }


  /**
   * Calculates the magnitude and direction of a vector given its x and y components.
   *
   * @param x the x-component of the vector
   * @param y the y-component of the vector
   * @return an array containing the magnitude and direction of the vector in that order
   */
  public static double[] calculateVectorMagnitudeAndDirection(double x, double y) {
    double magnitude = Math.sqrt(x*x + y*y);
    double radians = Math.atan2(y, x);
    double direction = Math.toDegrees(radians);
    if (direction < 0) {
      direction += 360;
    }
    return new double[] {magnitude, direction};
  }


  /**
   * Converts the x, y, and z components of a vector into spherical coordinates (radius, polar angle, and azimuthal angle).
   *
   * @param x the x-component of the vector
   * @param y the y-component of the vector
   * @param z the z-component of the vector
   * @return an array containing the radius, polar angle, and azimuthal angle of the vector in that order
   */
  public static double[] convertCartesianToSpherical(double x, double y, double z) {
    double radius = Math.sqrt(x*x + y*y + z*z);
    double polarAngle = Math.acos(z / radius);
    double azimuthalAngle = Math.atan2(y, x);
    if (azimuthalAngle < 0) {
      azimuthalAngle += 2 * Math.PI;
    }
    return new double[] {radius, polarAngle, azimuthalAngle};
  }


  /**
   * Converts the radius, polar angle, and azimuthal angle of a vector into x, y, and z components.
   *
   * @param radius the radius of the vector
   * @param polarAngle the polar angle of the vector
   * @param azimuthalAngle the azimuthal angle of the vector
   * @return an array containing the x, y, and z components of the vector in that order
   */
  public static double[] convertSphericalToCartesian(double radius, double polarAngle, double azimuthalAngle) {
    double x = radius * Math.sin(polarAngle) * Math.cos(azimuthalAngle);
    double y = radius * Math.sin(polarAngle) * Math.sin(azimuthalAngle);
    double z = radius * Math.cos(polarAngle);
    return new double[] {x, y, z};
  }


  /**
   * Calculates the amplitude, period, and equation of the harmonic motion of a spring given its spring constant and displacement from equilibrium.
   *
   * @param springConstant the spring constant of the spring in N/m
   * @param x0 the displacement of the spring from equilibrium in meters at t=0
   * @return an array containing the amplitude, period, and equation of the spring's harmonic motion in that order
   */
  public static Object[] calculateSpringHarmonicMotion(double springConstant, double x0) {
    double omega = Math.sqrt(springConstant);
    double amplitude = Math.abs(x0);
    double period = 2 * Math.PI / omega;
    String equation = "f(x) = " + amplitude + " * cos(" + omega + " * t";
    if (x0 < 0) {
      equation += " - " + Math.PI + ")";
    } else {
      equation += ")";
    }
    return new Object[] {amplitude, period, equation};
  }











}
