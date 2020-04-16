
public class PolarPoint extends Point{
    public double r;
    public double theta;

    public PolarPoint(double r, double theta){
        super(r*Math.cos(theta*Math.PI/180), r*Math.sin(theta*Math.PI/180));
        this.r = r;
        this.theta = theta;
    }

    @Override
    public double distFromOrigin(){
        return this.r;
    }

    @Override
    public void setX(double x){
        super.setX(x);
        this.r = super.distFromOrigin();
        this.theta = Math.atan2(this.getY(), this.getX())*180/Math.PI;
    }
    @Override
    public void setY(double y){
        super.setY(y);
        this.r = super.distFromOrigin();
        this.theta = Math.atan2(this.getY(), this.getX())*180/Math.PI;
    }
}