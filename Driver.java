public class Driver {
    public static Sun sun;
    public static Planet mercury;
    public static Planet venus;
    public static Planet earth;
    public static Planet mars;
    public static Planet jupiter;
    public static Planet saturn;
    public static Planet uranus;
    public static Planet neptune;
    public static Moon earthMoon;
    public static Moon marsPhobosMoon;
    public static Moon marsDeimosMoon;
    public static Moon jupiterEuropaMoon;
    public static Moon jupiterGanymedeMoon;
    public static Moon jupiterCallistoMoon;
    public static Moon jupiterIoMoon;
    public static Planet saturnRingElem1;
    public static Planet saturnRingElem2;
    public static Planet saturnRingElem3;
    public static Planet saturnRingElem4;

    public static int SYSTEM_WIDTH = 1200;
    public static int SYSTEM_HEIGHT = 1000;

    public static void main(String[] args) {
        SolarSystem milkyWay = new SolarSystem(SYSTEM_WIDTH, SYSTEM_HEIGHT);

        sun = new Sun(milkyWay, 0, 0, 50, "#F9AE28");      // create sun object
        mercury = new Planet(milkyWay, 80, 0, 15, "#C2B396", 1.60745467);
        venus = new Planet(milkyWay, 100, 0, 25, "#DBAB3F", 1.17595702);
        earth = new Planet(milkyWay, 150, 0, 37, "#0C0E3F", 1);     // create earth object
        mars = new Planet(milkyWay, 220, 0, 30, "#D66038", 0.806145064);
        jupiter = new Planet(milkyWay, 370, 0, 46, "#A45934", 0.438885158);
        saturn = new Planet(milkyWay, 415, 0, 33, "#BC9154", 0.325386165);
        uranus = new Planet(milkyWay, 440, 0, 34, "2596BE", 0.228676964);
        neptune = new Planet(milkyWay, 480, 0, 34, "#4269FD", 0.182337139);

        earthMoon = new Moon(milkyWay, earth, 32, 0, 10, "GREY", 0, earth.getDistance(), 0.034295302); // 0.034295302 speed relative to earth(1)
        marsPhobosMoon = new Moon(milkyWay, mars, 25, 0, 7, "#97897F", 0, mars.getDistance(), 0.0717449664);
        marsDeimosMoon = new Moon(milkyWay, mars, 25, 0, 7, "#907C6F", 0, mars.getDistance(), 0.0453456376);
        jupiterEuropaMoon = new Moon(milkyWay, jupiter, 30, 0, 10, "#A38770", 0, jupiter.getDistance(), 0.461073826);
        jupiterGanymedeMoon = new Moon(milkyWay, jupiter, 30, 0, 5, "#6D5A4A", 0, jupiter.getDistance(), 0.365100671);
        jupiterCallistoMoon = new Moon(milkyWay, jupiter, 30, 0, 5, "#434135", 0, jupiter.getDistance(), 0.275167785);
        jupiterIoMoon = new Moon(milkyWay, jupiter, 30, 0, 5, "#D5C85C", 0, jupiter.getDistance(), 0.581677852);

        saturnRingElem1 = new Planet(milkyWay, saturn.getDistance(), 0, 92, "GREY", saturn.getRateOfRotation());
        saturnRingElem2 = new Planet(milkyWay, saturn.getDistance(), 0, 65, "BLACK", saturn.getRateOfRotation());
        saturnRingElem3 = new Planet(milkyWay, saturn.getDistance(), 0, 53, "GREY", saturn.getRateOfRotation());
        saturnRingElem4 = new Planet(milkyWay, saturn.getDistance(), 0, 33, "BLACK", saturn.getRateOfRotation());

        Planet planets[] = {mercury, 
                            venus, 
                            earth, 
                            mars, 
                            jupiter, 
                            saturn, 
                            uranus, 
                            neptune};

        Moon moons[] = {earthMoon,
                        marsPhobosMoon,
                        marsDeimosMoon,
                        jupiterEuropaMoon,
                        jupiterGanymedeMoon,
                        jupiterCallistoMoon,
                        jupiterIoMoon};

        Planet ringElements[] = {saturnRingElem1,
                                saturnRingElem2,
                                saturnRingElem3,
                                saturnRingElem4};

        while (true) {
            // Draw all objects and intitiate orbit function for each

            sun.draw();
            for (Planet obj : ringElements) {
                obj.draw();
            }
            for (Planet obj : planets) {
                obj.draw();
            }
            for (Moon obj : moons) {
                obj.draw();
            }

            for (Planet obj : ringElements) {
                obj.orbit();
            }
            for (Planet obj : planets) {
                obj.orbit();
            }
            for (Moon obj : moons) {
                obj.orbit();
            }

            milkyWay.finishedDrawing();
        }
    }
}
