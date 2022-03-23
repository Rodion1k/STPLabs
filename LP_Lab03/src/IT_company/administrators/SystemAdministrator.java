package IT_company.administrators;

import IT_company.Worker;
import IT_company.programmers.SkillsLevel;

public class SystemAdministrator extends Worker implements IAdministrative {

    private static float coefficient = 1.2f;


    public SystemAdministrator(byte workExperience, SkillsLevel skillsLevel, float salary) {
        super(workExperience, skillsLevel, salary);
    }

    public void setSalary(float salary) {
       super.setSalary(salary*coefficient);
    }

    @Override
    public String toString() {
        return String.format("System admin: workExperience = %d, skillsLevel = %s, salary = %f", getWorkExperience(), getSkillsLevel(), getSalary());
    }
    @Override
    public void startWork() {
        super.startWork();
        startManage();
    }
    @Override
    public void startManage() {
        System.out.println("System Admin start manage");
    }
}
