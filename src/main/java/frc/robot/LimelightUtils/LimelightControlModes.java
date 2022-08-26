package frc.robot.LimelightUtils;

import java.util.HashMap;
import java.util.Map;

public class LimelightControlModes {

    public enum LEDMode {
        kPipeline(0),
        kForceOff(1),
        kForceBlink(2),
        kForceOn(3);

        private static final Map<Double, LEDMode> LEDMAP = new HashMap<Double, LEDMode>();

        static {
            for (LEDMode ledMode : values()) {
                LEDMAP.put(ledMode.getValue(), ledMode);
            }
        }

        private double value;

        private LEDMode(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public static LEDMode getByValue(double value) {
            return LEDMAP.get(value);
        }

        public String toString() {
            return name();
        }
    }

    public enum CAMMode {
        kVPMode(0),
        kDriverMode(1);

        private static final Map<Double, CAMMode> CAMMAP = new HashMap<Double, CAMMode>();

        static {
            for (CAMMode camMode : values()) {
                CAMMAP.put(camMode.getValue(), camMode);
            }
        }

        private double value;

        private CAMMode(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public static CAMMode getByValue(double value) {
            return CAMMAP.get(value);
        }

        public String toString() {
            return name();
        }
    }

}
