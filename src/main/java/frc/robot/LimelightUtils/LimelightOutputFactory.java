package frc.robot.LimelightUtils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import frc.robot.LimelightUtils.LimelightControlModes.*;

public class LimelightOutputFactory {
    private NetworkTable mTable;
    String mTableName;

    public LimelightOutputFactory(){
        mTableName = "limelight";
        mTable = NetworkTableInstance.getDefault().getTable(mTableName);
    }

    public LimelightOutputFactory(String tableName) {
        mTableName = tableName;
        mTable = NetworkTableInstance.getDefault().getTable(mTableName);
    }

    //Whether there are targets?
    public boolean isTargetFound() {
        NetworkTableEntry tv = mTable.getEntry("tv");
        double v = tv.getDouble(0.0);
        if(v == 0.0f) {
            return false;
        }
        else {
            return true;
        }
    }

    //Horizontal offset = -27 to 27 deg
    public double getHorizontalOffsetToTarget() {
        NetworkTableEntry tx = mTable.getEntry("tx");
        double x = tx.getDouble(0.0);
        return x;
    }

    //Vertical Offset = -20.5 to 20.5 deg
    public double getVerticalOffsetToTarget() {
        NetworkTableEntry ty = mTable.getEntry("ty");
        double y = ty.getDouble(0.0);
        return y;
    }

    //Target area = 0% - 100% of image
    public double getTargetArea() {
        NetworkTableEntry ta = mTable.getEntry("ta");
        double a = ta.getDouble(0.0);
        return a;
    }

    //Target skew = -90 or 0 degrees
    public double  getTargetSkew() {
        NetworkTableEntry ts = mTable.getEntry("ts");
        double s = ts.getDouble(0.0);
        return s;
    }

    //Pipeline Latency
    public double getPipelineLatency() {
        NetworkTableEntry tl = mTable.getEntry("tl");
        double l = tl.getDouble(0.0);
        return l;
    }

    private void resetPipelineLatency() {
        mTable.getEntry("tl").setValue(0.0);
    }

    //LED Modes are kon, koff, kblink
    public void setLEDMode(LEDMode ledMode) {
        mTable.getEntry("ledMode").setValue(ledMode.getValue());
    }

    //Current LEDMode
    public LEDMode getLEDMode() {
        NetworkTableEntry ledMode = mTable.getEntry("ledMode");
        double led = ledMode.getDouble(0.0);
        LEDMode mode = LEDMode.getByValue(led);
        return mode;
    }

    //Set Camera Mode -> Vision Processing Mode / Driver Mode
    public void setCamMode(CAMMode camMode) {
        mTable.getEntry("camMode").setValue(camMode.getValue());
    }

    //Current CameraMode
    public CAMMode getCamMode() {
        NetworkTableEntry camMode = mTable.getEntry("camMode");
        double cam = camMode.getDouble(0.0);
        CAMMode mode = CAMMode.getByValue(cam);
        return mode;
    }

    //Set Limelight Pipeline
    public void setPipeline(Integer pipeline) {
        if(pipeline<0){
            pipeline = 0;
            throw new IllegalArgumentException("Pipeline can not be less than zero");
        }else if(pipeline>9){
            pipeline = 9;
            throw new IllegalArgumentException("Pipeline can not be greater than nine");
        }
        mTable.getEntry("pipeline").setValue(pipeline);
    }

    //Get Limelight Pipeline
    public double getPipeline(){
        NetworkTableEntry pipeline = mTable.getEntry("pipeline");
        double pipe = pipeline.getDouble(0.0);
        return pipe;
    }

    //Get Limelight Pipeline Integer
    public Integer getPipelineInt(){
        NetworkTableEntry pipeline = mTable.getEntry("pipeline");
        Integer pipe = (int) pipeline.getDouble(0.0);
        return pipe;
    }

}
