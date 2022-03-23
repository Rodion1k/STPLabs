package IT_company.administrators;

import IT_company.Worker;
import IT_company.programmers.Programmer;
import IT_company.programmers.SkillsLevel;

public class NetworkAdministrator extends Worker implements IAdministrative {
    private static float coefficient = 1.2f;

    public NetworkAdministrator(byte workExperience, SkillsLevel skillsLevel, float salary) {
        super(workExperience, skillsLevel, salary);
    }


    @Override
    public void setSalary(float salary) {
        super.setSalary(salary*coefficient);
    }

    @Override
    public void startWork() {
        super.startWork();
        startManage();
    }
    @Override
    public String toString() {
        return String.format("Network Admin: workExperience = %d, skillsLevel = %s, salary = %f", getWorkExperience(), getSkillsLevel(), getSalary());
    }

    @Override
    public void startManage() {
        System.out.println("Network Admin start manage");
    }
}
