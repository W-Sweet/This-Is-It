package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    PWMSparkMax intake;

    public Intake(){
        intake = new PWMSparkMax(Constants.intakeMotor);
        intake.setInverted(true);

    }

@Override


}