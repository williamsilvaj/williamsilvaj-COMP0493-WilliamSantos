public class Geometry {

    // Classe que representa um ponto no plano cartesiano
    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Calcula a distância entre dois pontos
    public static double distanceBetweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    // Calcula a distância entre um ponto e uma reta Ax + By + C = 0
    public static double distancePointToLine(Point p, double A, double B, double C) {
        return Math.abs(A * p.x + B * p.y + C) / Math.sqrt(A * A + B * B);
    }

    // Calcula a área da seção transversal (área do triângulo formado por três pontos)
    public static double triangleArea(Point p1, Point p2, Point p3) {
        return Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0);
    }

    // Verifica se três pontos são colineares (área do triângulo é zero)
    public static boolean areCollinear(Point p1, Point p2, Point p3) {
        return triangleArea(p1, p2, p3) == 0;
    }
}
