package presenter;

public class Position {
		private double x, y;
		
		public Position() {
			this.x = 0;
			this.y = 0;
		}
		
		public Position(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public void move(double x, double y) {
			this.x += x;
			this.y += y;
		}
		
		public double getX() {
			return this.x;
		}
		
		public double getY() {
			return this.y;
		}
		
		public double distance(Position p) {
			double dx, dy;
			
			dx = p.getX() - this.getX();
			dy = p.getY() - this.getY();
			return Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2));
		}
	}